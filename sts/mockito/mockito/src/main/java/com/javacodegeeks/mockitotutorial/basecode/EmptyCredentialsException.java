package com.javacodegeeks.mockitotutorial.basecode;

public class EmptyCredentialsException extends Exception {

	private static final long serialVersionUID = -7464046262884167808L;

	public EmptyCredentialsException() {
        super("Empty credentials!");
    }
}
