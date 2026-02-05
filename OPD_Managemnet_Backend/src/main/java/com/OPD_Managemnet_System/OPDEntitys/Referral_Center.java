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
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

//Entity class representing database table for OPD management
@Entity
@Table(name = "Referral_Center")
public class Referral_Center {

	// It uniquely identifies each record in the database table.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int id;
	private String name;
	private String type;
	private int contact_info;
	private String address;
	private LocalDateTime created_at;

	// create Many to one Relationship between Referral_center and doctor
	@ManyToOne
	@JoinColumn(name = "Doctorid")
	@JsonIgnoreProperties(value = { "Doctorid" }, allowSetters = true)
	private Doctor Doctorid;

	// getter and setter
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

	public Doctor getDoctorid() {
		return Doctorid;
	}

	public void setDoctorid(Doctor Doctorid) {
		this.Doctorid = Doctorid;
	}

	public Referral_Center(int id, String name, String type, int contact_info, String address, LocalDateTime created_at,
			Doctor Doctorid) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.contact_info = contact_info;
		this.address = address;
		this.created_at = created_at;
		this.Doctorid = Doctorid;
	}

	@Override
	public String toString() {
		return "Referral_Center [id=" + id + ", name=" + name + ", type=" + type + ", contact_info=" + contact_info
				+ ", address=" + address + ", created_at=" + created_at + ", Doctorid=" + Doctorid + "]";
	}

	public Referral_Center() {
		super();
		// TODO Auto-generated constructor stub
	}

}
