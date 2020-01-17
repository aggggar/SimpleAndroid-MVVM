package com.aggggar.simpleandroid_mvvm.ui.main;

import android.os.Bundle;

import com.aggggar.simpleandroid_mvvm.R;
import com.aggggar.simpleandroid_mvvm.ui.base.BaseActivity;

import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
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
