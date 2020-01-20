package com.aggggar.simpleandroid_mvvm.ui.main;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.aggggar.simpleandroid_mvvm.data.api.ApiClient;
import com.aggggar.simpleandroid_mvvm.model.MovieListItem;
import com.aggggar.simpleandroid_mvvm.ui.base.BaseViewModel;
import com.aggggar.simpleandroid_mvvm.utils.Constants;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainViewModel extends BaseViewModel {

    public LiveData<MovieListItem> getTopRatedMovie(){
        MutableLiveData<MovieListItem> listItemLiveData = new MutableLiveData<>();
        ApiClient.getApiInterface().getTopRatedMovies(
                Constants.API_KEY,
                "en-US",
                1).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<MovieListItem>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        setIsLoading(true);
                    }

                    @Override
                    public void onSuccess(MovieListItem movieListItem) {
                        setIsLoading(false);
                        listItemLiveData.setValue(movieListItem);
                    }

                    @Override
                    public void onError(Throwable e) {
                        setIsLoading(false);
                    }
                });

        return listItemLiveData;
    }

}
