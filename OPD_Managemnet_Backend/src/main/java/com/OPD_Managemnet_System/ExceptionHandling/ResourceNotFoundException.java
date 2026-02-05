package com.OPD_Managemnet_System.ExceptionHandling;

//Extend with Runtime Exception class (Predefined Class/Parent class)
public class ResourceNotFoundException extends RuntimeException {

	public ResourceNotFoundException(String message) {
		// call parent class constructor
		super(message);
	}
}
