package com.aggggar.simpleandroid_mvvm.ui.base;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;

import com.aggggar.simpleandroid_mvvm.R;
import com.aggggar.simpleandroid_mvvm.ui.dialogs.ProgressDialogFragment;


public abstract class BaseActivity extends AppCompatActivity {

    private DialogFragment progressDialogFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (hideStatusBar()) {
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }

        setContentView(setLayout());

        if (setToolbar()) {
            Toolbar toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            onBackPressed();
        }
        return true;
    }

    public void showProgress(){
        progressDialogFragment = new ProgressDialogFragment();
        progressDialogFragment.show(getSupportFragmentManager(), null);
    }

    public void dismissProgress(){
        if (progressDialogFragment != null) {
            progressDialogFragment.dismiss();
        }
    }

    public abstract int setLayout();

    public abstract boolean setToolbar();

    public abstract boolean hideStatusBar();
}
