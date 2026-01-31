package com.OPD_Managemnet_System.OPD_DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class Medicine_DTO {


@NotBlank(message = "Name is required")
private String name;

@NotBlank(message = "Type is required")
private String type;

@NotNull(message = "Doctor ID is required")
@Positive(message = "Doctor ID must be a positive number")
private int docterid;
	//Genarate Getter Setter for Store temp Data 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getDocterid() {
		return docterid;
	}
	public void setDocterid(int docterid) {
		this.docterid = docterid;
	}
	
	
}
