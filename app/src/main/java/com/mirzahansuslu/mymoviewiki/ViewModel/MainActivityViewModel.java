package com.mirzahansuslu.mymoviewiki.ViewModel;

import android.graphics.Movie;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.mirzahansuslu.mymoviewiki.MainActivity;
import com.mirzahansuslu.mymoviewiki.Model.MovieModel;
import com.mirzahansuslu.mymoviewiki.Repository.MainRepo;

import java.util.List;

public class MainActivityViewModel extends ViewModel {
    private final MainRepo mainRepo;

    public MainActivityViewModel() {
        mainRepo = new MainRepo();

    }
    public LiveData<List<MovieModel>> getMovieList() {
        return  mainRepo.getMovieModelLiveData();
    }

}
