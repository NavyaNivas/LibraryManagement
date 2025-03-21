package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.demo.model.User;
import com.example.demo.repo.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo userRepo;
	//private PasswordEncoder passwordEncoder;
	private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);

	public List<User> getusers() {
		
		return userRepo.findAll();
		
	}

	public User add(User user) {
		
		
		String hashedpwd = encoder.encode(user.getPassword());
		user.setPassword(hashedpwd);
		return userRepo.save(user);
	}

	public User  update(Long id, User updatedUser) {
		
		User existingUser  = userRepo.findById(id).get();
		existingUser.setUserName(updatedUser.getUserName());
		existingUser.setPassword(updatedUser.getPassword());
		existingUser.setRole(updatedUser.getRole());
		existingUser.setEmailId(updatedUser.getEmailId());
		return userRepo.save(existingUser);
		
		
	}

	public void delete(long id) {
		userRepo.deleteById(id);
	}

	public User getById(long id) {
		
		return userRepo.findById(id).get();
	}

	public User getByName(String name) {
	  User user= userRepo.findByuserName(name).orElseThrow(()->new UsernameNotFoundException("User not found: " + name));
	  return user;
		
	}
	

}
