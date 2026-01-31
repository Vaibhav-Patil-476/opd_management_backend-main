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
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="Pathology_Tests")
public class Pathology_Test {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int id;


private String result;


private String remark;


private String report_file;


private LocalDateTime create_at;
	
	@ManyToOne
	@JoinColumn(name="visitid")
	@JsonIgnoreProperties(value={"visitid"},allowSetters = true)
	private Visit visitid;
	
	@ManyToOne
	@JoinColumn(name="testid")
	@JsonIgnoreProperties(value={"testid"},allowSetters = true)
	private Test_Master testid;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public Visit getVisitid() {
		return visitid;
	}

	public void setVisitid(Visit visitid) {
		this.visitid = visitid;
	}

	public Test_Master getTestid() {
		return testid;
	}

	public void setTestid(Test_Master testid) {
		this.testid = testid;
	}

	public Pathology_Test(int id, String result, String remark, String report_file, LocalDateTime create_at, Visit visitid,
			Test_Master testid) {
		super();
		this.id = id;
		this.result = result;
		this.remark = remark;
		this.report_file = report_file;
		this.create_at = create_at;
		this.visitid = visitid;
		this.testid = testid;
	}

	@Override
	public String toString() {
		return "Pathology_Test [id=" + id + ", result=" + result + ", remark=" + remark + ", report_file=" + report_file
				+ ", create_at=" + create_at + ", visitid=" + visitid + ", testid=" + testid + "]";
	}

	public Pathology_Test() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}