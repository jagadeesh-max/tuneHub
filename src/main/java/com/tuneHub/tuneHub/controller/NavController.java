package com.tuneHub.tuneHub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavController {
	
	@GetMapping("/login")
	public String login()
	{
		return "login";
	}
	
	@GetMapping("/register")
	public String register()
	{
		return "register";
	}
	
	@GetMapping("/addsong")
	public String addsong()
	{
		return "addsong";
	}
	
	/*@GetMapping("/createPlaylist")
	public String createPlaylist()
	{
		return "createPlaylist";
	}*/
	
	
	
	

}
