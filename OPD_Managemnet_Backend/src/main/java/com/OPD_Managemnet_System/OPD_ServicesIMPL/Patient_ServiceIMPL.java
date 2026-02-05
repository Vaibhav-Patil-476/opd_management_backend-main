package com.OPD_Managemnet_System.OPD_ServicesIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OPD_Managemnet_System.ExceptionHandling.DatabaseException;
import com.OPD_Managemnet_System.ExceptionHandling.ResourceNotFoundException;
import com.OPD_Managemnet_System.OPDEntitys.Patient;
import com.OPD_Managemnet_System.OPDRepo.PatientRepo;
import com.OPD_Managemnet_System.OPDServices.Patient_Service;

@Service
public class Patient_ServiceIMPL implements Patient_Service {

	@Autowired
	private PatientRepo patientRepo;

	@Override
	public Patient save(Patient patient) {
		try {
			return patientRepo.save(patient);// repository method
		} catch (Exception e) {
			throw new DatabaseException("Internal Server Error....!");
		}

	}

	@Override
	public List<Patient> getAll() {
		try {
			return patientRepo.findAll();// repository method
		} catch (Exception e) {
			throw new ResourceNotFoundException("patient List not exists...!");
		}

	}

	@Override
	public Patient getBYID(int id) {
		// TODO Auto-generated method stub
		return patientRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Patient not exists with this id...!" + id));
	}

	@Override
	public void delete(int id) {
		try {
			patientRepo.deleteById(id);// repository method
		} catch (Exception e) {
			throw new ResourceNotFoundException("Patient not exists with this id...!" + id);
		}

	}

	@Override
	public List<Patient> findPatientByDoctor(int docterId) {
		try {
			return patientRepo.findByDoctorid_Id(docterId);
		} catch (Exception e) {
			throw new ResourceNotFoundException("Doctor id Not exists....!");
		}

	}

}
