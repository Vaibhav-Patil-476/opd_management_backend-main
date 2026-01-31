package com.OPD_Managemnet_System.OPD_DTOs;

import java.sql.Date;
import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

public class Visit_Report_DTO {


@NotBlank(message = "File name is required")
private String file_name;

@NotBlank(message = "File URL is required")
@Pattern(regexp = "^(http|https)://.*$", message = "File URL must be a valid URL")
private String file_url;

@NotBlank(message = "File type is required")
private String file_type;

@NotNull(message = "Created date is required")
private LocalDateTime created_at;

@NotNull(message = "Visit ID is required")
@Positive(message = "Visit ID must be a positive number")
private int visitid;

	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	public String getFile_url() {
		return file_url;
	}
	public void setFile_url(String file_url) {
		this.file_url = file_url;
	}
	public String getFile_type() {
		return file_type;
	}
	public void setFile_type(String file_type) {
		this.file_type = file_type;
	}
	public LocalDateTime getCreated_at() {
		return created_at;
	}
	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = LocalDateTime.now();
	}
	public int getVisitid() {
		return visitid;
	}
	public void setVsitid(int visitid) {
		this.visitid = visitid;
	}
	
	
}
