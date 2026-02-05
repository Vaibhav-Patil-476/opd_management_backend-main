package com.OPD_Managemnet_System.OPD_DTOs;

import java.sql.Date;
import java.time.LocalDateTime;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class Visit_DTO {

	@NotNull(message = "Date is required")
	private Date date;

	@NotBlank(message = "Complaints are required")
	private String complaints;

	@NotBlank(message = "Diagnosis is required")
	private String diagnosis;

	@NotBlank(message = "Advice is required")
	private String advice;

	@NotBlank(message = "BP is required")
	private String bp;

	@NotBlank(message = "Pulse is required")
	private String pulse;

	@NotBlank(message = "Saturation is required")
	private String saturation;

	@NotBlank(message = "Temperature is required")
	private String temperature;

	@NotBlank(message = "Respiration rate is required")
	private String respiration_rate;

	@NotBlank(message = "Sugar is required")
	private String sugar;

	@NotBlank(message = "Fasting sugar is required")
	private String fasting_sugar;

	@NotBlank(message = "PP sugar is required")
	private String pp_sugar;

	@NotBlank(message = "Random sugar is required")
	private String random_sugar;

	@NotBlank(message = "Urea/Creatinine is required")
	private String urea_creatinine;

	@NotBlank(message = "Past history is required")
	private String past_history;

	@NotBlank(message = "Current medication is required")
	private String current_medication;

	@NotBlank(message = "Additional notes are required")
	private String addition_notes;

	@NotNull(message = "Weight is required")
	@Min(value = 1, message = "Weight must be greater than 0")
	private int weight;

	@NotBlank(message = "Edema is required")
	private String edema;

	@NotBlank(message = "Pallor is required")
	private String pallor;

	@NotBlank(message = "Jaundice is required")
	private String jaundice;

	@NotBlank(message = "CVS is required")
	private String cvs;

	@NotBlank(message = "RS is required")
	private String rs;

	@NotBlank(message = "PA is required")
	private String pa;

	@NotBlank(message = "CNS is required")
	private String cns;

	@NotBlank(message = "HB is required")
	private String hb;

	@NotBlank(message = "ECG is required")
	private String ecg;

	@NotNull(message = "Followup date is required")
	private LocalDateTime followup_date;

	@NotNull(message = "Created date is required")
	private LocalDateTime create_at;

	@NotNull(message = "Updated date is required")
	private LocalDateTime update_at;

	@NotNull(message = "Doctor ID is required")
	@Positive(message = "Doctor ID must be a positive number")
	private int docterid;

	@NotNull(message = "Patient ID is required")
	@Positive(message = "Patient ID must be a positive number")
	private int patientid;

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

	public int getDocterid() {
		return docterid;
	}

	public void setDocterid(int docterid) {
		this.docterid = docterid;
	}

	public int getPatientid() {
		return patientid;
	}

	public void setPatientid(int patientid) {
		this.patientid = patientid;
	}

}
