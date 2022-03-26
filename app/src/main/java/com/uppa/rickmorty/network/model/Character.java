package com.uppa.rickmorty.network.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "characters")
public class Character{

	@SerializedName("image")
	private String image;

	@SerializedName("gender")
	private String gender;

	@SerializedName("species")
	private String species;

	@SerializedName("origin")
	private String origin;

	@SerializedName("name")
	private String name;
@PrimaryKey
@NonNull
	@SerializedName("id")
	private String id;

	@SerializedName("status")
	private String status;

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}