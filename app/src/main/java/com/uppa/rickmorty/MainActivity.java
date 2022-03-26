package com.uppa.rickmorty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.uppa.rickmorty.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding ui;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ui= ActivityMainBinding.inflate(getLayoutInflater());
        ui.goToList.setOnClickListener(view -> {
            Intent listPageIntent = new Intent(this,ListCharactersActivity.class);
            startActivity(listPageIntent);
        });

        setContentView(ui.getRoot());
    }
}