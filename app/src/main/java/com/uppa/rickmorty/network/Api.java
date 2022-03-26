package com.uppa.rickmorty.network;

import com.uppa.rickmorty.network.model.Character;
import com.uppa.rickmorty.network.model.Episode;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Api {
        @GET("/api/characters/")
        Call<List<Character>> getAllCharacers();

        @GET("/api/characters/{idCharacter}")
        Call<Character> getInfo(@Path("idCharacter") String id);

        @GET("/api/characters/{idCharacter}/episodes")
        Call<List<Episode>> getEpisodes(@Path("idCharacter") String  id);
}
