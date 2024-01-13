package com.tuneHub.tuneHub.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tuneHub.tuneHub.entity.Users;
import com.tuneHub.tuneHub.repository.UsersRepository;

@Service
public class UsersServicesImp implements UsersServices {

	@Autowired
	UsersRepository repo;

	@Override
	public void addUsers(Users user) {
		// TODO Auto-generated method stub
		repo.save(user);
	}

	@Override
	public boolean emailExists(String email) {
		// TODO Auto-generated method stub
		if (repo.findByEmail(email) == null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean validate(String email, String password) {
		Users us = repo.findByEmail(email);
		String db_pass = us.getPassword();
		if (password.equals(db_pass)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String getRole(String email) {
		// TODO Auto-generated method stub
		Users user = repo.findByEmail(email);
		return user.getRole();
	}

	@Override
	public Users getUser(String email) {
		return repo.findByEmail(email);
	}

	@Override
	public void updateUser(Users u) {
		// TODO Auto-generated method stub
		repo.save(u);
		
	}

}
