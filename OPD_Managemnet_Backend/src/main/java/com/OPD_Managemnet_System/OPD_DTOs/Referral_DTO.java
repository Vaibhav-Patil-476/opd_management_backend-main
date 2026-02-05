package com.OPD_Managemnet_System.OPD_DTOs;

import java.sql.Date;
import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class Referral_DTO {

	@NotBlank(message = "Note type is required")
	private String note_type;

	@NotBlank(message = "Reason is required")
	private String reson;

	@NotBlank(message = "Details are required")
	private String details;

	@NotNull(message = "Created date is required")
	private LocalDateTime create_at;

	@NotNull(message = "Doctor ID is required")
	@Positive(message = "Doctor ID must be a positive number")
	private int doctorid;

	@NotNull(message = "Visit ID is required")
	@Positive(message = "Visit ID must be a positive number")
	private int visitid;

	@NotNull(message = "Patient ID is required")
	@Positive(message = "Patient ID must be a positive number")
	private int patientid;

	public String getNote_type() {
		return note_type;
	}

	public void setNote_type(String note_type) {
		this.note_type = note_type;
	}

	public String getReson() {
		return reson;
	}

	public void setReson(String reson) {
		this.reson = reson;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public LocalDateTime getCreate_at() {
		return create_at;
	}

	public void setCreate_at(LocalDateTime create_at) {
		this.create_at = LocalDateTime.now();
	}

	public int getDoctorid() {
		return doctorid;
	}

	public void setDoctorid(int doctorid) {
		this.doctorid = doctorid;
	}

	public int getVisitid() {
		return visitid;
	}

	public void setVisitid(int visitid) {
		this.visitid = visitid;
	}

	public int getPatientid() {
		return patientid;
	}

	public void setPatientid(int patientid) {
		this.patientid = patientid;
	}

}
