package com.tuneHub.tuneHub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tuneHub.tuneHub.entity.Playlist;
import com.tuneHub.tuneHub.entity.Song;
import com.tuneHub.tuneHub.services.PlaylistServices;
import com.tuneHub.tuneHub.services.SongServices;

@Controller
public class PlayListController {
	
	@Autowired
	SongServices ss;
	
	@Autowired
	PlaylistServices ps; 
	
	@GetMapping("/createplaylist")
	public String createPlaylist(Model model)
	{
		List<Song> songlist= ss.fetchAllSongs();
		model.addAttribute("songs", songlist);
		return "createPlaylist";
	}
	
	@PostMapping("/addPlaylist")
	public String addPlaylist(@ModelAttribute Playlist playlist)
	{
		ps.addPlaylist(playlist);
	//	System.out.println(playlist);
		List<Song> ls=playlist.getSongs();
		for(Song s:ls)
		{
			s.getPlaylists().add(playlist);
			ss.updateSong(s);
		}
		return "admin";
	}
	
	@GetMapping("/viewallplaylists")
	public String viewAllPlaylists(Model model)
	{
		List<Playlist>allplaylist=ps.fetchAllPlaylists();
		model.addAttribute("playlist", allplaylist);
		return "displayPlaylist";
	}

}
