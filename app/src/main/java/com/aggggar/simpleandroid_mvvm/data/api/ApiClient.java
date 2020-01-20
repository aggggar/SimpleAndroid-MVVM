package com.aggggar.simpleandroid_mvvm.data.api;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static Retrofit getRetrofit(){
        return new Retrofit.Builder()
                .baseUrl(ApiEndPoints.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(getOkHttpClient().build())
                .build();
    }

    private static OkHttpClient.Builder getOkHttpClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .build();
        httpClient.addInterceptor(logging);
        return httpClient;
    }

    public static ApiInterface getApiInterface(){
        return getRetrofit().create(ApiInterface.class);
    }
}
