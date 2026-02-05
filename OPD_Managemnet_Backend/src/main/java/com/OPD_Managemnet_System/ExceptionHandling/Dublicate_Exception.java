package com.OPD_Managemnet_System.ExceptionHandling;

//Extend with Runtime Exception class (Predefined Class/Parent class)
public class Dublicate_Exception extends RuntimeException {

	public Dublicate_Exception(String message) {
		// call parent class constructor
		super(message);
	}
}
