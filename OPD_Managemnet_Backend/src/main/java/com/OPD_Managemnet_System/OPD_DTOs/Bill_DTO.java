package com.OPD_Managemnet_System.OPD_DTOs;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDateTime;

public class Bill_DTO {

private BigDecimal consultation_fee;
	
	private String payment_status;
	
	private String paymet_method;
	
	private BigDecimal concession;
	
	private BigDecimal paid_amount;
	
	private BigDecimal total_amount;
	
	private BigDecimal pending_amount;
	
	private LocalDateTime created_at;
	
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
