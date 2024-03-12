package com.gasutility.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gasutility.entities.User;
import com.gasutility.repo.UserRepository;
import com.gasutility.service.UserService;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserById(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        return userOptional.orElse(null);
    }

	@Override
	public User createUser(User user) {
		return this.userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return this.userRepository.findAll();
	}

	@Override
	public User updateUser(Long id, User user) {
		
		User exitinguser=userRepository.findById(id).orElseThrow();
		if(exitinguser != null)
		{
			exitinguser.setUsername(user.getUsername());
			
			return this.userRepository.save(exitinguser);
			
			
		}
		
		return null;
	}

	@Override
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
		
	}

	@Override
	public User getByUser(Long id) {
		return this.userRepository.findById(id).orElseThrow();
	}
    
    
}
