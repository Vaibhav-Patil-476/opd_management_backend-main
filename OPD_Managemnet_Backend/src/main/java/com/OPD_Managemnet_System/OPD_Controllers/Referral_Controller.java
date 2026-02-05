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
import com.OPD_Managemnet_System.OPDEntitys.Referral;
import com.OPD_Managemnet_System.OPDEntitys.Visit;
import com.OPD_Managemnet_System.OPDServices.Doctor_Service;
import com.OPD_Managemnet_System.OPDServices.Patient_Service;
import com.OPD_Managemnet_System.OPDServices.Referral_Service;
import com.OPD_Managemnet_System.OPDServices.Visit_Service;
import com.OPD_Managemnet_System.OPD_DTOs.Referral_DTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Referral") // Base URL for Referral related APIs
public class Referral_Controller {

	// ---------------------- AUTOWIRED SERVICES ----------------------

	@Autowired
	private Referral_Service referral_Service;
	// Handles referral business logic

	@Autowired
	private Doctor_Service doctor_service;
	// Used to fetch doctor details

	@Autowired
	private Visit_Service visit_Service;
	// Used to fetch visit details

	@Autowired
	private Patient_Service patient_Service;
	// Used to fetch patient details

	// ---------------------- SAVE REFERRAL ----------------------

	// API to create and save referral record
	@PostMapping("/")
	public ResponseEntity<Referral> SaveRefarral(@Valid @RequestBody Referral_DTO referral_DTO) {

		// Create Referral entity object
		Referral referral = new Referral();

		// Map DTO fields to entity
		referral.setDetails(referral_DTO.getDetails());
		referral.setCreate_at(referral_DTO.getCreate_at());
		referral.setNote_type(referral_DTO.getNote_type());
		referral.setReson(referral_DTO.getReson());

		// Fetch and set doctor reference
		Doctor Doctor = doctor_service.getBYID(referral_DTO.getDoctorid());
		referral.setDoctorid(Doctor);

		// Fetch and set visit reference
		Visit visit = visit_Service.getBYID(referral_DTO.getVisitid());
		referral.setVisitid(visit);

		// Fetch and set patient reference
		Patient patient = patient_Service.getBYID(referral_DTO.getVisitid());
		referral.setPatientid(patient);

		// Save referral record
		Referral SaveReferral = referral_Service.save(referral);

		return new ResponseEntity<>(SaveReferral, HttpStatus.CREATED);
	}

	// ---------------------- GET ALL REFERRALS ----------------------

	// API to fetch all referral records
	@GetMapping("/")
	public ResponseEntity<List<Referral>> GetAllReferral() {

		List<Referral> referral = referral_Service.getAllReferral();

		// Return response if no records found
		if (referral == null) {
			return new ResponseEntity<>(HttpStatus.FOUND);
		}

		return new ResponseEntity<>(referral, HttpStatus.OK);
	}

	// ---------------------- GET REFERRAL BY ID ----------------------

	// API to fetch referral record by ID
	@GetMapping("/{id}")
	public ResponseEntity<Referral> GetReferralById(@PathVariable("id") int id) {

		Referral referral = referral_Service.GetReferralById(id);

		// Return 404 if referral not found
		if (referral == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(referral, HttpStatus.OK);
	}

	// ---------------------- UPDATE REFERRAL ----------------------

	// API to update referral record by ID
	@PutMapping("/{id}")
	public ResponseEntity<Referral> UpdateReferralById(@PathVariable("id") int id,
			@Valid @RequestBody Referral_DTO referral_DTO) {

		Referral referral = referral_Service.GetReferralById(id);

		// Check if referral exists before update
		if (referral == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		// Update referral details
		referral.setDetails(referral_DTO.getDetails());
		referral.setCreate_at(referral_DTO.getCreate_at());
		referral.setNote_type(referral_DTO.getNote_type());
		referral.setReson(referral_DTO.getReson());

		// Update doctor reference
		Doctor doctor = doctor_service.getBYID(referral_DTO.getDoctorid());
		referral.setDoctorid(doctor);

		// Update visit reference
		Visit visit = visit_Service.getBYID(referral_DTO.getVisitid());
		referral.setVisitid(visit);

		// Update patient reference
		Patient patient = patient_Service.getBYID(referral_DTO.getVisitid());
		referral.setPatientid(patient);

		return new ResponseEntity<>(referral, HttpStatus.CREATED);
	}

	// ---------------------- DELETE REFERRAL ----------------------

	// API to delete referral record by ID
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> DeleteRefferalById(@PathVariable("id") int id) {

		Referral referral = referral_Service.GetReferralById(id);

		// Check if referral exists before deletion
		if (referral == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		// Delete referral record
		referral_Service.deleteReferralById(id);

		return new ResponseEntity<>(HttpStatus.MOVED_PERMANENTLY);
	}
}
