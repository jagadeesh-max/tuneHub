package com.tuneHub.tuneHub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tuneHub.tuneHub.entity.Song;
import com.tuneHub.tuneHub.services.SongServices;

@Controller
public class SongController {
	
	@Autowired
	SongServices ss;
	
	
	@PostMapping("/AddSong")
	public String Addsong(@ModelAttribute Song song)
	{
		boolean userStatus=ss.songExists(song.getName());
		if(userStatus==false)
		{
			ss.addSong(song);
			System.out.println("song added");

		}
		else
		{
			System.out.println("song already exist");
		}
		return "admin";
	}
	
	@GetMapping("/viewSongs")
	public String viewSongs(Model model)
	{
		List<Song> songslist=ss.fetchAllSongs();
		model.addAttribute("songs", songslist);
		
		return "displaySongs";
	}
	
	@GetMapping("/playSongs")
	public String playSongs(Model model)
	{
		boolean premiumUser=false;
		if(premiumUser)
		{
			List<Song> songslist=ss.fetchAllSongs();
			model.addAttribute("songs", songslist);
			return "displaySongs";	
		}
		else
		{
			return "makePayments";
		}
	
	}

}
