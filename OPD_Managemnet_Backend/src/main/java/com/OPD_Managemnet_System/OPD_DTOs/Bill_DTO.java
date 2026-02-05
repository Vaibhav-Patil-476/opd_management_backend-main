package com.OPD_Managemnet_System.OPD_DTOs;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDateTime;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

//DTOs are used to transfer data between client and server.

public class Bill_DTO {

	// Consultation fee charged for the visit
	@NotNull(message = "Consultation fee is required")
	
	private BigDecimal consultation_fee;

	// Payment status (PAID, PENDING, PARTIAL)
	@NotBlank(message = "Payment status is required")
	private String payment_status;

	// Payment method (CASH, UPI, CARD, ONLINE)
	@NotBlank(message = "Payment method is required")
	private String paymet_method;

	// Discount or concession amount
	@NotNull(message = "Concession amount is required")
	@DecimalMin(value = "0.0", inclusive = true, message = "Concession cannot be negative")
	private BigDecimal concession;

	// Amount already paid by patient
	@NotNull(message = "Paid amount is required")
	@DecimalMin(value = "0.0", inclusive = true, message = "Paid amount cannot be negative")
	private BigDecimal paid_amount;

	// Total amount after calculation
	@NotNull(message = "Total amount is required")
	@DecimalMin(value = "0.0", inclusive = true, message = "Total amount cannot be negative")
	private BigDecimal total_amount;

	// Pending amount to be paid
	@NotNull(message = "Pending amount is required")
	@DecimalMin(value = "0.0", inclusive = true, message = "Pending amount cannot be negative")
	private BigDecimal pending_amount;

	// Record creation date and time
	@NotNull(message = "Created date is required")
	private LocalDateTime created_at;

	// Visit ID reference
	@NotNull(message = "Visit ID is required")
	@Min(value = 1, message = "Visit ID must be greater than zero")
	private int visitid;


	public BigDecimal getConsultation_fee() {
		return consultation_fee;
	}

	public void setConsultation_fee(BigDecimal consultation_fee) {
		this.consultation_fee = consultation_fee;
	}

	public String getPayment_status() {
		return payment_status;
	}

	public void setPayment_status(String payment_status) {
		this.payment_status = payment_status;
	}

	public String getPaymet_method() {
		return paymet_method;
	}

	public void setPaymet_method(String paymet_method) {
		this.paymet_method = paymet_method;
	}

	public BigDecimal getConcession() {
		return concession;
	}

	public void setConcession(BigDecimal concession) {
		this.concession = concession;
	}

	public BigDecimal getPaid_amount() {
		return paid_amount;
	}

	public void setPaid_amount(BigDecimal paid_amount) {
		this.paid_amount = paid_amount;
	}

	public BigDecimal getTotal_amount() {
		return total_amount;
	}

	public void setTotal(BigDecimal total) {
		this.total_amount = total;
	}

	public BigDecimal getPending_amount() {
		return pending_amount;
	}

	public void setPending_amount(BigDecimal pending_amount) {
		this.pending_amount = pending_amount;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}

	public int getVisitid() {
		return visitid;
	}

	public void setVisitid(int visitid) {
		this.visitid = visitid;
	}


}
