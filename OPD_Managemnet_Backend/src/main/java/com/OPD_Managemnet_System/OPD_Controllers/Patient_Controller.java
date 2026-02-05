package com.OPD_Managemnet_System.OPD_Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.OPD_Managemnet_System.OPDEntitys.Doctor;
import com.OPD_Managemnet_System.OPDEntitys.Patient;

import com.OPD_Managemnet_System.OPDServices.Doctor_Service;
import com.OPD_Managemnet_System.OPDServices.Patient_Service;
import com.OPD_Managemnet_System.OPD_DTOs.Patient_Dto;

import jakarta.validation.Valid;

@RequestMapping("/patient") // Base URL for Patient APIs
@RestController
public class Patient_Controller {

	// ---------------------- AUTOWIRED SERVICES ----------------------

	@Autowired
	private Patient_Service patient_Service; // Handles patient related operations

	@Autowired
	private Doctor_Service docter_Service; // Used to fetch doctor details

	// ---------------------- REGISTER NEW PATIENT ----------------------

	@PostMapping("/register")
	public ResponseEntity<Patient> SavePatient(@Valid @RequestBody Patient_Dto patient_Dto) {

		// Create Patient entity object
		Patient patient = new Patient();

		// Map DTO values to Patient entity
		patient.setPatient_name(patient_Dto.getPatient_name());
		patient.setAge(patient_Dto.getAge());
		patient.setAddress(patient_Dto.getAddress());
		patient.setGender(patient_Dto.getGender());
		patient.setBlood_group(patient_Dto.getBlood_group());
		patient.setAlcohol(patient_Dto.getAlcohol());
		patient.setMibileno(patient_Dto.getMibileno());
		patient.setTobacoo(patient_Dto.getTobacoo());
		patient.setSmoking(patient_Dto.getSmoking());
		patient.setCreated_at(patient_Dto.getCreated_at());
		patient.setHeight(patient_Dto.getHeight());

		// Fetch doctor using doctor ID
		Doctor docter = docter_Service.getBYID(patient_Dto.getDoctorid());
		patient.setDocterid(docter);

		// Save patient record
		Patient SavePatient = patient_Service.save(patient);

		return new ResponseEntity<>(SavePatient, HttpStatus.CREATED);
	}

	// ---------------------- GET ALL PATIENTS ----------------------

	@GetMapping("/")
	public ResponseEntity<List<Patient>> GetAllPatirnt() {

		List<Patient> patient = patient_Service.getAll();

		// Return 404 if no patients found
		if (patient == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(patient, HttpStatus.OK);
	}

	// ---------------------- GET PATIENT BY ID ----------------------

	@GetMapping("{id}")
	public ResponseEntity<Patient> GetPatientById(@PathVariable("id") int id) {

		Patient patient = patient_Service.getBYID(id);

		// Return 404 if patient not found
		if (patient == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(patient, HttpStatus.OK);
	}

	// ---------------------- UPDATE PATIENT DETAILS ----------------------

	@PutMapping("{id}")
	public ResponseEntity<Patient> UpadatePatientById(@PathVariable("id") int id,
			@Valid @RequestBody Patient_Dto patient_Dto) {

		Patient patient = patient_Service.getBYID(id);

		// Check if patient exists before update
		if (patient == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		// Update patient details
		patient.setPatient_name(patient_Dto.getPatient_name());
		patient.setAge(patient_Dto.getAge());
		patient.setAddress(patient_Dto.getAddress());
		patient.setGender(patient_Dto.getGender());
		patient.setBlood_group(patient_Dto.getBlood_group());
		patient.setAlcohol(patient_Dto.getAlcohol());
		patient.setMibileno(patient_Dto.getMibileno());
		patient.setTobacoo(patient_Dto.getTobacoo());
		patient.setSmoking(patient_Dto.getSmoking());
		patient.setHeight(patient_Dto.getHeight());

		// Update doctor reference
		Doctor docter = docter_Service.getBYID(patient_Dto.getDoctorid());
		patient.setDocterid(docter);

		// Save updated patient
		Patient SavePatient = patient_Service.save(patient);

		return new ResponseEntity<>(SavePatient, HttpStatus.CREATED);
	}

	// ---------------------- DELETE PATIENT ----------------------

	@DeleteMapping("{id}")
	public ResponseEntity<Void> DeletePatientById(@PathVariable("id") int id) {

		Patient patient = patient_Service.getBYID(id);

		// Check if patient exists before deletion
		if (patient == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		// Delete patient record
		patient_Service.delete(id);

		return new ResponseEntity<>(HttpStatus.MOVED_PERMANENTLY);
	}
}
