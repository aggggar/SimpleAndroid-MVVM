package com.aggggar.simpleandroid_mvvm.utils;

import android.content.Context;
import android.widget.ImageView;

import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;

public class GlobalMethods {

    public static void setImageToView(Context context, ImageView imageView, String imagUrl){
        Glide.with(context)
                .load(imagUrl)
                .into(imageView);
    }
}
