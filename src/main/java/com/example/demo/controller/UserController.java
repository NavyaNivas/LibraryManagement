package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("users")
public class UserController {
	@Autowired
	UserService userservice;
	
	@GetMapping("/home")
	public String home()
	{
		return "Welcome!! Library Management application..";
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<User>> getAll()
	{
		try
		{
			return new ResponseEntity<>(userservice.getusers(),HttpStatus.OK);
		}
		catch (Exception e) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PostMapping("/add")
	public ResponseEntity<User> addUser(@RequestBody User user)
	{
		try
		{
			return new ResponseEntity<>(userservice.add(user),HttpStatus.CREATED);
		}
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
		
		
		try
		{
			return new ResponseEntity<>(userservice.update(id,user),HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
		
		}
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable long id)
	{
		try
		{
			userservice.delete(id);
			return new ResponseEntity<>("User Deleted",HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		}
	}
	
	@GetMapping("get/{id}")
	public ResponseEntity<User> getUserByID(@PathVariable long id)
	{
		try
		{
			
			return new ResponseEntity<>(userservice.getById(id),HttpStatus.FOUND);
		}
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		}
	}
	
	@GetMapping("getbyname/{name}")
	public ResponseEntity<User> getUserByID(@PathVariable String name)
	{
		try
		{
			
			return new ResponseEntity<>(userservice.getByName(name),HttpStatus.FOUND);
		}
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		}
	}

	
}
