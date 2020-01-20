package com.aggggar.simpleandroid_mvvm.data.api;

import com.aggggar.simpleandroid_mvvm.model.MovieListItem;

import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("movie/top_rated")
    Single<MovieListItem> getTopRatedMovies(@Query("api_key") String apiKey,
                                            @Query("language") String language,
                                            @Query("page") int page);
}
