package com.tuneHub.tuneHub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tuneHub.tuneHub.entity.Song;

public interface SongRepository extends JpaRepository<Song, Integer>{
	
	public Song findByName(String name);

}
