package com.ApiCarSales.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.ApiCarSales.model.Users;

public interface UserRepository extends JpaRepository<Users, String>{

	UserDetails findByLogin(String login);
	
}
