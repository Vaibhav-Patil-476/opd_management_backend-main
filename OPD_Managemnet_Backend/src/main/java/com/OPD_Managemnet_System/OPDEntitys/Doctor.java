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
	
	private Long otp;
	
	private boolean isOtpVerified;
	
	private LocalDateTime localdatetime;
	
	// Define role 
	@Enumerated(EnumType.STRING)
	private Role Role;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Long getMobileno() {
		return mobileno;
	}

	public void setMobileno(Long mobileno) {
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
		this.created_at = created_at;
	}

	public LocalDateTime getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(LocalDateTime updated_at) {
		this.updated_at = updated_at;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public Long getOtp() {
		return otp;
	}

	public void setOtp(Long otp) {
		this.otp = otp;
	}

	public boolean isOtpVerified() {
		return isOtpVerified;
	}

	public void setOtpVerified(boolean isOtpVerified) {
		this.isOtpVerified = isOtpVerified;
	}

	public LocalDateTime getLocaldatetime() {
		return localdatetime;
	}

	public void setLocaldatetime(LocalDateTime localdatetime) {
		this.localdatetime = localdatetime;
	}

	public Role getRole() {
		return Role;
	}

	public void setRole(Role role) {
		Role = role;
	}

	public Doctor(int id, String name, String password, String email, String specialization, String clinic_name,
			String address, Long mobileno, String token, String status, LocalDateTime created_at,
			LocalDateTime updated_at, String qualification, Long otp, boolean isOtpVerified,
			LocalDateTime localdatetime, com.OPD_Managemnet_System.OPDEntitys.Role role) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.specialization = specialization;
		this.clinic_name = clinic_name;
		this.address = address;
		this.mobileno = mobileno;
		this.token = token;
		this.status = status;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.qualification = qualification;
		this.otp = otp;
		this.isOtpVerified = isOtpVerified;
		this.localdatetime = localdatetime;
		Role = role;
	}

	@Override
	public String toString() {
		return "Doctor [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email
				+ ", specialization=" + specialization + ", clinic_name=" + clinic_name + ", address=" + address
				+ ", mobileno=" + mobileno + ", token=" + token + ", status=" + status + ", created_at=" + created_at
				+ ", updated_at=" + updated_at + ", qualification=" + qualification + ", otp=" + otp
				+ ", isOtpVerified=" + isOtpVerified + ", localdatetime=" + localdatetime + ", Role=" + Role + "]";
	}

	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}