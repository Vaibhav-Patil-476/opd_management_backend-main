package com.OPD_Managemnet_System.Response;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

// This class for response on Error
public class Error_Response {

	private int status;
	private String message;

	private LocalDateTime localdatetime;

	// getters and setters
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDateTime getLocaldatetime() {
		return localdatetime;
	}

	public void setLocaldatetime(LocalDateTime localdatetime) {
		this.localdatetime = localdatetime;
	}

	// constructors
	public Error_Response(int status, String message) {
		this.status = status;
		this.message = message;
		this.localdatetime = LocalDateTime.now();
	}

	public Error_Response() {
	}
}
