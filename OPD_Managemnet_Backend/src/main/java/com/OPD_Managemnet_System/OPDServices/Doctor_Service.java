package com.OPD_Managemnet_System.OPDServices;

import java.util.List;

import com.OPD_Managemnet_System.OPDEntitys.Doctor;

public interface Doctor_Service {

	Doctor save(Doctor doctor); // user defined method for save data

	List<Doctor> ListofDoctors();// user defined method for show list of doctor data

	Doctor getBYID(int doctor);// user defined method for show doctor data by there id

	void delete(int id); // user defined method for delete doctor data by there id

	Doctor getDoctorByEmail(String email);// user define method for find doctor by email
}
