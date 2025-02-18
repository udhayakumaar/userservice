package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Users;
import com.example.demo.response.InlineResponse200;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/users")
public class UserServiceController {
	
	@Autowired
	UserService userService;

	@PostMapping("/register")
    public @ResponseBody InlineResponse200 register(@RequestBody Users user) {
		InlineResponse200 response = new InlineResponse200();
		response.setResponseMsg(userService.registerUser(user));
        return response;
    }

    @GetMapping("/{email}")
    public Optional<Users> getUser(@PathVariable String email) {
        return userService.findByEmail(email);
    }
}
