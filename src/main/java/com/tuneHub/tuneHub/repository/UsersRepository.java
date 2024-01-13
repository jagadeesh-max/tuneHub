package com.tuneHub.tuneHub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tuneHub.tuneHub.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Integer>{
	
	public Users findByEmail(String email);

}
