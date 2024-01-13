package com.tuneHub.tuneHub.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tuneHub.tuneHub.entity.Song;
import com.tuneHub.tuneHub.repository.SongRepository;

@Service
public class SongServicesImp implements SongServices {
	
	@Autowired
	SongRepository sr;
	

	@Override
	public void addSong(Song s) {
		// TODO Auto-generated method stub
		sr.save(s);	
	}


	@Override
	public List<Song> fetchAllSongs() {
		
		return sr.findAll();
	}


	@Override
	public boolean songExists(String song) {
		
		Song s=sr.findByName(song);
		if(s==null)
		{
			return false;
		}
		else
		{
			return true;
		}
	}


	@Override
	public void updateSong(Song s) {
		// TODO Auto-generated method stub
		
		sr.save(s);
		
	}

}
