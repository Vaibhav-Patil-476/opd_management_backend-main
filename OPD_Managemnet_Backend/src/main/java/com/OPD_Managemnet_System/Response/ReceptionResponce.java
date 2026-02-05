package com.OPD_Managemnet_System.Response;

//define Reception Response after login 
public class ReceptionResponce {

	private int id;
	private String name;
	private String email;
	private long phoneNo;
	private String shift;
	private int doctor_id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getShift() {
		return shift;
	}

	public void setShift(String shift) {
		this.shift = shift;
	}

	public int getDoctor_id() {
		return doctor_id;
	}

	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}

	@Override
	public String toString() {
		return "ReceptionResponse [id=" + id + ", name=" + name + ", email=" + email + ", phoneNo=" + phoneNo
				+ ", shift=" + shift + ", doctor_id=" + doctor_id + "]";
	}

	public ReceptionResponce(int id, String name, String email, long phoneNo, String shift, int doctor_id) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phoneNo = phoneNo;
		this.shift = shift;
		this.doctor_id = doctor_id;
	}

	public ReceptionResponce() {
		super();
		// TODO Auto-generated constructor stub
	}

}
