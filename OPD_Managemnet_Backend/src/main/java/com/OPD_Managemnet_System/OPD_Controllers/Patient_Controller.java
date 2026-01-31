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

@RequestMapping("/patient")
@RestController
public class Patient_Controller {

	@Autowired
	private Patient_Service patient_Service;
	
	@Autowired
	private Doctor_Service docter_Service;
	
	@PostMapping("/register")
	public ResponseEntity<Patient> SavePatient(@Valid @RequestBody Patient_Dto patient_Dto){
		
		Patient patient= new Patient();
		
		patient.setPatient_name(patient_Dto.getPatient_name());
		patient.setAge(patient_Dto.getAge());
		patient.setAddress(patient_Dto.getAddress());
		patient.setGender(patient_Dto.getGender());
		patient.setBlood_group(patient_Dto.getBlood_group());
		patient.setAlcohol(patient_Dto.getAlcohol());
		patient.setMibileno(patient_Dto.getMibileno())
;		patient.setTobacoo(patient_Dto.getTobacoo());
		patient.setSmoking(patient_Dto.getSmoking());
		patient.setCreated_at(patient_Dto.getCreated_at());
		patient.setHeight(patient_Dto.getHeight());
		
		Doctor docter =	docter_Service.getBYID(patient_Dto.getDoctorid());
		patient.setDocterid(docter);
		
		Patient SavePatient = patient_Service.save(patient);
		
		return new ResponseEntity<>(SavePatient,HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Patient>> GetAllPatirnt(){
		
		List<Patient> patient = patient_Service.getAll();
		if(patient==null) {
			return new  ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}return new ResponseEntity<>(patient,HttpStatus.OK);		
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Patient> GetPatientById(@PathVariable("id") int id ){
		
		Patient patient = patient_Service.getBYID(id);
		if(patient==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}return new ResponseEntity<>(patient,HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Patient> UpadatePatientById(@PathVariable("id")int id ,@Valid @RequestBody Patient_Dto patient_Dto){
		
		Patient patient = patient_Service.getBYID(id);
		if(patient==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
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
		Doctor docter =	docter_Service.getBYID(patient_Dto.getDoctorid());
		patient.setDocterid(docter);
		
		Patient SavePatient = patient_Service.save(patient);
		
		return new ResponseEntity<>(SavePatient,HttpStatus.CREATED);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> DeletePatientById(@PathVariable("id") int id){
		
		Patient patient=patient_Service.getBYID(id);
		if(patient==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		patient_Service.delete(id);
		return new ResponseEntity<>(HttpStatus.MOVED_PERMANENTLY);
	}
	}
