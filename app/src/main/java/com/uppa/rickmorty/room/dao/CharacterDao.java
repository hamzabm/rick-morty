package com.uppa.rickmorty.room.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.uppa.rickmorty.network.model.Character;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface CharacterDao {

    @Query("SELECT * FROM characters")
    List<Character> getAll();

    @Query("SELECT * FROM characters where id = :id")
    Character getById(String id);


    @Insert
    void insertAll(ArrayList<Character> characters);

    @Query("DELETE FROM characters")
    void deleteAll();
}

