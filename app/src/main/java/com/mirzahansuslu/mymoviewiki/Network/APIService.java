package com.mirzahansuslu.mymoviewiki.Network;
import com.mirzahansuslu.mymoviewiki.Model.MovieModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
public interface APIService {
    @GET("marvel")
    Call<List<MovieModel>> getMovieList();
}
