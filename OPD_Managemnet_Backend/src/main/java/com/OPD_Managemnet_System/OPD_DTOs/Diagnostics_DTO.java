package com.OPD_Managemnet_System.OPD_DTOs;

import java.sql.Date;
import java.time.LocalDateTime;

import com.OPD_Managemnet_System.OPDEntitys.Doctor;
import com.OPD_Managemnet_System.OPDEntitys.Visit;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;

public class Diagnostics_DTO {

    @NotBlank(message = "Name is required")
    private String name;

    @Column(updatable = false)
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "visitid")
    @JsonIgnoreProperties(value = {"visitid"}, allowSetters = true)
    private int visitid;

    @ManyToOne
    @JoinColumn(name = "doctorid")
    @JsonIgnoreProperties(value = {"doctorid"}, allowSetters = true)
    private int doctorid;

	private LocalDateTime setcreate_at;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDateTime getCreate_at() {
		return getCreate_at();
	}
	public void setCreate_at(LocalDateTime create_at) {
		this.setcreate_at = LocalDateTime.now();
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
	
	
	
	
}
