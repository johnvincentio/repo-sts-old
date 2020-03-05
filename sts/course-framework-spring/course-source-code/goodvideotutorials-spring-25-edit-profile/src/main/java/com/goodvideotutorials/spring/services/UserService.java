package com.goodvideotutorials.spring.services;

import org.springframework.validation.BindingResult;

import com.goodvideotutorials.spring.dto.ForgotPasswordForm;
import com.goodvideotutorials.spring.dto.ResetPasswordForm;
import com.goodvideotutorials.spring.dto.SignupForm;
import com.goodvideotutorials.spring.dto.UserEditForm;
import com.goodvideotutorials.spring.entities.User;

public interface UserService {
	
	public abstract void signup(SignupForm signupForm);

	public abstract void verify(String verificationCode);

	public abstract void forgotPassword(ForgotPasswordForm forgotPasswordForm);

	public abstract void resetPassword(String forgotPasswordCode,
			ResetPasswordForm resetPasswordForm, BindingResult result);

	public abstract User findOne(long userId);

	public abstract void update(long userId, UserEditForm userEditForm);

}
