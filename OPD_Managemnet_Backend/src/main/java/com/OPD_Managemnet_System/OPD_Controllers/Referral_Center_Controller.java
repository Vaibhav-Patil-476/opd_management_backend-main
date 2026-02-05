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
import com.OPD_Managemnet_System.OPDEntitys.Referral_Center;
import com.OPD_Managemnet_System.OPDServices.Doctor_Service;
import com.OPD_Managemnet_System.OPDServices.Referral_Center_Service;
import com.OPD_Managemnet_System.OPD_DTOs.Medicine_DTO;
import com.OPD_Managemnet_System.OPD_DTOs.Referral_Center_DTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Referral_Center") // Base URL for Referral Center APIs
public class Referral_Center_Controller {

	// ---------------------- AUTOWIRED SERVICES ----------------------

	@Autowired
	private Referral_Center_Service referral_Center_Service;
	// Handles Referral Center related business logic

	@Autowired
	private Doctor_Service docter_Service;
	// Used to fetch Doctor details

	// ---------------------- SAVE REFERRAL CENTER ----------------------

	// API to create and save a Referral Center record
	@PostMapping("/")
	private ResponseEntity<Referral_Center> SaveReferral_Center(
			@Valid @RequestBody Referral_Center_DTO referral_Center_DTO) {

		// Create Referral_Center entity object
		Referral_Center referral_Center = new Referral_Center();

		// Map DTO data to entity
		referral_Center.setName(referral_Center_DTO.getName());
		referral_Center.setType(referral_Center_DTO.getType());
		referral_Center.setAddress(referral_Center_DTO.getAddress());
		referral_Center.setContact_info(referral_Center_DTO.getContact_info());
		referral_Center.setCreated_at(referral_Center_DTO.getCreated_at());

		// Fetch doctor using doctor ID
		Doctor docter = docter_Service.getBYID(referral_Center_DTO.getDocterid());
		referral_Center.setDoctorid(docter);

		// Save referral center record
		Referral_Center SaveReferral_Center = referral_Center_Service.save(referral_Center);

		return new ResponseEntity<>(SaveReferral_Center, HttpStatus.CREATED);
	}

	// ---------------------- GET ALL REFERRAL CENTERS ----------------------

	// API to fetch all referral center records
	@GetMapping("/")
	private ResponseEntity<List<Referral_Center>> GetAllReferral_Center() {

		List<Referral_Center> referral_Center = referral_Center_Service.GetAllMedicine();

		// Return 404 if no records found
		if (referral_Center == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(referral_Center, HttpStatus.OK);
	}

	// ---------------------- GET REFERRAL CENTER BY ID ----------------------

	// API to fetch referral center record by ID
	@GetMapping("/{id}")
	private ResponseEntity<Referral_Center> GetReferral_CenterById(@PathVariable("id") int id) {

		Referral_Center referral_Center = referral_Center_Service.GetReferral_CenterById(id);

		// Return 404 if record not found
		if (referral_Center == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(referral_Center, HttpStatus.OK);
	}

	// ---------------------- UPDATE REFERRAL CENTER ----------------------

	// API to update referral center record by ID
	@PutMapping("/{id}")
	private ResponseEntity<Referral_Center> UpdateReferral_CenterById(@PathVariable("id") int id,
			@Valid @RequestBody Referral_Center_DTO referral_Center_DTO) {

		Referral_Center referral_Center = referral_Center_Service.GetReferral_CenterById(id);

		// Check if referral center exists before update
		if (referral_Center == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		// Update referral center details
		referral_Center.setName(referral_Center_DTO.getName());
		referral_Center.setType(referral_Center_DTO.getType());
		referral_Center.setAddress(referral_Center_DTO.getAddress());
		referral_Center.setContact_info(referral_Center_DTO.getContact_info());
		referral_Center.setCreated_at(referral_Center_DTO.getCreated_at());

		// Update doctor reference
		Doctor docter = docter_Service.getBYID(referral_Center_DTO.getDocterid());
		referral_Center.setDoctorid(docter);

		// Save updated referral center record
		Referral_Center SaveReferral_Center = referral_Center_Service.save(referral_Center);

		return new ResponseEntity<>(SaveReferral_Center, HttpStatus.CREATED);
	}

	// ---------------------- DELETE REFERRAL CENTER ----------------------

	// API to delete referral center record by ID
	@DeleteMapping("/{id}")
	private ResponseEntity<Referral_Center> DeleteReferral_CenterById(@PathVariable("id") int id) {

		Referral_Center referral_Center = referral_Center_Service.GetReferral_CenterById(id);

		// Check if referral center exists before deletion
		if (referral_Center == null) {
			new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		// Delete referral center record
		referral_Center_Service.deleteById(id);

		return new ResponseEntity<>(HttpStatus.MOVED_PERMANENTLY);
	}
}
