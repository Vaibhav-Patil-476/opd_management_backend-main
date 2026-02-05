package com.OPD_Managemnet_System.OPDEntitys;

import java.sql.Date;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

//Entity class representing database table for OPD management
@Entity
@Table(name = "Referrals")
public class Referral {

	// It uniquely identifies each record in the database table.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String note_type;

	private String reson;

	private String details;

	private LocalDateTime create_at;

	//Apply Many to One Relationship between Referral and Doctor
	@ManyToOne
	@JoinColumn(name = "Doctorid")
	@JsonIgnoreProperties(value = { "Doctorid" }, allowSetters = true)
	private Doctor Doctorid;

	//Apply Many to One Relationship between Referral and Patient 
	@ManyToOne
	@JoinColumn(name = "patientid")
	@JsonIgnoreProperties(value = { "patientid" }, allowSetters = true)
	private Patient patientid;

	//Apply Many to One Relationship between Referral and visit 
	@ManyToOne
	@JoinColumn(name = "visitid")
	@JsonIgnoreProperties(value = { "Doctorid" }, allowSetters = true)
	private Visit visitid;

	//getter and setter 
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public Doctor getDoctorid() {
		return Doctorid;
	}

	public void setDoctorid(Doctor Doctorid) {
		this.Doctorid = Doctorid;
	}

	public Patient getPatientid() {
		return patientid;
	}

	public void setPatientid(Patient patientid) {
		this.patientid = patientid;
	}

	public Visit getVisitid() {
		return visitid;
	}

	public void setVisitid(Visit visitid) {
		this.visitid = visitid;
	}

	public Referral(int id, String note_type, String reson, String details, LocalDateTime create_at, Doctor Doctorid,
			Patient patientid, Visit visitid) {
		super();
		this.id = id;
		this.note_type = note_type;
		this.reson = reson;
		this.details = details;
		this.create_at = create_at;
		this.Doctorid = Doctorid;
		this.patientid = patientid;
		this.visitid = visitid;
	}

	@Override
	public String toString() {
		return "Referral [id=" + id + ", note_type=" + note_type + ", reson=" + reson + ", details=" + details
				+ ", create_at=" + create_at + ", Doctorid=" + Doctorid + ", patientid=" + patientid + ", visitid="
				+ visitid + "]";
	}

	public Referral() {
		super();
		// TODO Auto-generated constructor stub
	}

}
