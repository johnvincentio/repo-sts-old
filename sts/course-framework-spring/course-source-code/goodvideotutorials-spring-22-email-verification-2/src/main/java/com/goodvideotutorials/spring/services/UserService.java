package com.goodvideotutorials.spring.services;

import com.goodvideotutorials.spring.dto.SignupForm;

public interface UserService {
	
	public abstract void signup(SignupForm signupForm);

	public abstract void verify(String verificationCode);

}
