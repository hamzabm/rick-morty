package com.uppa.rickmorty;

import android.app.Application;

import androidx.room.Dao;
import androidx.room.Room;

import com.uppa.rickmorty.room.RickMortyDataBase;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RickMortyApplication extends Application {

    RickMortyDataBase db;
    Retrofit retrofit;

    public RickMortyDataBase getDb() {
        return db;
    }



    public Retrofit getRetrofit() {
        return retrofit;
    }



    @Override
    public void onCreate() {
        super.onCreate();

        db = Room.databaseBuilder(getApplicationContext(),
                RickMortyDataBase.class, "rick_morty_db").allowMainThreadQueries().build();
        retrofit = new Retrofit.Builder()
                .addConverterFactory( GsonConverterFactory.create())
                .baseUrl("https://623b4baf2e056d1037f07a74.mockapi.io/")
                .build();
    }
}
