package com.aggggar.simpleandroid_mvvm.ui.base;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


public class BaseViewModel extends ViewModel {
    private MutableLiveData<Boolean> isLoading = new MutableLiveData<>();


    public MutableLiveData<Boolean> getIsLoading() {
        return isLoading;
    }

    public void setIsLoading(Boolean isLoading) {
        this.isLoading.postValue(isLoading);
    }

}
