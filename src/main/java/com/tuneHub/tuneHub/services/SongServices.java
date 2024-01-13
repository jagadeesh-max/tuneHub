package com.tuneHub.tuneHub.services;

import java.util.List;

import com.tuneHub.tuneHub.entity.Song;

public interface SongServices {
	
	public void addSong(Song s);
	
	public List<Song> fetchAllSongs();
	
	public boolean songExists(String song);
	
	public void updateSong(Song s);

}
