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

@Entity
@Table(name="Reception")
public class Reception {

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

@NotNull(message = "Enter the password")
private String password;

private String shift;
	

	public String getShift() {
	return shift;
}

public void setShift(String shift) {
	this.shift = shift;
}

public String getPassword() {
	return password;
}

	@Enumerated(EnumType.STRING)
	private Role Role;
	
	



	@ManyToOne
	@JoinColumn(name="doctorid")
	@JsonIgnoreProperties(value="doctorid",allowGetters = true)
	
	private Doctor doctorid;
	
	//reception getter and Setter
	
	
	//Parameters constructor
		public Reception(int id, String name, String email, String address, long mobileNo, String token,
				LocalDateTime created_at, LocalDateTime updated_at, Doctor doctorid,String password) {
			super();
			this.id = id;
			this.name = name;
			this.email = email;
			this.address = address;
			this.mobileNo = mobileNo;
			this.token = token;
			this.created_at = created_at;
			this.updated_at = updated_at;
			this.doctorid = doctorid;
			this.password=password;
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

		public void setPassword(String password) {
			this.password = password;
		}

	//default constructor
	public Reception() {
		super();
	}

	//toStrign Method
	


	@Override
	public String toString() {
		return "Reception [id=" + id + ", name=" + name + ", email=" + email + ", address=" + address + ", mobileNo="
				+ mobileNo + ", token=" + token + ", created_at=" + created_at + ", updated_at=" + updated_at
				+ ", password=" + password + ", Role=" + Role + ", doctorid=" + doctorid + "]";
	}
	
	
	
	
}
