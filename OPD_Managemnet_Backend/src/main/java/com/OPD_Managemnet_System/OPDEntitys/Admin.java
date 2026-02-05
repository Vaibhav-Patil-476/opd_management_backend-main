package com.OPD_Managemnet_System.OPDEntitys;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

//Entity class representing database table for OPD management

@Entity
@Table(name="Admin")
public class Admin {

	// It uniquely identifies each record in the database table.
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private String password;
	private long mobileNo;
	private LocalDateTime create_at;
	private LocalDateTime updatet_at;

	@Enumerated(EnumType.STRING)
	private Role Role; //Define role (Admin ,Doctor,Reception) 
	
	
	//getter and setter 
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Role getRole() {
		return Role;
	}

	public void setRole(Role role) {
		Role = role.ADMIN;
	}

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

	public Admin(int id, String name, String email, String password, long mobileNo, LocalDateTime create_at,
			LocalDateTime updatet_at) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.mobileNo = mobileNo;
		this.create_at = create_at;
		this.updatet_at = updatet_at;
	}

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", mobileNo="
				+ mobileNo + ", create_at=" + create_at + ", updatet_at=" + updatet_at + "]";
	}

	
	
}
