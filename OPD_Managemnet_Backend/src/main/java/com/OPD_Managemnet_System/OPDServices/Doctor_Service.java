package com.OPD_Managemnet_System.OPDServices;

import java.util.List;


import com.OPD_Managemnet_System.OPDEntitys.Doctor;


public interface Doctor_Service {

	Doctor save(Doctor doctor);
	
	List<Doctor> ListofDoctors();
	
	Doctor getBYID(int doctor);
	
	void delete (int id);
	
	Doctor getDoctorByEmail(String email);
}
 