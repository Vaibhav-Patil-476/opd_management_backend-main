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
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

//Entity class representing database table for OPD management
@Entity
@Table(name = "Visits")
public class Visit {

	// It uniquely identifies each record in the database table.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int id;

	private Date date;

	private String complaints;

	private String diagnosis;

	private String advice;

	private String bp;

	private String pulse;

	private String saturation;

	private String temperature;

	private String respiration_rate;

	private String sugar;

	private String fasting_sugar;

	private String pp_sugar;

	private String random_sugar;

	private String urea_creatinine;

	private String past_history;

	private String current_medication;

	private String addition_notes;

	private int weight;

	private String edema;

	private String pallor;

	private String jaundice;

	private String cvs;

	private String rs;

	private String pa;

	private String cns;

	private String hb;

	private String ecg;

	private LocalDateTime followup_date;

	private LocalDateTime create_at;

	private LocalDateTime update_at;

	// Apply Many to One Relationship between visit report and
	@ManyToOne
	@JoinColumn(name = "Doctorid")
	@JsonIgnoreProperties(value = "Doctorid", allowSetters = true)
	private Doctor Doctorid;

	// Apply Many to One Relationship between visit report and
	@ManyToOne
	@JoinColumn(name = "patientid")
	@JsonIgnoreProperties(value = "patientid", allowSetters = true)
	private Patient patientid;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getComplaints() {
		return complaints;
	}

