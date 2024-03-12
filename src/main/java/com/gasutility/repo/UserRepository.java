package com.gasutility.repo;
import org.springframework.data.jpa.repository.JpaRepository;

import com.gasutility.entities.User;

//user repository
public interface UserRepository extends JpaRepository<User, Long> {
	
}
