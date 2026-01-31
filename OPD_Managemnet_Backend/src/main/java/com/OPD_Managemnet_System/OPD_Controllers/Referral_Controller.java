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
@RequestMapping("/Referral")

public class Referral_Controller {

	@Autowired
	private Referral_Service referral_Service;
	
	@Autowired
	private Doctor_Service doctor_service;
	
	@Autowired
	private Visit_Service visit_Service;
	
	@Autowired
	private Patient_Service patient_Service;
	
	@PostMapping("/")
	public ResponseEntity<Referral> SaveRefarral(@Valid @RequestBody Referral_DTO referral_DTO){
		Referral referral=new Referral();
		
		referral.setDetails(referral_DTO.getDetails());
		referral.setCreate_at(referral_DTO.getCreate_at());
		referral.setNote_type(referral_DTO.getNote_type());
		referral.setReson(referral_DTO.getReson());
		
		Doctor Doctor=doctor_service.getBYID(referral_DTO.getDoctorid());
		referral.setDoctorid(Doctor);
		
		Visit visit = visit_Service.getBYID(referral_DTO.getVisitid());
		referral.setVisitid(visit);
		
		Patient patient = patient_Service.getBYID(referral_DTO.getVisitid());
		referral.setPatientid(patient);
		
		Referral SaveReferral=referral_Service.save(referral);
		
		return new ResponseEntity<>(SaveReferral,HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Referral>> GetAllReferral(){
		List<Referral> referral=referral_Service.getAllReferral();
	if(referral==null) {
		return new ResponseEntity<>(HttpStatus.FOUND);
	}return new ResponseEntity<>(referral,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Referral> GetReferralById(@PathVariable("id") int id){
		Referral referral = referral_Service.GetReferralById(id);
		if(referral==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}		
		return new ResponseEntity<>(referral,HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Referral> UpdateReferralById(@PathVariable("id") int id,@Valid @RequestBody Referral_DTO referral_DTO){
		Referral referral = referral_Service.GetReferralById(id);
		if(referral==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		referral.setDetails(referral_DTO.getDetails());
		referral.setCreate_at(referral_DTO.getCreate_at());
		referral.setNote_type(referral_DTO.getNote_type());
		referral.setReson(referral_DTO.getReson());
		
		Doctor doctor=doctor_service.getBYID(referral_DTO.getDoctorid());
		referral.setDoctorid(doctor);
		
		Visit visit = visit_Service.getBYID(referral_DTO.getVisitid());
		referral.setVisitid(visit);
		
		Patient patient = patient_Service.getBYID(referral_DTO.getVisitid());
		referral.setPatientid(patient);
		
		return new ResponseEntity<>(referral,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> DeleteRefferalById(@PathVariable("id") int id){
		Referral referral = referral_Service.GetReferralById(id);
		if(referral==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}referral_Service.deleteReferralById(id);
		return new ResponseEntity<>(HttpStatus.MOVED_PERMANENTLY);
	}
}




