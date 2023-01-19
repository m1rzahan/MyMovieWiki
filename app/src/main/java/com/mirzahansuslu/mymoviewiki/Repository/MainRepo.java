package com.mirzahansuslu.mymoviewiki.Repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.mirzahansuslu.mymoviewiki.Common.Common;
import com.mirzahansuslu.mymoviewiki.Db.MovieDatabaseHelper;
import com.mirzahansuslu.mymoviewiki.Model.MovieModel;
import com.mirzahansuslu.mymoviewiki.Network.APIService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainRepo {
    private static final String TAG = "MainRepo";
    private APIService apiService;

    public MainRepo() {
        this.apiService = Common.getAPIService();
    }
    public MutableLiveData<List<MovieModel>> getMovieModelLiveData() {
        MutableLiveData<List<MovieModel>> data = new MutableLiveData<>();
        apiService.getMovieList().enqueue(new Callback<List<MovieModel>>() {
            @Override
            public void onResponse(Call<List<MovieModel>> call, Response<List<MovieModel>> response) {
                Log.e(TAG,"onResponse: "+response.code());
                if(response.isSuccessful()) {
                    data.setValue(response.body());

                }
                else {
                    data.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<List<MovieModel>> call, Throwable t) {
                Log.e(TAG,"onResponse: "+t.getMessage());
                data.setValue(null);

            }
        });
        return  data;
    }


}
