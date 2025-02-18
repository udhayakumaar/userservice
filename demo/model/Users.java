package com.example.demo.model;

import jakarta.persistence.Column;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userid;
	@Column(name = "firstname")
    private String firstName;
	@Column(name = "lastname")
    private String lastName;
	@Column(name = "username")
    private String userName;
    private String email;
    private String password;
    private String address;
    
    public Users() {
    	
    }
    
    public Users(String firstName, String lastName, String userName, String email, String password, String address) {
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.userName = userName;
    	this.email = email;
    	this.password = password;
    	this.address = address;
    }
}
