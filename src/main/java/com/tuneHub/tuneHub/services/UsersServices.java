package com.tuneHub.tuneHub.services;

import com.tuneHub.tuneHub.entity.Users;

public interface UsersServices {
	
	public void addUsers(Users user);
	public boolean emailExists(String email);
	public boolean validate(String email,String password);
	public String getRole(String email);
	public Users getUser(String email);
	
	public void updateUser(Users u);

}
