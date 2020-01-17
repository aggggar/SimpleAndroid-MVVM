package com.aggggar.simpleandroid_mvvm.ui.main.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

import com.aggggar.simpleandroid_mvvm.R;
import com.aggggar.simpleandroid_mvvm.model.Movie;

import java.util.List;

public class TopRatedMoviesAdapter extends RecyclerView.Adapter<TopRatedMoviesAdapter.ViewHold> {

    private List<Movie> movieList;

    public TopRatedMoviesAdapter(List<Movie> movieList) {
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public ViewHold onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_movie_item, parent, false);
        return new ViewHold(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHold holder, int position) {
        Movie movie = movieList.get(position);
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class ViewHold extends RecyclerView.ViewHolder {
        public ViewHold(@NonNull View itemView) {
            super(itemView);
        }
    }
}
