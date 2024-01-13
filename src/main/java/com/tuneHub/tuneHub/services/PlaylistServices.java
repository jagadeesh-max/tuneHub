package com.tuneHub.tuneHub.services;

import java.util.List;

import com.tuneHub.tuneHub.entity.Playlist;

public interface PlaylistServices {
	
	public void addPlaylist(Playlist playlist);
	
	public List<Playlist> fetchAllPlaylists();

}
