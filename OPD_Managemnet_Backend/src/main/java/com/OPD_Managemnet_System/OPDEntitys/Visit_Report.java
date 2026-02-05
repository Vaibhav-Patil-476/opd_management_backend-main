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
import jakarta.validation.constraints.Pattern;

//Entity class representing database table for OPD management
@Entity
@Table(name = "Visit_Reports")
public class Visit_Report {

	// It uniquely identifies each record in the database table.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String file_name;

	private String file_url;

	private String file_type;

	private LocalDateTime created_at;
	// Apply Many to One Relationship between visit report and visit
	@ManyToOne
	@JoinColumn(name = "visitid")
	@JsonIgnoreProperties(value = "visitid", allowSetters = true)

	private Visit visitid;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFile_name() {
		return file_name;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	public String getFile_url() {
		return file_url;
	}

	public void setFile_url(String file_url) {
		this.file_url = file_url;
	}

	public String getFile_type() {
		return file_type;
	}

	public void setFile_type(String file_type) {
		this.file_type = file_type;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = LocalDateTime.now();
	}

	public Visit getVisitid() {
		return visitid;
	}

	public void setVisitid(Visit visitid) {
		this.visitid = visitid;
	}

	public Visit_Report(int id, String file_name, String file_url, String file_type, LocalDateTime created_at,
			Visit visitid) {
		super();
		this.id = id;
		this.file_name = file_name;
		this.file_url = file_url;
		this.file_type = file_type;
		this.created_at = created_at;
		this.visitid = visitid;
	}

	@Override
	public String toString() {
		return "Visit_Report [id=" + id + ", file_name=" + file_name + ", file_url=" + file_url + ", file_type="
				+ file_type + ", created_at=" + created_at + ", visitid=" + visitid + "]";
	}

	public Visit_Report() {
		super();
		// TODO Auto-generated constructor stub
	}

}
