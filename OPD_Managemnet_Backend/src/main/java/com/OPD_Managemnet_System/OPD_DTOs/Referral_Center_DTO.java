package com.OPD_Managemnet_System.OPD_DTOs;

import java.sql.Date;
import java.time.LocalDateTime;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class Referral_Center_DTO {

	@NotBlank(message = "Name is required")
	private String name;

	@NotBlank(message = "Type is required")
	private String type;

	@NotNull(message = "Contact info is required")
	@Min(value = 1000000000, message = "Contact info must be 10 digits")
	@Max(value = 9999999999L, message = "Contact info must be 10 digits")
	private int contact_info;

	@NotBlank(message = "Address is required")
	private String address;

	@NotNull(message = "Created date is required")
	private LocalDateTime created_at;

	@NotNull(message = "Doctor ID is required")
	@Positive(message = "Doctor ID must be a positive number")
	private int docterid;

	// Genarate Getter Setter for Store temp Data
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getContact_info() {
		return contact_info;
	}

	public void setContact_info(int contact_info) {
		this.contact_info = contact_info;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = LocalDateTime.now();
	}

	public int getDocterid() {
		return docterid;
	}

	public void setDocterid(int docterid) {
		this.docterid = docterid;
	}

}
