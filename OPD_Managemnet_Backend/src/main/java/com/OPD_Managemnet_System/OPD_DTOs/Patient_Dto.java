package com.OPD_Managemnet_System.OPD_DTOs;

import java.sql.Date;
import java.time.LocalDateTime;

import com.OPD_Managemnet_System.OPDEntitys.Doctor;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

public class Patient_Dto {


	@NotBlank(message = "Patient name is required")
	private String patient_name;

	@NotNull(message = "Age is required")
	@Min(value = 0, message = "Age cannot be negative")
	@Max(value = 120, message = "Age seems invalid")
	private int age;

	@NotBlank(message = "Gender is required")
	@Pattern(regexp = "Male|Female|Other", message = "Gender must be Male, Female or Other")
	private String gender;

	@NotNull(message = "Mobile number is required")
	@Digits(integer = 10, fraction = 0, message = "Mobile number must be 10 digits")
	private long mibileno;

	@NotBlank(message = "Address is required")
	private String address;

	@NotBlank(message = "Blood group is required")
	@Pattern(regexp = "^(A|B|AB|O)[+-]$", message = "Invalid blood group")
	private String blood_group;

	@NotBlank(message = "Height is required")
	@Pattern(regexp = "^[0-9]{2,3}(cm|CM|in|IN)?$", message = "Height should be in cm or in")
	private String height;

	@NotBlank(message = "Smoking is required")
	@Pattern(regexp = "Yes|No", message = "Smoking must be Yes or No")
	private String smoking;

	@NotBlank(message = "Alcohol is required")
	@Pattern(regexp = "Yes|No", message = "Alcohol must be Yes or No")
	private String alcohol;

	@NotBlank(message = "Tobacco is required")
	@Pattern(regexp = "Yes|No", message = "Tobacco must be Yes or No")
	private String tobacoo;

	@NotNull(message = "Created date is required")
	private LocalDateTime created_at;

	@NotNull(message = "Doctor ID is required")
	@Positive(message = "Doctor ID must be a positive number")
	private int doctorid;

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
	public int getDoctorid() {
		return doctorid;
	}
	public void setDocterid(int docterid) {
		this.doctorid = docterid;
	}
	
	
}
