package com.mirzahansuslu.mymoviewiki;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.mirzahansuslu.mymoviewiki.Adapter.MovieListAdapter;
import com.mirzahansuslu.mymoviewiki.Db.MovieDatabaseHelper;
import com.mirzahansuslu.mymoviewiki.Model.MovieModel;
import com.mirzahansuslu.mymoviewiki.Repository.MainRepo;
import com.mirzahansuslu.mymoviewiki.ViewModel.MainActivityViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    MainActivityViewModel mainActivityViewModel;
    RecyclerView recyclerView;
    MovieListAdapter movieListAdapter;
    LinearLayoutManager linearLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        recyclerView = findViewById(R.id.recyclerView);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        mainActivityViewModel.getMovieList().observe(this,movieModels -> {
            Log.e("MainActivity","MovieList "+ movieModels.get(0).getName());
            if(movieModels!= null) {
                movieListAdapter = new MovieListAdapter(this,movieModels);
                movieListAdapter.notifyDataSetChanged();
                recyclerView.setAdapter(movieListAdapter);
            }
        });

    }
}