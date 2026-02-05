package com.OPD_Managemnet_System.OPDEntitys;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

//Entity class representing database table for OPD management

@Entity
@Table(name = "Diagnostics")
public class Diagnostics {

	// It uniquely identifies each record in the database table.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	private LocalDateTime createdAt;

	// Apply Many to One Relationship between the Diagnostics and visit
	@ManyToOne
	@JoinColumn(name = "visitid")
	@JsonIgnoreProperties(value = { "visitid" }, allowSetters = true)
	private Visit visitid;

	// Apply Many to One Relationship between the Diagnostics and Doctor
	@ManyToOne
	@JoinColumn(name = "doctorid")
	@JsonIgnoreProperties(value = { "doctorid" }, allowSetters = true)
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

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public Visit getVisitId() {
		return visitid;
	}

	public void setVisitid(Visit visit) {
		this.visitid = visit;
	}

	public Doctor getDoctorid() {
		return doctorid;
	}

	public void setDoctorid(Doctor doctorid) {
		this.doctorid = doctorid;
	}

	@Override
	public String toString() {
		return "Diagnostics [id=" + id + ", name=" + name + ", createdAt=" + createdAt + ", visit=" + visitid
				+ ", doctorid=" + doctorid + "]";
	}

	public Diagnostics(int id, @NotBlank(message = "Name is required") String name, LocalDateTime createdAt,
			Visit visit, Doctor doctorid) {
		super();
		this.id = id;
		this.name = name;
		this.createdAt = createdAt;
		this.visitid = visit;
		this.doctorid = doctorid;
	}

	public Diagnostics() {
		super();
		// TODO Auto-generated constructor stub
	}

}
