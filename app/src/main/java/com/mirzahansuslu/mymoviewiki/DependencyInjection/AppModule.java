package com.mirzahansuslu.mymoviewiki.DependencyInjection;

import com.mirzahansuslu.mymoviewiki.Network.APIService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


@Module
@InstallIn(SingletonComponent.class)


public class AppModule {

    String baseURL = "https://www.simplifiedcoding.net/demos/";

    @Singleton
    @Provides
    public APIService getRetroServiceInterface(Retrofit retrofit) {
        return retrofit.create(APIService.class);
    }

    @Singleton
    @Provides
    public Retrofit getRetroInstance() {
        return new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
