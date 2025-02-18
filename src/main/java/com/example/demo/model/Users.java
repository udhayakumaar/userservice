package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Users {

	@Id
    private Long userid;
    private String name;
    private String email;
    private String password;
    
    public Users(String name, String email, String password) {
    	this.name = name;
    	this.email = email;
    	this.password = password;
    }
}
