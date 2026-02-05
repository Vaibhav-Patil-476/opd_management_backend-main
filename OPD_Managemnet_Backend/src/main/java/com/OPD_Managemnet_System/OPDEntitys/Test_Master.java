package com.OPD_Managemnet_System.OPDEntitys;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

//Entity class representing database table for OPD management
@Entity
@Table(name = "Test_Masters")
public class Test_Master {

	// It uniquely identifies each record in the database table.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int id;

	private String test_name;

	private String normal_range;

	private String unit;

	// Apply Many to One Relationship between Test Master and Doctor
	@ManyToOne
	@JoinColumn(name = "Doctorid")
	@JsonIgnoreProperties(value = "Doctorid", allowSetters = true)

	private Doctor Doctorid;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTest_name() {
		return test_name;
	}

	public void setTest_name(String test_name) {
		this.test_name = test_name;
	}

	public String getNormal_range() {
		return normal_range;
	}

	public void setNormal_range(String normal_range) {
		this.normal_range = normal_range;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Doctor getDoctorid() {
		return Doctorid;
	}

	public void setDoctorid(Doctor Doctorid) {
		this.Doctorid = Doctorid;
	}

	public Test_Master(int id, String test_name, String normal_range, String unit, Doctor Doctorid) {
		super();
		this.id = id;
		this.test_name = test_name;
		this.normal_range = normal_range;
		this.unit = unit;
		this.Doctorid = Doctorid;
	}

	@Override
	public String toString() {
		return "Test_Master [id=" + id + ", test_name=" + test_name + ", normal_range=" + normal_range + ", unit="
				+ unit + ", Doctorid=" + Doctorid + "]";
	}

	public Test_Master() {
		super();
		// TODO Auto-generated constructor stub
	}

}
