package com.aggggar.simpleandroid_mvvm.ui.main;

import android.os.Bundle;

import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.aggggar.simpleandroid_mvvm.R;
import com.aggggar.simpleandroid_mvvm.ui.base.BaseActivity;
import com.aggggar.simpleandroid_mvvm.ui.main.adapter.TopRatedMoviesPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    private MainViewModel mainViewModel;

    @BindView(R.id.pagerMovies)
    ViewPager pagerMovies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mainViewModel.getIsLoading().observe(this, aBoolean -> {
            if (aBoolean){
                showProgress();
            } else {
                dismissProgress();
            }
        });
        mainViewModel.getTopRatedMovie().observe(this, movieListItem -> {
            pagerMovies.setAdapter(new TopRatedMoviesPagerAdapter(movieListItem.getResults()));
        });
    }

    @Override
    public int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    public boolean setToolbar() {
        return true;
    }

    @Override
    public boolean hideStatusBar() {
        return false;
    }
}
