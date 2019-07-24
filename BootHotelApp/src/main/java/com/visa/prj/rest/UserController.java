package com.visa.prj.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.visa.prj.entity.User;
import com.visa.prj.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping ("users")
	public @ResponseBody List<User> getUsers(){
		return userService.findAll();
	}
	
	@PostMapping("users")
	public ResponseEntity<User>  addUser(@RequestBody User u){
		userService.addUser(u);
		return new ResponseEntity<>(u,HttpStatus.CREATED);
	}
	
}
