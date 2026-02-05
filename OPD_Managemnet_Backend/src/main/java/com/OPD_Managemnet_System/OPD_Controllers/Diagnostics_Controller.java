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

import com.OPD_Managemnet_System.OPDEntitys.Diagnostics;

import com.OPD_Managemnet_System.OPDEntitys.Doctor;
import com.OPD_Managemnet_System.OPDEntitys.Visit;
import com.OPD_Managemnet_System.OPDServices.Diagnostics_Service;
import com.OPD_Managemnet_System.OPDServices.Doctor_Service;
import com.OPD_Managemnet_System.OPDServices.Visit_Service;
import com.OPD_Managemnet_System.OPD_DTOs.Diagnostics_DTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("Diagnostics") // Base URL for Diagnostics APIs
public class Diagnostics_Controller {

	// ---------------------- AUTOWIRED SERVICES ----------------------

	// Handles diagnostics-related business logic
	@Autowired
	private Diagnostics_Service diagnostics_Service;

	// Used to fetch doctor details
	@Autowired
	private Doctor_Service doctor_Service;

	// Used to fetch visit details
	@Autowired
	private Visit_Service visit_Service;

	// ---------------------- CREATE DIAGNOSTICS ----------------------

	// Save diagnostics details into database
	@PostMapping("/")
	public ResponseEntity<Diagnostics> SaveDiagnostics(@Valid @RequestBody Diagnostics_DTO diagnostics_DTO) {

		// Create Diagnostics entity object
		Diagnostics diagnostics = new Diagnostics();

		// Map DTO data to Entity
		diagnostics.setName(diagnostics_DTO.getName());
		diagnostics.setCreatedAt(diagnostics_DTO.getCreate_at());

		// Fetch doctor using doctor ID
		Doctor doctor = doctor_Service.getBYID(diagnostics_DTO.getDoctorid());
		diagnostics.setDoctorid(doctor);

		// Fetch visit using visit ID
		Visit visit = visit_Service.getBYID(diagnostics_DTO.getVisitid());
		diagnostics.setVisitid(visit);

		// Save diagnostics record
		Diagnostics savediagnostics = diagnostics_Service.saveDiagnostics(diagnostics);

		return new ResponseEntity<>(savediagnostics, HttpStatus.CREATED);

	}

	// ---------------------- GET ALL DIAGNOSTICS ----------------------

	// Fetch all diagnostics records from database
	@GetMapping("/")
	public ResponseEntity<List<Diagnostics>> getAllDiagnostics() {

		List<Diagnostics> diagnostics = diagnostics_Service.getAllDiagnostics();

		// Return 404 if no records found
		if (diagnostics == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}
		return new ResponseEntity<>(diagnostics, HttpStatus.OK);
	}

	// ---------------------- GET DIAGNOSTICS BY ID ----------------------

	// Fetch diagnostics record using diagnostics ID
	@GetMapping("/{id}")
	public ResponseEntity<Diagnostics> getDiagnosticsById(@PathVariable("id") int id) {

		Diagnostics diagnostics = diagnostics_Service.getByDiagnosticsID(id);

		// Return 404 if diagnostics not found
		if (diagnostics == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(HttpStatus.OK);
	}

	// ---------------------- UPDATE DIAGNOSTICS ----------------------

	// Update diagnostics record using ID
	@PutMapping("/{id}")
	public ResponseEntity<Diagnostics> UpaddteDiagnosticsById(@PathVariable("id") int id,
			@Valid @RequestBody Diagnostics_DTO diagnostics_DTO) {

		Diagnostics diagnostics = diagnostics_Service.getByDiagnosticsID(id);

		// Check if diagnostics exists before update
		if (diagnostics == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		// Update diagnostics details
		diagnostics.setName(diagnostics_DTO.getName());
		diagnostics.setCreatedAt(diagnostics_DTO.getCreate_at());

		// Update doctor reference
		Doctor docter = doctor_Service.getBYID(diagnostics_DTO.getDoctorid());
		diagnostics.setDoctorid(docter);

		// Update visit reference
		Visit visit = visit_Service.getBYID(diagnostics_DTO.getVisitid());
		diagnostics.setVisitid(visit);

		return new ResponseEntity<>(HttpStatus.CREATED);

	}

	// ---------------------- DELETE DIAGNOSTICS ----------------------

	// Delete diagnostics record using ID
	@DeleteMapping("{id}")
	public ResponseEntity<Void> DeleteDiagnosticsById(@PathVariable("id") int id) {

		Diagnostics diagnostics = diagnostics_Service.getByDiagnosticsID(id);

		// Check if diagnostics exists before deletion
		if (diagnostics == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		// Delete diagnostics record
		diagnostics_Service.deleteById(id);

		return new ResponseEntity<>(HttpStatus.MOVED_PERMANENTLY);
	}
}
