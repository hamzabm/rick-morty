package com.uppa.rickmorty.room.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.uppa.rickmorty.network.model.Character;
import com.uppa.rickmorty.network.model.Episode;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface EpisodeDao {

    @Query("SELECT * FROM episodes")
    List<Episode> getAll();

    @Insert
    void insertAll(ArrayList<Episode> episodes);

    @Query("DELETE FROM episodes")
    void deleteAll();
}

