package com.tuneHub.tuneHub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tuneHub.tuneHub.entity.Users;
import com.tuneHub.tuneHub.services.UsersServices;

import jakarta.servlet.http.HttpSession;

@Controller
public class UsersController {

	@Autowired
	UsersServices us;

	@PostMapping("/register")
	public String addUsers(@ModelAttribute Users user) {
		boolean userStatus = us.emailExists(user.getEmail());
		if (userStatus == false) {
			us.addUsers(user);
			System.out.println("User added");
			return "login";
		} else {
			System.out.println("User already exist");
			return "register";
		}

	}

	@PostMapping("/validate")
	public String validate(@RequestParam("email") String email, @RequestParam("password") String password,HttpSession session) {
		if (us.validate(email, password)) {
			String db_role = us.getRole(email);
			
			session.setAttribute("email", email);

			if (db_role.equals("Admin")) {
				return "admin";
			} else {
				return "customer";
			}
		} else {
			return "login";
		}
	}

	/*@GetMapping("/pay")
	public String pay(@RequestParam String email) {
		boolean paymentStatus = false;

		if(paymentStatus==true)
		{
		Users u = us.getUser(email);
		u.setPremium(true);
		us.updateUser(u);
		}

		return "login";
	}*/
	
	@GetMapping("/logout")
	public String logout(HttpSession session)
	{
		session.invalidate();
		return "login";
	}

}
