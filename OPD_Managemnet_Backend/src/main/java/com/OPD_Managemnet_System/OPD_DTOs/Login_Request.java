package com.OPD_Managemnet_System.OPD_DTOs;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class Login_Request {

	@Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
	public String email;
	
	@NotBlank(message = "Password is required")
	public String password;
 
	//getter setter for data transfer
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
	
	
	
}
