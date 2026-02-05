package com.OPD_Managemnet_System.OPD_DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class Test_Master_DTO {

	@NotBlank(message = "Test name is required")
	private String test_name;

	@NotBlank(message = "Normal range is required")
	private String normal_range;

	@NotBlank(message = "Unit is required")
	private String unit;

	@NotNull(message = "Doctor ID is required")
	@Positive(message = "Doctor ID must be a positive number")
	private int docterid;

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

	public int getDocterid() {
		return docterid;
	}

	public void setDocterid(int docterid) {
		this.docterid = docterid;
	}

}
