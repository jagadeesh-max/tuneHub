package com.tuneHub.tuneHub.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tuneHub.tuneHub.entity.Playlist;
import com.tuneHub.tuneHub.repository.PlayListRepository;

@Service
public class PlaylistServicesImp implements PlaylistServices {
	
	@Autowired
	PlayListRepository pr;

	@Override
	public void addPlaylist(Playlist playlist) {

		pr.save(playlist);
		
	}

	@Override
	public List<Playlist> fetchAllPlaylists() {
		// TODO Auto-generated method stub
		return pr.findAll();
	}

}
