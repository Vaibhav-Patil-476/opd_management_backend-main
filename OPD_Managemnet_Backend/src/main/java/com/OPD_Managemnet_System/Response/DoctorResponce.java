package com.OPD_Managemnet_System.Response;



public class DoctorResponce {
	
	private int id;
	private String name;
	private String email;
	private String specialization;
	private String qualification;
	private String clinic_name;
	private String address;
	private Long mobileno;
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
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getClinic_name() {
		return clinic_name;
	}
	public void setClinic_name(String clinic_name) {
		this.clinic_name = clinic_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getMobileno() {
		return mobileno;
	}
	public void setMobileno(Long mobileno) {
		this.mobileno = mobileno;
	}
	@Override
	public String toString() {
		return "DoctoreResponce [id=" + id + ", name=" + name + ", email=" + email + ", specialization="
				+ specialization + ", qualification=" + qualification + ", clinic_name=" + clinic_name + ", address="
				+ address + ", mobileno=" + mobileno + "]";
	}
	public DoctorResponce(int id, String name, String email, String specialization, String qualification,
			String clinic_name, String address, long mobileno) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.specialization = specialization;
		this.qualification = qualification;
		this.clinic_name = clinic_name;
		this.address = address;
		this.mobileno = mobileno;
	}
	public DoctorResponce() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	

	
	
}
