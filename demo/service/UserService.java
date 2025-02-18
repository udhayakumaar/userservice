package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.model.Users;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
    private UserRepository userRepository;
	
	@Autowired
	private AuthenticationService authenticationService;
	
	private final PasswordEncoder passwordEncoder;
	
	public UserService(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

    public String registerUser(Users user) {
    	
    	Users users = new Users();
    	
    	if(null!=user.getEmail() && null!=user.getFirstName() && null!=user.getLastName()
    			&& null!=user.getUserName() && null!=user.getAddress()) {
    		users.setEmail(user.getEmail());
    		users.setFirstName(user.getFirstName());
    		users.setLastName(user.getLastName());
    		users.setUserName(user.getUserName());
    		users.setAddress(user.getAddress());
    	}
    	
    	if(null!=user.getPassword()) {
    		String encodedPassword = passwordEncoder.encode(user.getPassword());
    		users.setPassword(encodedPassword);
    	}
    	
    	userRepository.save(users);
    	
        return "User Created Successfully!";
    }
    
    public String loginUser(Users user) {
    	if(null!=user.getUserName() && null!=user.getPassword()) {
    		Optional<Users> details = userRepository.findByUserName(user.getUserName());
    		if(details.isPresent()) {
    			String userName = details.get().getUserName();
    			String encryptedPassword = details.get().getPassword();
    			String rawPassword = user.getPassword();
    			
    			if(!authenticationService.authenticateUser(userName, rawPassword, encryptedPassword)) {
    				return "UserName or Password is Incorrect!";
    			}
    		}else {
    			return "User Not Found!";
    		}
    	}
    	return "Logged In Successfully!";
    }

    public Optional<Users> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    
    public Optional<Users> findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }
}
