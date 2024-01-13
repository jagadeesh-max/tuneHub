package com.tuneHub.tuneHub.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Playlist {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String name;
	@ManyToMany
	List<Song> Songs;
	public Playlist() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Playlist(int id, String name, List<Song> songs) {
		super();
		this.id = id;
		this.name = name;
		Songs = songs;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Song> getSongs() {
		return Songs;
	}
	public void setSongs(List<Song> songs) {
		Songs = songs;
	}
	@Override
	public String toString() {
		return "Playlist [id=" + id + ", name=" + name + ", Songs=" + Songs + "]";
	}
	
	

}
