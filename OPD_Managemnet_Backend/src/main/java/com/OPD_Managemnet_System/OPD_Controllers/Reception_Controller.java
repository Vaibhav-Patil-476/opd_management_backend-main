package com.OPD_Managemnet_System.OPD_Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.OPD_Managemnet_System.OPDEntitys.Doctor;
import com.OPD_Managemnet_System.OPDEntitys.Reception;
import com.OPD_Managemnet_System.OPDEntitys.Role;
import com.OPD_Managemnet_System.OPDServices.Doctor_Service;
import com.OPD_Managemnet_System.OPDServices.Reception_Service;
import com.OPD_Managemnet_System.OPD_DTOs.Reception_DTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/reception") // Base URL for Reception related APIs
public class Reception_Controller {

	// ---------------------- AUTOWIRED SERVICES ----------------------

	@Autowired
	private Reception_Service reception_Service; // Handles reception related operations

	@Autowired
	private Doctor_Service doctor_Service; // Used to fetch doctor details

	@Autowired
	private PasswordEncoder encoder; // Used to encode passwords securely

	// ---------------------- REGISTER RECEPTION ----------------------

	// API to create and save a new Reception record
	@PostMapping("/register")
	public ResponseEntity<Reception> saveReceptionRecord(@Valid @RequestBody Reception_DTO reception_DTO) {

		// Create Reception entity object
		Reception reception = new Reception();

		// Map DTO data to Reception entity
		reception.setEmail(reception_DTO.getEmail());
		reception.setPassword(encoder.encode(reception_DTO.getPassword()));
		reception.setName(reception_DTO.getName());
		reception.setMobileNo(reception_DTO.getMobileNo());
		reception.setAddress(reception_DTO.getAddress());
		reception.setToken(reception_DTO.getToken());
		reception.setCreated_at(reception_DTO.getCreated_at());
		reception.setUpdated_at(reception_DTO.getUpdated_at());

		// Assign RECEPTION role
		reception.setRole(Role.RECEPTION);

		// Fetch doctor using doctor ID
		Doctor doctor = doctor_Service.getBYID(reception_DTO.getDoctorid());
		reception.setDoctorid(doctor);

		// Save reception record
		Reception saveReceptionRecord = reception_Service.save(reception);

		return new ResponseEntity<>(saveReceptionRecord, HttpStatus.CREATED);
	}

	// ---------------------- GET ALL RECEPTION RECORDS ----------------------

	// API to fetch all reception records
	@GetMapping("/")
	@PreAuthorize("hasRole('RECEPTION')")
	public ResponseEntity<List<Reception>> getAllReceptionRecords() {

		List<Reception> reception = reception_Service.getallReception();

		// Return 404 if no records found
		if (reception == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(reception, HttpStatus.OK);
	}

	// ---------------------- GET RECEPTION BY ID ----------------------

	// API to fetch reception record by ID
	@GetMapping("/{id}")
	public ResponseEntity<Reception> getReceptionByID(@PathVariable("id") int id) {

		Reception reception = reception_Service.getReceptionById(id);

		// Return 404 if reception not found
		if (reception == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(reception, HttpStatus.OK);
	}

	// ---------------------- UPDATE RECEPTION RECORD ----------------------

	// API to update reception details
	@PutMapping("/{id}")
	@PreAuthorize("hasRole('RECEPTION')")
	public ResponseEntity<Reception> updateReceptionRecord(@PathVariable("id") int id,
			@Valid @RequestBody Reception_DTO reception_DTO) {

		Reception reception = reception_Service.getReceptionById(id);

		// Check if reception exists before update
		if (reception == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		// Update reception details
		reception.setName(reception_DTO.getName());
		reception.setMobileNo(reception_DTO.getMobileNo());
		reception.setAddress(reception_DTO.getAddress());
		reception.setToken(reception_DTO.getToken());
		reception.setUpdated_at(reception_DTO.getUpdated_at());

		// Update doctor reference
		Doctor doctor = doctor_Service.getBYID(reception_DTO.getDoctorid());
		reception.setDoctorid(doctor);

		// Save updated reception record
		Reception saveReceptionRecord = reception_Service.save(reception);

		return new ResponseEntity<>(saveReceptionRecord, HttpStatus.CREATED);
	}

	// ---------------------- DELETE RECEPTION RECORD ----------------------

	// API to delete reception record by ID
	@DeleteMapping("/{Id}")
	@PreAuthorize("hasRole('RECEPTION')")
	public ResponseEntity<Void> deleteReceptionRecordById(@PathVariable("id") int id) {

		Reception reception = reception_Service.getReceptionById(id);

		// Check if reception exists before deletion
		if (reception == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		// Delete reception record
		reception_Service.deleteReceptionById(id);

		return new ResponseEntity<>(HttpStatus.MOVED_PERMANENTLY);
	}
}
