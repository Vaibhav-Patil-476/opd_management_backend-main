package com.OPD_Managemnet_System.OPDEntitys;

import java.sql.Date;
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
@Table(name = "Doctors")
public class Doctor {

	// It uniquely identifies each record in the database table.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	private String password;

	private String email;

	private String specialization;

	private String clinic_name;

	private String address;

	private Long mobileno;

	private String token;

	private String status;

	private LocalDateTime created_at;

	private LocalDateTime updated_at;

	private String qualification;
	
	// Define role 
	@Enumerated(EnumType.STRING)
	private Role Role;

	//getter setter 
	public Role getRole() {
		return Role;
	}

	public void setRole(Role role) {
		Role = role.DOCTOR;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getClinic_name() {
		return clinic_name;
	}

	public void setClinic_name(String clinic_name) {
		this.clinic_name = clinic_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public long getMobileno() {
		return mobileno;
	}

	public void setMobileno(long mobileno) {
		this.mobileno = mobileno;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
		this.updated_at = LocalDateTime.now();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Doctor(int id, String name, String password, String specialization, String clinic_name, String address,
			long mobileno, String token, String status, LocalDateTime created_at, LocalDateTime updated_at,
			String email, String qualification) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.specialization = specialization;
		this.clinic_name = clinic_name;
		this.address = address;
		this.mobileno = mobileno;
		this.token = token;
		this.status = status;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.email = email;
		this.qualification = qualification;
	}

	@Override
	public String toString() {
		return "Doctor [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email
				+ ", specialization=" + specialization + ", clinic_name=" + clinic_name + ", address=" + address
				+ ", mobileno=" + mobileno + ", token=" + token + ", status=" + status + ", created_at=" + created_at
				+ ", updated_at=" + updated_at + ", qualification=" + qualification + "]";
	}

	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}

}
