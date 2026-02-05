package com.OPD_Managemnet_System.OPDServices;

import java.util.List;

import com.OPD_Managemnet_System.OPDEntitys.Patient;

public interface Patient_Service {

	// User defined method for save data
	Patient save(Patient patient);

	// User defined method for get all Patient
	List<Patient> getAll();

	// User defined method for show patient data by id
	Patient getBYID(int id);

	// User defined method for delete record using id
	void delete(int id);

	// User defined method for find patient by doctor id
	List<Patient> findPatientByDoctor(int docterId);
}
