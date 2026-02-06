package com.OPD_Managemnet_System.OPDRepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.OPD_Managemnet_System.OPDEntitys.Patient;

@Repository // access jpa method 
public interface PatientRepo extends JpaRepository<Patient, Integer> {
	
	//This Method for find Patient by doctor id
	 List<Patient> findByDoctorid_Id(int docterId);
	 
}

