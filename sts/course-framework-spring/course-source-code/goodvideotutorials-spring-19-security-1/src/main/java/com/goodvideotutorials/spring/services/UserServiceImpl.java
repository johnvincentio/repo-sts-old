package com.goodvideotutorials.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;

import com.goodvideotutorials.spring.dto.SignupForm;
import com.goodvideotutorials.spring.dto.UserDetailsImpl;
import com.goodvideotutorials.spring.entities.User;
import com.goodvideotutorials.spring.repositories.UserRepository;

@Service
@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
public class UserServiceImpl implements UserService, UserDetailsService {
	
	private UserRepository userRepository;

	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		
		this.userRepository = userRepository;
		
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void signup(SignupForm signupForm) {
		User user = new User();
		user.setEmail(signupForm.getEmail());
		user.setName(signupForm.getName());
		user.setPassword(signupForm.getPassword());
		userRepository.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		User user = userRepository.findByEmail(username);
		if (user == null)
			throw new UsernameNotFoundException(username);

		return new UserDetailsImpl(user);
	}

}
