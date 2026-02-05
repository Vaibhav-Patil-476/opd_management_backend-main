package com.OPD_Managemnet_System.OPDEntitys;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

//Entity class representing database table for OPD management
@Entity
@Table(name = "Medicines")
public class Medicine {

	// It uniquely identifies each record in the database table.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	private String type;

	// Many-to-One Relationship between Medicine and Doctor
	@ManyToOne
	@JoinColumn(name = "doctorid")
	@JsonIgnoreProperties(value = { "doctorid" }, allowSetters = true)
	private Doctor doctorid;

	// Getters and Setters

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

	public Doctor getDoctorid() {
		return doctorid;
	}

	public void setDoctorid(Doctor doctorid) {
		this.doctorid = doctorid;
	}

	@Override
	public String toString() {
		return "Medicine [id=" + id + ", name=" + name + ", type=" + type + ", doctorid=" + doctorid + "]";
	}
}
