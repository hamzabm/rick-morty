package com.uppa.rickmorty.network.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "episodes")
public class Episode{

	@ColumnInfo(name = "air_date")
	@SerializedName("air_date")
	private String airDate;

	@ColumnInfo(name = "name")
	@SerializedName("name")
	private String name;

	@ColumnInfo(name = "episode")
	@SerializedName("episode")
	private String episode;

	@PrimaryKey
	@NonNull
	@ColumnInfo(name = "id")
	@SerializedName("id")
	private String id;

	@ColumnInfo(name = "characterId")
	@SerializedName("characterId")
	private String characterId;

	public void setAirDate(String airDate) {
		this.airDate = airDate;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEpisode(String episode) {
		this.episode = episode;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setCharacterId(String characterId) {
		this.characterId = characterId;
	}

	public String getAirDate(){
		return airDate;
	}

	public String getName(){
		return name;
	}

	public String getEpisode(){
		return episode;
	}

	public String getId(){
		return id;
	}

	public String getCharacterId(){
		return characterId;
	}
}