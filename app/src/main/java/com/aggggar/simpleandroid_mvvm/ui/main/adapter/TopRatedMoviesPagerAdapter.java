package com.aggggar.simpleandroid_mvvm.ui.main.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.aggggar.simpleandroid_mvvm.R;
import com.aggggar.simpleandroid_mvvm.data.api.ApiEndPoints;
import com.aggggar.simpleandroid_mvvm.model.Movie;
import com.aggggar.simpleandroid_mvvm.utils.GlobalMethods;

import java.util.List;

public class TopRatedMoviesPagerAdapter extends PagerAdapter {
    private List<Movie> movieList;

    public TopRatedMoviesPagerAdapter(List<Movie> movieList){
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.pager_movie_item, container, false);
        Movie movie = movieList.get(position);
        GlobalMethods.setImageToView(container.getContext(),
                view.findViewById(R.id.ivMovieImage),
                ApiEndPoints.IMAGE_URL + movie.getPosterPath());
        ((TextView) view.findViewById(R.id.tvTitle)).setText(movie.getTitle());
        ((TextView) view.findViewById(R.id.tvOverView)).setText(movie.getOverview());
        ((TextView) view.findViewById(R.id.tvPopularity)).setText(String.valueOf(movie.getPopularity()));
        container.addView(view);
        return view;
    }

    @Override
    public int getCount() {
        return movieList.size();
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
}