	public void setComplaints(String complaints) {
		this.complaints = complaints;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String getAdvice() {
		return advice;
	}

	public void setAdvice(String advice) {
		this.advice = advice;
	}

	public String getBp() {
		return bp;
	}

	public void setBp(String bp) {
		this.bp = bp;
	}

	public String getPulse() {
		return pulse;
	}

	public void setPulse(String pulse) {
		this.pulse = pulse;
	}

	public String getSaturation() {
		return saturation;
	}

	public void setSaturation(String saturation) {
		this.saturation = saturation;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getRespiration_rate() {
		return respiration_rate;
	}

	public void setRespiration_rate(String respiration_rate) {
		this.respiration_rate = respiration_rate;
	}

	public String getSugar() {
		return sugar;
	}

	public void setSugar(String sugar) {
		this.sugar = sugar;
	}

	public String getFasting_sugar() {
		return fasting_sugar;
	}

	public void setFasting_sugar(String fasting_sugar) {
		this.fasting_sugar = fasting_sugar;
	}

	public String getPp_sugar() {
		return pp_sugar;
	}

	public void setPp_sugar(String pp_sugar) {
		this.pp_sugar = pp_sugar;
	}

	public String getRandom_sugar() {
		return random_sugar;
	}

	public void setRandom_sugar(String random_sugar) {
		this.random_sugar = random_sugar;
	}

	public String getUrea_creatinine() {
		return urea_creatinine;
	}

	public void setUrea_creatinine(String urea_creatinine) {
		this.urea_creatinine = urea_creatinine;
	}

	public String getPast_history() {
		return past_history;
	}

	public void setPast_history(String past_history) {
		this.past_history = past_history;
	}

	public String getCurrent_medication() {
		return current_medication;
	}

	public void setCurrent_medication(String current_medication) {
		this.current_medication = current_medication;
	}

	public String getAddition_notes() {
		return addition_notes;
	}

	public void setAddition_notes(String addition_notes) {
		this.addition_notes = addition_notes;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getEdema() {
		return edema;
	}

	public void setEdema(String edema) {
		this.edema = edema;
	}

	public String getPallor() {
		return pallor;
	}

	public void setPallor(String pallor) {
		this.pallor = pallor;
	}

	public String getJaundice() {
		return jaundice;
	}

	public void setJaundice(String jaundice) {
		this.jaundice = jaundice;
	}

	public String getCvs() {
		return cvs;
	}

	public void setCvs(String cvs) {
		this.cvs = cvs;
	}

	public String getRs() {
		return rs;
	}

	public void setRs(String rs) {
		this.rs = rs;
	}

	public String getPa() {
		return pa;
	}

	public void setPa(String pa) {
		this.pa = pa;
	}

	public String getCns() {
		return cns;
	}

	public void setCns(String cns) {
		this.cns = cns;
	}

	public String getHb() {
		return hb;
	}

	public void setHb(String hb) {
		this.hb = hb;
	}

	public String getEcg() {
		return ecg;
	}

	public void setEcg(String ecg) {
		this.ecg = ecg;
	}

	public LocalDateTime getFollowup_date() {
		return followup_date;
	}

	public void setFollowup_date(LocalDateTime followup_date) {
		this.followup_date = followup_date;
	}

	public LocalDateTime getCreate_at() {
		return create_at;
	}

	public void setCreate_at(LocalDateTime create_at) {
		this.create_at = LocalDateTime.now();
	}

	public LocalDateTime getUpdate_at() {
		return update_at;
	}

	public void setUpdate_at(LocalDateTime update_at) {
		this.update_at = LocalDateTime.now();
	}

	public Doctor getDoctorid() {
		return Doctorid;
	}

	public void setDoctorid(Doctor Doctorid) {
		this.Doctorid = Doctorid;
	}

	public Patient getPatientid() {
		return patientid;
	}

	public void setPatientid(Patient patientid) {
		this.patientid = patientid;
	}

	public Visit(int id, Date date, String complaints, String diagnosis, String advice, String bp, String pulse,
			String saturation, String temperature, String respiration_rate, String sugar, String fasting_sugar,
			String pp_sugar, String random_sugar, String urea_creatinine, String past_history,
			String current_medication, String addition_notes, int weight, String edema, String pallor, String jaundice,
			String cvs, String rs, String pa, String cns, String hb, String ecg, LocalDateTime followup_date,
			LocalDateTime create_at, LocalDateTime update_at, Doctor Doctorid, Patient patientid) {
		super();
		this.id = id;
		this.date = date;
		this.complaints = complaints;
		this.diagnosis = diagnosis;
		this.advice = advice;
		this.bp = bp;
		this.pulse = pulse;
		this.saturation = saturation;
		this.temperature = temperature;
		this.respiration_rate = respiration_rate;
		this.sugar = sugar;
		this.fasting_sugar = fasting_sugar;
		this.pp_sugar = pp_sugar;
		this.random_sugar = random_sugar;
		this.urea_creatinine = urea_creatinine;
		this.past_history = past_history;
		this.current_medication = current_medication;
		this.addition_notes = addition_notes;
		this.weight = weight;
		this.edema = edema;
		this.pallor = pallor;
		this.jaundice = jaundice;
		this.cvs = cvs;
		this.rs = rs;
		this.pa = pa;
		this.cns = cns;
		this.hb = hb;
		this.ecg = ecg;
		this.followup_date = followup_date;
		this.create_at = create_at;
		this.update_at = update_at;
		this.Doctorid = Doctorid;
		this.patientid = patientid;
	}

	@Override
	public String toString() {
		return "Visit [id=" + id + ", date=" + date + ", complaints=" + complaints + ", diagnosis=" + diagnosis
				+ ", advice=" + advice + ", bp=" + bp + ", pulse=" + pulse + ", saturation=" + saturation
				+ ", temperature=" + temperature + ", respiration_rate=" + respiration_rate + ", sugar=" + sugar
				+ ", fasting_sugar=" + fasting_sugar + ", pp_sugar=" + pp_sugar + ", random_sugar=" + random_sugar
				+ ", urea_creatinine=" + urea_creatinine + ", past_history=" + past_history + ", current_medication="
				+ current_medication + ", addition_notes=" + addition_notes + ", weight=" + weight + ", edema=" + edema
				+ ", pallor=" + pallor + ", jaundice=" + jaundice + ", cvs=" + cvs + ", rs=" + rs + ", pa=" + pa
				+ ", cns=" + cns + ", hb=" + hb + ", ecg=" + ecg + ", followup_date=" + followup_date + ", create_at="
				+ create_at + ", update_at=" + update_at + ", Doctorid=" + Doctorid + ", patientid=" + patientid + "]";
	}

	public Visit() {
		super();
		// TODO Auto-generated constructor stub
	}

}
