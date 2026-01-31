package com.OPD_Managemnet_System.Response;

public class Login_Response {

	private String email;
	
	private String password;
	
	public Login_Response(String email,String password) {
		this.email=email;
		this.password=password;
	}

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
