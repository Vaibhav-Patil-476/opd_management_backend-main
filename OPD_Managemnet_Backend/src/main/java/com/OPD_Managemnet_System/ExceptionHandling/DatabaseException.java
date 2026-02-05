package com.OPD_Managemnet_System.ExceptionHandling;

//Extend with Runtime Exception class (Predefined Class/Parent class)
public class DatabaseException extends RuntimeException {

	public DatabaseException(String message) {
		// call parent class constructor
		super(message);
	}

}
