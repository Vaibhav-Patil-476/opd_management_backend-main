package com.OPD_Managemnet_System.OPD_ServicesIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OPD_Managemnet_System.ExceptionHandling.DatabaseException;
import com.OPD_Managemnet_System.ExceptionHandling.ResourceNotFoundException;
import com.OPD_Managemnet_System.OPDEntitys.Prescription;
import com.OPD_Managemnet_System.OPDRepo.PrescriptionRepo;
import com.OPD_Managemnet_System.OPDServices.PrescriptionService;

@Service
public class PrescriptionServiceIMPL implements PrescriptionService {

	@Autowired
	private PrescriptionRepo prescriptionRepo;

	@Override
	public Prescription savePrescription(Prescription prescription) {
		try {
			return prescriptionRepo.save(prescription);
		} catch (Exception e) {
			throw new DatabaseException("Internal Server Error....!");
		}

	}
	@Override
	public List<Prescription> getAllPrescription() {
		try {
			return prescriptionRepo.findAll();
		} catch (Exception e) {
			throw new ResourceNotFoundException("Prescription List not found");
		}
		
	}

	@Override
	public Prescription getPrescriptionbyId(int id) {

		return prescriptionRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Prescription not exist by this id:" + id));
	}

	@Override
	public void deletePrescriptionbyId(int id) {
		try {
			prescriptionRepo.deleteById(id);
		} catch (Exception e) {
			throw new ResourceNotFoundException("Prescription is not exist by this id:" + id);
		}

	}

	

}
