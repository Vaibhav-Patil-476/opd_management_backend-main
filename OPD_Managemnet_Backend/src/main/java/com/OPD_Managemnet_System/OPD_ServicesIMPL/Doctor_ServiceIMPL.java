package com.OPD_Managemnet_System.OPD_ServicesIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OPD_Managemnet_System.ExceptionHandling.DatabaseException;
import com.OPD_Managemnet_System.ExceptionHandling.Dublicate_Exception;
import com.OPD_Managemnet_System.ExceptionHandling.ResourceNotFoundException;
import com.OPD_Managemnet_System.OPDEntitys.Doctor;
import com.OPD_Managemnet_System.OPDRepo.Doctor_Repo;
import com.OPD_Managemnet_System.OPDServices.Doctor_Service;

@Service
public class Doctor_ServiceIMPL implements Doctor_Service {
	
	@Autowired
	private Doctor_Repo doctor_Repo;

	@Override
	public Doctor save(Doctor doctor) {
		if(doctor_Repo.existsByEmail(doctor.getEmail())){
			throw new Dublicate_Exception("This Doctor Already Exits:");
		}
		try {
			return doctor_Repo.save(doctor);
		} catch (Exception ex) {
			
			throw new DatabaseException("Internal Server Error..!");
		}
	
	}

	@Override
	public List<Doctor> ListofDoctors() {
		try {
			return doctor_Repo.findAll();
		} catch (Exception e) {
			throw new ResourceNotFoundException("Doctor List not exists...!");
		}
		
	}

	@Override
	public Doctor getBYID(int id) {
		
		return doctor_Repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Doctor dose't exists by this is" +id));
	}

	@Override
	public void delete(int id) {
		try {
			doctor_Repo.deleteById(id);
		} catch (Exception e) {
			throw new ResourceNotFoundException("This id is Dose not exists...!");
		}
		
	}

	@Override
	public Doctor getDoctorByEmail(String email) {
		try {
			return doctor_Repo.findByEmail(email)// custom repository method
					.orElseThrow(() -> new ResourceNotFoundException("Doctor not found with email: " + email));
		} catch (Exception e) {
			throw new DatabaseException("Failed to get doctor due to database error");
		}
	}



}
