package com.OPD_Managemnet_System.OPD_DTOs;

import java.sql.Date;
import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public class Pathology_Test_DTO {


@NotBlank(message = "Result is required")
private String result;

@NotBlank(message = "Remark is required")
private String remark;

@NotBlank(message = "Report file is required")
private String report_file;

@NotNull(message = "Created date is required")
private LocalDateTime create_at;

@NotNull(message = "Visit ID is required")
@PositiveOrZero(message = "Visit ID must be a positive number")
private int visitid;

@NotNull(message = "Test ID is required")
@Positive(message = "Test ID must be a positive number")
private int testid;
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getReport_file() {
		return report_file;
	}
	public void setReport_file(String report_file) {
		this.report_file = report_file;
	}
	public LocalDateTime getCreate_at() {
		return create_at;
	}
	public void setCreate_at(LocalDateTime create_at) {
		this.create_at = LocalDateTime.now();
	}
	public int getVisitid() {
		return visitid;
	}
	public void setVisitid(int visitid) {
		this.visitid = visitid;
	}
	public int getTestid() {
		return testid;
	}
	public void setTestid(int testid) {
		this.testid = testid;
	}
	
	
}
