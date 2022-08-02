package com.spring.couchbase.controller;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.couchbase.model.User;
import com.spring.couchbase.repository.UserRepository;


@RestController
public class UserController {

	@Autowired
	private UserRepository userRep;
	
	@PostMapping("/addUser")
	public User userAdd(@RequestBody User user) {
		userRep.save(user);
		return user;
	}
	
	@GetMapping("/allUsers")
	public Iterable<User> getAllUsers(){
		return userRep.findAll();
	}
}
