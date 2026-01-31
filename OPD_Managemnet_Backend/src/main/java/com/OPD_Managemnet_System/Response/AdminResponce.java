package com.OPD_Managemnet_System.Response;



public class AdminResponce {
	private int id;
	private String name;
	private String email;
	private long mobileno;
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
	public long getMobileno() {
		return mobileno;
	}
	public void setMobileno(long mobileno) {
		this.mobileno = mobileno;
	}
	@Override
	public String toString() {
		return "AdminResponse [id=" + id + ", name=" + name + ", email=" + email + ", mobileno=" + mobileno + "]";
	}
	public AdminResponce(int id, String name, String email, long mobileno) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.mobileno = mobileno;
	}
	public AdminResponce() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	


	
	
}
