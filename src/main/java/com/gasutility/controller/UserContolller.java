package com.gasutility.controller;
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

import com.gasutility.entities.User;
import com.gasutility.service.UserService;

//it is user controller
@RestController
@RequestMapping("/user")
public class UserContolller {
	
	
	@Autowired
	private UserService userService;
	
	
//it save user
	@PostMapping
	ResponseEntity<User> saveUser(@RequestBody User user)
	{
		User  saveUser=userService.createUser(user);
		return new ResponseEntity<> (saveUser,HttpStatus.CREATED);
	}
	
//it fetch all users list
    @GetMapping
    ResponseEntity<List<User>> getAllUsers()
    {
    	List<User> users=userService.getAllUser();
    	return new ResponseEntity<> (users,HttpStatus.OK);
    }
    
    
 //it update the existing user
    @PutMapping("/{id}")
    ResponseEntity<User> updateUser(@PathVariable Long id,@RequestBody User user)
    {
    	User updateUser=userService.updateUser(id, user);
    	return new ResponseEntity<>(updateUser,HttpStatus.OK);
    }
    
//it delete user by id of user
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteUser(@PathVariable Long id)
    {
    	userService.deleteUser(id);
    	return new ResponseEntity<>(HttpStatus.CONFLICT);
    }
    
//it fetch user by its id 
    @GetMapping("/{id}")
    ResponseEntity<User> getByUser(@PathVariable Long id)
    {
    	User user=userService.getByUser(id);
    	return new ResponseEntity<> (user,HttpStatus.OK); 
    }
}
