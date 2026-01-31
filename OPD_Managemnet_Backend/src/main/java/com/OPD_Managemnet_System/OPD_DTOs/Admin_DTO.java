package com.OPD_Managemnet_System.OPD_DTOs;

import java.time.LocalDateTime;

import com.OPD_Managemnet_System.OPDEntitys.Role;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Admin_DTO {

    @NotBlank(message = "Email is required")
    private String email;
  
    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;

    @NotNull(message = "Mobile number is required")
    @Digits(integer = 10, fraction = 0)
    private Long mobileNo;

    
   
    private LocalDateTime create_at;

   
   
    private LocalDateTime updatet_at;
	
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

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public LocalDateTime getCreate_at() {
		return create_at;
	}

	public void setCreate_at(LocalDateTime create_at) {
		this.create_at = LocalDateTime.now();
	}

	public LocalDateTime getUpdatet_at() {
		return updatet_at;
	}

	public void setUpdatet_at(LocalDateTime updatet_at) {
		this.updatet_at = LocalDateTime.now();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
