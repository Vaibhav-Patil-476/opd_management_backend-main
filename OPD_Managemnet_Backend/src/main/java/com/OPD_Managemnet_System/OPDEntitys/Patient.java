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
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

//Entity class representing database table for OPD management
@Entity
@Table(name = "Patients")
public class Patient {

	// It uniquely identifies each record in the database table.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String patient_name;

	private int age;

	private String gender;

	private long mibileno;

	private String address;

	private String blood_group;

	private String height;

	private String smoking;

	private String alcohol;

	private String tobacoo;

	private LocalDateTime created_at;

	// Apply many to one Relationship between Patient and Doctor
	@ManyToOne
	@JoinColumn(name = "doctorid")
	@JsonIgnoreProperties(value = "doctorid", allowSetters = true)
	private Doctor doctorid;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPatient_name() {
		return patient_name;
	}

	public void setPatient_name(String patient_name) {
		this.patient_name = patient_name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public long getMibileno() {
		return mibileno;
	}

	public void setMibileno(long mibileno) {
		this.mibileno = mibileno;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBlood_group() {
		return blood_group;
	}

	public void setBlood_group(String blood_group) {
		this.blood_group = blood_group;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getSmoking() {
		return smoking;
	}

	public void setSmoking(String smoking) {
		this.smoking = smoking;
	}

	public String getAlcohol() {
		return alcohol;
	}

	public void setAlcohol(String alcohol) {
		this.alcohol = alcohol;
	}

	public String getTobacoo() {
		return tobacoo;
	}

	public void setTobacoo(String tobacoo) {
		this.tobacoo = tobacoo;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = LocalDateTime.now();
	}

	public Doctor getDoctorid() {
		return doctorid;
	}

	public void setDocterid(Doctor docterid) {
		this.doctorid = docterid;
	}

	public Patient(int id, String patient_name, int age, String gender, long mibileno, String address,
			String blood_group, String height, String smoking, String alcohol, String tobacoo, LocalDateTime created_at,
			Doctor docterid) {
		super();
		this.id = id;
		this.patient_name = patient_name;
		this.age = age;
		this.gender = gender;
		this.mibileno = mibileno;
		this.address = address;
		this.blood_group = blood_group;
		this.height = height;
		this.smoking = smoking;
		this.alcohol = alcohol;
		this.tobacoo = tobacoo;
		this.created_at = created_at;
		this.doctorid = docterid;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", patient_name=" + patient_name + ", age=" + age + ", gender=" + gender
				+ ", mibileno=" + mibileno + ", address=" + address + ", blood_group=" + blood_group + ", height="
				+ height + ", smoking=" + smoking + ", alcohol=" + alcohol + ", tobacoo=" + tobacoo + ", created_at="
				+ created_at + ", docterid=" + doctorid + "]";
	}

	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}

}
