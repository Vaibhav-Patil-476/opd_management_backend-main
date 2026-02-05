package com.OPD_Managemnet_System.OPDEntitys;

import java.time.LocalDateTime;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

//Entity class representing database table for OPD management
@Entity
@Table(name="Prescriptions")
public class Prescription {

	// It uniquely identifies each record in the database table.
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String Dosage;
	
	private String instructions;
	
	private int quantity;
	
	private LocalDateTime created_at;
	
	private int morning_dose;
	
	private int afternoon_dose;
	
	private int evening_dose;
	
	private int duration_day;
	
	private int total_quantity;
	
	private String quantity_note;
	
	private String dose_qty;
	
	private String dose_unit;
	
	//many to one relation between prescription and visit table 
	@ManyToOne
	@JoinColumn(name="visitid")
	@JsonIgnoreProperties(value="visitid",allowSetters = true)
	private Visit visitid;
	
	//many to one relation between prescription and Medicine table 
	@ManyToOne
	@JoinColumn(name="medicineid")
	@JsonIgnoreProperties(value="medicineid",allowSetters = true)
	private Medicine medicineid;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public Visit getVisitid() {
		return visitid;
	}

	public void setVisitid(Visit visitid) {
		this.visitid = visitid;
	}

	public Medicine getMedicineid() {
		return medicineid;
	}

	public void setMedicineid(Medicine medicineid) {
		this.medicineid = medicineid;
	}

	@Override
	public String toString() {
		return "Prescription [id=" + id + ", Dosage=" + Dosage + ", instructions=" + instructions + ", quantity="
				+ quantity + ", created_at=" + created_at + ", morning_dose=" + morning_dose + ", afternoon_dose="
				+ afternoon_dose + ", evening_dose=" + evening_dose + ", duration_day=" + duration_day
				+ ", total_quantity=" + total_quantity + ", quantity_note=" + quantity_note + ", dose_qty=" + dose_qty
				+ ", dose_unit=" + dose_unit + ", visitid=" + visitid + ", medicineid=" + medicineid + "]";
	}

	public Prescription(int id, String dosage, String instructions, int quantity, LocalDateTime created_at,
			int morning_dose, int afternoon_dose, int evening_dose, int duration_day, int total_quantity,
			String quantity_note, String dose_qty, String dose_unit, Visit visitid, Medicine medicineid) {
		super();
		this.id = id;
		Dosage = dosage;
		this.instructions = instructions;
		this.quantity = quantity;
		this.created_at = created_at;
		this.morning_dose = morning_dose;
		this.afternoon_dose = afternoon_dose;
		this.evening_dose = evening_dose;
		this.duration_day = duration_day;
		this.total_quantity = total_quantity;
		this.quantity_note = quantity_note;
		this.dose_qty = dose_qty;
		this.dose_unit = dose_unit;
		this.visitid = visitid;
		this.medicineid = medicineid;
	}

	public Prescription() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
