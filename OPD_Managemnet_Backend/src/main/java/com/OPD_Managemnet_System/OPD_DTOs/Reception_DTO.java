package com.OPD_Managemnet_System.OPD_DTOs;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

//Data Tranfer Object for Recption 
public class Reception_DTO {


@NotBlank(message = "Name is required")
private String name;

private int doctorid;

@NotBlank(message = "Email is required")
@Email(message = "Invalid email format")
private String email;
@NotBlank(message = "Password is required")
@Size(min = 6, message = "Password must be at least 6 characters")
private String password;

@NotBlank(message = "Address is required")
private String address;

@NotNull(message = "Mobile number is required")
@Digits(integer = 10, fraction = 0, message = "Mobile number must be 10 digits")
private long mobileNo;

private String token;


private LocalDateTime created_at;


private LocalDateTime updated_at;

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
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

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public long getMobileNo() {
	return mobileNo;
}

public void setMobileNo(long mobileNo) {
	this.mobileNo = mobileNo;
}

public String getToken() {
	return token;
}

public void setToken(String token) {
	this.token = token;
}

public LocalDateTime getCreated_at() {
	return created_at;
}

public void setCreated_at(LocalDateTime created_at) {
	this.created_at = LocalDateTime.now();
}

public LocalDateTime getUpdated_at() {
	return updated_at;
}

public void setUpdated_at(LocalDateTime updated_at) {
	this.updated_at = LocalDateTime.now();;
}

public int getDoctorid() {
	return doctorid;
}

public void setDoctorid(int doctorid) {
	this.doctorid = doctorid;
}
	
	
	
}
