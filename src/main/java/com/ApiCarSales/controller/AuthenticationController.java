package com.ApiCarSales.controller;

import org.springframework.beans.factory.annotation.Autowired;



import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ApiCarSales.Repository.UserRepository;
import com.ApiCarSales.model.Users;
import com.ApiCarSales.model.vo.AuthenticationDTO;
import com.ApiCarSales.model.vo.RegisterDTO;
import com.ApiCarSales.security.TokenService;
import com.ApiCarSales.model.vo.LoginResponseDTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private TokenService tokenService;

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody @Valid AuthenticationDTO data){
		
		var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
		var auth = this.authenticationManager.authenticate(usernamePassword);
		
		var token = tokenService.generateToken((Users) auth.getPrincipal());
		
		return ResponseEntity.ok(new LoginResponseDTO(token));
		
	}
	
	@PostMapping("/register")
	public  ResponseEntity<?> register(@RequestBody @Valid RegisterDTO data){
		
		if(this.repository.findByLogin(data.login()) != null) return ResponseEntity.badRequest().build();
		
		
		String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
		
		Users newUser = new Users(data.login(), encryptedPassword, data.role());
		
		this.repository.save(newUser);
		
		return ResponseEntity.ok().build();
		
	}
	
}
