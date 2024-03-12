package com.gasutility.service;

import java.util.List;

import com.gasutility.entities.User;

//user service
public interface UserService {
	
	User createUser(User user);
	
	List<User> getAllUser();
	
	User  updateUser(Long id,User user);
	
	
    void deleteUser(Long id);
	
    User getUserById(Long userId);
    
    User getByUser(Long id);

}
