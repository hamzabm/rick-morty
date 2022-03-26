package com.uppa.rickmorty;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.uppa.rickmorty.adapters.CharactersAdapter;
import com.uppa.rickmorty.adapters.EpisodesAdapter;
import com.uppa.rickmorty.databinding.ActivityCharacterDetailsBinding;
import com.uppa.rickmorty.network.Api;
import com.uppa.rickmorty.network.model.Character;
import com.uppa.rickmorty.network.model.Episode;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CharacterDetailsActivity extends AppCompatActivity {
ActivityCharacterDetailsBinding ui ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String id= getIntent().getStringExtra("id");
        ui= ActivityCharacterDetailsBinding.inflate(getLayoutInflater());

        RickMortyApplication  application = ( (RickMortyApplication) getApplicationContext() );


        Api service = application.getRetrofit().create(Api.class);
        Call<Character> apiCall = service.getInfo(id);
        apiCall.enqueue(new Callback<Character>() {
            @Override
            public void onResponse(Call<Character> call, Response<Character> response) {
                Character character = response.body();
                ui.name.setText(character.getName());
                ui.type.setText(character.getSpecies());
                ui.status.setText(character.getStatus());
                Glide.with(ui.getRoot()).load(character.getImage()).into(ui.logo);
            }

            @Override
            public void onFailure(Call<Character> call, Throwable t) {
                Character character = application.db.characterDao().getById(id);
                if(character!=null){
                    ui.name.setText(character.getName());
                    ui.type.setText(character.getSpecies());
                    ui.status.setText(character.getStatus());
                    Glide.with(ui.getRoot()).load(character.getImage()).into(ui.logo);
                }
            }
        });

        Call<List<Episode>> apiCallEpisodes = service.getEpisodes(id);
        LinearLayoutManager lm = new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL,false);
        ui.episodesRv.setLayoutManager(lm);
        apiCallEpisodes.enqueue(new Callback<List<Episode>>() {
            @Override
            public void onResponse(Call<List<Episode>> call, Response<List<Episode>> response) {
                ArrayList<Episode> episodes;
                episodes = new ArrayList(response.body());
                if(application.getDb().episodeDao().getAllById(id).size()>0){
                    application.getDb().episodeDao().deleteAll();
                }
                application.getDb().episodeDao().insertAll(episodes);
                EpisodesAdapter episodesAdapter = new EpisodesAdapter(episodes);
                ui.episodesRv.setAdapter(episodesAdapter);
            }

            @Override
            public void onFailure(Call<List<Episode>> call, Throwable t) {
                ArrayList<Episode> episodes=new ArrayList(application.getDb().episodeDao().getAllById(id));
                if(episodes.size()>0){
                    EpisodesAdapter episodesAdapter = new EpisodesAdapter(episodes);
                    ui.episodesRv.setAdapter(episodesAdapter);
                }
            }
        });
        setContentView(ui.getRoot());

    }
}