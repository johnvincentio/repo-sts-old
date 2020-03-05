package com.javacodegeeks.mockitotutorial.voidmethod;

public class NotAuthenticatedException extends Exception {

	private static final long serialVersionUID = 62817389767518098L;

	public NotAuthenticatedException() {
        super("Could not authenticate!");
    }
}
