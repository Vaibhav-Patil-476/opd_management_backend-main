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
import com.OPD_Managemnet_System.OPDEntitys.Medicine;

import com.OPD_Managemnet_System.OPDServices.Doctor_Service;
import com.OPD_Managemnet_System.OPDServices.Medicine_Service;
import com.OPD_Managemnet_System.OPD_DTOs.Medicine_DTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Medicine") // Base URL for Medicine APIs
public class Medicine_Controller {

	// ---------------------- AUTOWIRED SERVICES ----------------------

	@Autowired
	private Medicine_Service medicine_Service; // Handles medicine business logic

	@Autowired
	private Doctor_Service docter_Service; // Used to fetch doctor details

	// ---------------------- CREATE MEDICINE ----------------------

	@PostMapping("/")
	private ResponseEntity<Medicine> SaveMedicine(@Valid @RequestBody Medicine_DTO medicine_DTO) {

		// Create Medicine entity object
		Medicine medicine = new Medicine();

		// Map DTO data to Entity
		medicine.setName(medicine_DTO.getName());
		medicine.setType(medicine_DTO.getType());

		// Fetch doctor using doctor ID
		Doctor docter = docter_Service.getBYID(medicine_DTO.getDocterid());
		medicine.setDoctorid(docter);

		// Save medicine record
		Medicine savemedicine = medicine_Service.save(medicine);

		return new ResponseEntity<>(savemedicine, HttpStatus.CREATED);
	}

	// ---------------------- GET ALL MEDICINES ----------------------

	@GetMapping("/")
	private ResponseEntity<List<Medicine>> GetAllMedicine() {

		List<Medicine> medicine = medicine_Service.GetAllMedicine();

		// Return 404 if no medicines found
		if (medicine == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(medicine, HttpStatus.OK);

	}

	// ---------------------- GET MEDICINE BY ID ----------------------

	@GetMapping("/{id}")
	private ResponseEntity<Medicine> GetMedicineById(@PathVariable("id") int id) {

		Medicine medicine = medicine_Service.GetMedicineById(id);

		// Return 404 if medicine not found
		if (medicine == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(medicine, HttpStatus.OK);
	}

	// ---------------------- UPDATE MEDICINE ----------------------

	@PutMapping("/{id}")
	private ResponseEntity<Medicine> UpdateMedicineById(@PathVariable("id") int id,
			@Valid @RequestBody Medicine_DTO medicine_DTO) {

		Medicine medicine = medicine_Service.GetMedicineById(id);

		// Check if medicine exists before update
		if (medicine == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		// Update medicine details
		medicine.setName(medicine_DTO.getName());
		medicine.setType(medicine_DTO.getType());

		// Update doctor reference
		Doctor docter = docter_Service.getBYID(medicine_DTO.getDocterid());
		medicine.setDoctorid(docter);

		// Save updated medicine record
		Medicine savemedicine = medicine_Service.save(medicine);

		return new ResponseEntity<>(savemedicine, HttpStatus.CREATED);

	}

	// ---------------------- DELETE MEDICINE ----------------------

	@DeleteMapping("/{id}")
	private ResponseEntity<Medicine> DeleteMedicineById(@PathVariable("id") int id) {

		Medicine medicine = medicine_Service.GetMedicineById(id);

		// Check if medicine exists before deletion
		if (medicine == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		// Delete medicine record
		medicine_Service.deleteById(id);

		return new ResponseEntity<>(HttpStatus.MOVED_PERMANENTLY);
	}
}
