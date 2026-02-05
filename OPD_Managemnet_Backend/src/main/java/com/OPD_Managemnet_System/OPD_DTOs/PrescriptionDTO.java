package com.OPD_Managemnet_System.OPD_DTOs;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

//Data Tranfer Object for Recption 
public class PrescriptionDTO {

	@NotBlank(message = "Dosage cannot be empty")
	private String Dosage;

	@NotBlank(message = "Instructions cannot be empty")
	private String instructions;

	@Min(value = 1, message = "Quantity must be at least 1")
	private int quantity;

	@NotNull(message = "Creation date cannot be null")
	private LocalDateTime created_at;

	@Min(value = 0, message = "Morning dose cannot be negative")
	private int morning_dose;

	@Min(value = 0, message = "Afternoon dose cannot be negative")
	private int afternoon_dose;

	@Min(value = 0, message = "Evening dose cannot be negative")
	private int evening_dose;

	@Min(value = 1, message = "Duration (days) must be at least 1")
	private int duration_day;

	@Min(value = 1, message = "Total quantity must be at least 1")
	private int total_quantity;

	@Size(max = 255, message = "Quantity note cannot exceed 255 characters")
	private String quantity_note;

	@NotBlank(message = "Dose quantity cannot be empty")
	private String dose_qty;

	@NotBlank(message = "Dose unit cannot be empty")
	private String dose_unit;

	@Min(value = 1, message = "Visit ID must be at least 1")
	private int visitid;

	@Min(value = 1, message = "Medicine ID must be at least 1")
	private int medicineid;

	
	//getter and setter 
	public String getDosage() {
		return Dosage;
	}

	public void setDosage(String dosage) {
		Dosage = dosage;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}

	public int getMorning_dose() {
		return morning_dose;
	}

	public void setMorning_dose(int morning_dose) {
		this.morning_dose = morning_dose;
	}

	public int getAfternoon_dose() {
		return afternoon_dose;
	}

	public void setAfternoon_dose(int afternoon_dose) {
		this.afternoon_dose = afternoon_dose;
	}

	public int getEvening_dose() {
		return evening_dose;
	}

	public void setEvening_dose(int evening_dose) {
		this.evening_dose = evening_dose;
	}

	public int getDuration_day() {
		return duration_day;
	}

	public void setDuration_day(int duration_day) {
		this.duration_day = duration_day;
	}

	public int getTotal_quantity() {
		return total_quantity;
	}

	public void setTotal_quantity(int total_quantity) {
		this.total_quantity = total_quantity;
	}

	public String getQuantity_note() {
		return quantity_note;
	}

	public void setQuantity_note(String quantity_note) {
		this.quantity_note = quantity_note;
	}

	public String getDose_qty() {
		return dose_qty;
	}

	public void setDose_qty(String dose_qty) {
		this.dose_qty = dose_qty;
	}

	public String getDose_unit() {
		return dose_unit;
	}

	public void setDose_unit(String dose_unit) {
		this.dose_unit = dose_unit;
	}

	public int getVisitid() {
		return visitid;
	}

	public void setVisitid(int visitid) {
		this.visitid = visitid;
	}

	public int getMedicineid() {
		return medicineid;
	}

	public void setMedicineid(int medicineid) {
		this.medicineid = medicineid;
	}

}
