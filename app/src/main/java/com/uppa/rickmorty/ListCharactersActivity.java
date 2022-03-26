package com.uppa.rickmorty;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.uppa.rickmorty.adapters.CharactersAdapter;
import com.uppa.rickmorty.databinding.ActivityListCharactersBinding;
import com.uppa.rickmorty.network.Api;
import com.uppa.rickmorty.network.model.Character;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListCharactersActivity extends AppCompatActivity {
    ActivityListCharactersBinding ui ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ui = ActivityListCharactersBinding.inflate(getLayoutInflater());
        RickMortyApplication  application = ( (RickMortyApplication) getApplicationContext() );
        Api service = application.getRetrofit().create(Api.class);
        Call<List<Character>> planetsCall = service.getAllCharacers();
        LinearLayoutManager lm = new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL,false);
        ui.listChars.setLayoutManager(lm);
        planetsCall.enqueue(new Callback<List<Character>>() {
            @Override
            public void onResponse(Call<List<Character>> call, Response<List<Character>> response) {
                ArrayList<Character> characters;
                characters = new ArrayList(response.body());
                if(application.getDb().characterDao().getAll().size()>0){
                    application.getDb().characterDao().deleteAll();
                }
                application.getDb().characterDao().insertAll(characters);
                CharactersAdapter planetsAdapter = new CharactersAdapter(characters);
                planetsAdapter.setOnItemClickListener(postition -> {
                    Intent detail = new Intent(getApplicationContext(),CharacterDetailsActivity.class);
                    detail.putExtra("id",characters.get(postition).getId());
                    startActivity(detail);
                });
                ui.listChars.setAdapter(planetsAdapter);
            }

            @Override
            public void onFailure(Call<List<Character>> call, Throwable t) {
            Log.d("Log",t.getMessage());
                ArrayList<Character> characters=new ArrayList(application.getDb().characterDao().getAll());
                if(characters.size()>0){
                    CharactersAdapter planetsAdapter = new CharactersAdapter(characters);
                    planetsAdapter.setOnItemClickListener(postition -> {
                    Intent detail = new Intent(getApplicationContext(),CharacterDetailsActivity.class);
                    detail.putExtra("id",characters.get(postition).getId());
                    startActivity(detail);
                });
                ui.listChars.setAdapter(planetsAdapter);
                }
            }
        });
        setContentView(ui.getRoot());
    }
}