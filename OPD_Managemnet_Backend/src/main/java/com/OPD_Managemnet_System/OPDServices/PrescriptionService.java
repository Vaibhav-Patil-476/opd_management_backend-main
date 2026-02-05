package com.OPD_Managemnet_System.OPDServices;



import java.util.List;

import com.OPD_Managemnet_System.OPDEntitys.Prescription;

public interface PrescriptionService {

	Prescription savePrescription(Prescription prescription); //user define method for save data
	
	List<Prescription> getAllPrescription();//user define method for show list of prescription
	
	Prescription getPrescriptionbyId(int id);//user define  method for get prescription by id
	
	void deletePrescriptionbyId(int id ); //user define method for delete prescription by id 
}
