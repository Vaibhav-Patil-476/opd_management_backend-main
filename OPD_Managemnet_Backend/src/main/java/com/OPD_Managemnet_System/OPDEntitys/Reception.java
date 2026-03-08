package com.OPD_Managemnet_System.OPDEntitys;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

//Entity class representing database table for OPD management
@Entity
@Table(name = "Reception")
public class Reception {

	// It uniquely identifies each record in the database table.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private String address;
	private long mobileNo;
	private String token;
	private LocalDateTime created_at;
	private LocalDateTime updated_at;
	private String password;
	private String shift;
	
	private Long otp;
	
	private boolean isOtpVerified;
	
	private LocalDateTime localdatetime;

	@Enumerated(EnumType.STRING)
	private Role Role;

	// Apply Many to One Relationship Between Reception and Reception
	@ManyToOne
	@JoinColumn(name = "doctorid")
	@JsonIgnoreProperties(value = "doctorid", allowGetters = true)
	private Doctor doctorid;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
		this.created_at = created_at;
	}

	public LocalDateTime getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(LocalDateTime updated_at) {
		this.updated_at = updated_at;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getShift() {
		return shift;
	}

	public void setShift(String shift) {
		this.shift = shift;
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

	public Doctor getDoctorid() {
		return doctorid;
	}

	public void setDoctorid(Doctor doctorid) {
		this.doctorid = doctorid;
	}

	public Reception(int id, String name, String email, String address, long mobileNo, String token,
			LocalDateTime created_at, LocalDateTime updated_at, String password, String shift, Long otp,
			boolean isOtpVerified, LocalDateTime localdatetime, com.OPD_Managemnet_System.OPDEntitys.Role role,
			Doctor doctorid) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.address = address;
		this.mobileNo = mobileNo;
		this.token = token;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.password = password;
		this.shift = shift;
		this.otp = otp;
		this.isOtpVerified = isOtpVerified;
		this.localdatetime = localdatetime;
		Role = role;
		this.doctorid = doctorid;
	}

	@Override
	public String toString() {
		return "Reception [id=" + id + ", name=" + name + ", email=" + email + ", address=" + address + ", mobileNo="
				+ mobileNo + ", token=" + token + ", created_at=" + created_at + ", updated_at=" + updated_at
				+ ", password=" + password + ", shift=" + shift + ", otp=" + otp + ", isOtpVerified=" + isOtpVerified
				+ ", localdatetime=" + localdatetime + ", Role=" + Role + ", doctorid=" + doctorid + "]";
	}

	public Reception() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}
