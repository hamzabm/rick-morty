package com.uppa.rickmorty.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.uppa.rickmorty.network.model.Character;
import com.uppa.rickmorty.network.model.Episode;
import com.uppa.rickmorty.room.dao.CharacterDao;
import com.uppa.rickmorty.room.dao.EpisodeDao;

@Database(entities = {Character.class, Episode.class}, version = 1)
public abstract class RickMortyDataBase  extends RoomDatabase {
    public abstract CharacterDao characterDao();
    public abstract EpisodeDao episodeDao();
}
