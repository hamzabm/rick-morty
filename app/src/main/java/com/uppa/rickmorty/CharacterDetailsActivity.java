package com.uppa.rickmorty;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.uppa.rickmorty.databinding.ActivityCharacterDetailsBinding;
import com.uppa.rickmorty.network.Api;
import com.uppa.rickmorty.network.model.Character;

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
        Call<Character> planetsCall = service.getInfo(id);
        planetsCall.enqueue(new Callback<Character>() {
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
        setContentView(ui.getRoot());

    }
}