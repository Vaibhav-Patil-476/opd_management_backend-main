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
import com.OPD_Managemnet_System.OPDEntitys.Test_Master;
import com.OPD_Managemnet_System.OPDServices.Doctor_Service;
import com.OPD_Managemnet_System.OPDServices.Test_Master_Service;
import com.OPD_Managemnet_System.OPD_DTOs.Test_Master_DTO;

import jakarta.validation.Valid;

@RequestMapping("/Test_Master") // Base URL for Test Master related APIs
@RestController
public class Test_Master_Contoller {

	// ---------------------- AUTOWIRED SERVICES ----------------------

	@Autowired
	private Doctor_Service docter_Service;
	// Used to fetch doctor details

	@Autowired
	private Test_Master_Service master_Service;
	// Handles Test Master business logic

	// ---------------------- SAVE TEST MASTER ----------------------

	// API to create and save Test Master record
	@PostMapping("/")
	public ResponseEntity<Test_Master> SaveTest_Master(@Valid @RequestBody Test_Master_DTO test_master_DTO) {

		// Create Test_Master entity object
		Test_Master test_master = new Test_Master();

		// Map DTO fields to entity
		test_master.setTest_name(test_master_DTO.getTest_name());
		test_master.setNormal_range(test_master_DTO.getNormal_range());
		test_master.setUnit(test_master_DTO.getUnit());

		// Fetch and set doctor reference
		Doctor docter = docter_Service.getBYID(test_master_DTO.getDocterid());
		test_master.setDoctorid(docter);

		// Save Test Master record
		Test_Master saveTest_Master = master_Service.save(test_master);

		return new ResponseEntity<>(saveTest_Master, HttpStatus.CREATED);
	}

	// ---------------------- GET ALL TEST MASTER ----------------------

	// API to fetch all Test Master records
	@GetMapping("/")
	public ResponseEntity<List<Test_Master>> GetAllTest_Master() {

		List<Test_Master> test_Master = master_Service.ListofTest_Master();

		// Return 404 if no records found
		if (test_Master == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(test_Master, HttpStatus.OK);
	}

	// ---------------------- GET TEST MASTER BY ID ----------------------

	// API to fetch Test Master record by ID
	@GetMapping("/{id}")
	public ResponseEntity<Test_Master> GetByTest_MasterID(@PathVariable("id") int id) {

		Test_Master test_Master = master_Service.getBYTest_MasterID(id);

		// Return 404 if record not found
		if (test_Master == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(test_Master, HttpStatus.OK);
	}

	// ---------------------- UPDATE TEST MASTER ----------------------

	// API to update Test Master record by ID
	@PutMapping("/{id}")
	public ResponseEntity<Test_Master> UpdateDocterRecord(@PathVariable("id") int id,
			@Valid @RequestBody Test_Master_DTO test_master_DTO) {

		Test_Master test_master = master_Service.getBYTest_MasterID(id);

		// Check if record exists before update
		if (test_master == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		// Update Test Master details
		test_master.setTest_name(test_master_DTO.getTest_name());
		test_master.setNormal_range(test_master_DTO.getNormal_range());
		test_master.setUnit(test_master_DTO.getUnit());

		// Update doctor reference
		Doctor docter = docter_Service.getBYID(test_master_DTO.getDocterid());
		test_master.setDoctorid(docter);

		// Save updated record
		Test_Master saveTest_Master = master_Service.save(test_master);

		return new ResponseEntity<>(saveTest_Master, HttpStatus.CREATED);
	}

	// ---------------------- DELETE TEST MASTER ----------------------

	// API to delete Test Master record by ID
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> DeleteTest_Master(@PathVariable("id") int id) {

		Test_Master test_master = master_Service.getBYTest_MasterID(id);

		// Check if record exists before deletion
		if (test_master == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		// Delete Test Master record
		docter_Service.delete(id);

		return new ResponseEntity<>(HttpStatus.MOVED_PERMANENTLY);
	}
}
