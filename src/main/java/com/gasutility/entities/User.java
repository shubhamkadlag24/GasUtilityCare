package com.gasutility.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

//it is user entity
//table will generate name of gas_users because of @Table annotation
@Data
@Entity
public class User {

	
	//id field is primary Key of users table
	//generated value automatically increase value of id field sequentially 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;

}