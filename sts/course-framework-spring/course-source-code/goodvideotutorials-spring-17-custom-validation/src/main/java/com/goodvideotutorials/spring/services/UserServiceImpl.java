package com.goodvideotutorials.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goodvideotutorials.spring.dto.SignupForm;
import com.goodvideotutorials.spring.entities.User;
import com.goodvideotutorials.spring.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	private UserRepository userRepository;

	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		
		this.userRepository = userRepository;
		
	}

	@Override
	public void signup(SignupForm signupForm) {
		User user = new User();
		user.setEmail(signupForm.getEmail());
		user.setName(signupForm.getName());
		user.setPassword(signupForm.getPassword());
		userRepository.save(user);
	}

}
