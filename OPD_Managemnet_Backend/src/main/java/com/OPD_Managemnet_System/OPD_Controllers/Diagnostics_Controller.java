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
@RequestMapping("Diagnostics")
public class Diagnostics_Controller {

	//Autowired all required Service file input 
	@Autowired
	private Diagnostics_Service diagnostics_Service;
	
	@Autowired
	private Doctor_Service doctor_Service;
	
	@Autowired
	private Visit_Service visit_Service;
	
	//postmapping method for save diagnostics in database
	@PostMapping("/")
	public ResponseEntity<Diagnostics> SaveDiagnostics(@Valid@RequestBody Diagnostics_DTO diagnostics_DTO){
		Diagnostics diagnostics = new Diagnostics();
		
		diagnostics.setName(diagnostics_DTO.getName());
		diagnostics.setCreatedAt(diagnostics_DTO.getCreate_at());
		
		Doctor doctor=doctor_Service.getBYID(diagnostics_DTO.getDoctorid());
		diagnostics.setDoctorid(doctor);
		
		Visit visit = visit_Service.getBYID(diagnostics_DTO.getVisitid());
		diagnostics.setVisitid(visit);
		
		Diagnostics savediagnostics=diagnostics_Service.saveDiagnostics(diagnostics);
		
		return new ResponseEntity<>(savediagnostics,HttpStatus.CREATED);
		
	}
	
	//getmapping method for get all diagnostics from database
	@GetMapping("/")
	public ResponseEntity<List<Diagnostics>> getAllDiagnostics(){
		List<Diagnostics> diagnostics=diagnostics_Service.getAllDiagnostics();
		if(diagnostics==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}return new ResponseEntity<>(diagnostics,HttpStatus.OK);
	}
	
	
	//postmapping method for get all diagnostics by id from  database
	@GetMapping("/{id}")
	public ResponseEntity<Diagnostics> getDiagnosticsById(@PathVariable("id") int id){
		Diagnostics diagnostics = diagnostics_Service.getByDiagnosticsID(id);
		if(diagnostics==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(HttpStatus.OK);	
	}
	
	//put mapping method for get and  update diagnostics in database
	@PutMapping("/{id}")
	public ResponseEntity<Diagnostics> UpaddteDiagnosticsById(@PathVariable("id") int id,@Valid @RequestBody Diagnostics_DTO diagnostics_DTO){
		Diagnostics diagnostics = diagnostics_Service.getByDiagnosticsID(id);
		if(diagnostics==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		diagnostics.setName(diagnostics_DTO.getName());
		diagnostics.setCreatedAt(diagnostics_DTO.getCreate_at());
		
		Doctor docter=doctor_Service.getBYID(diagnostics_DTO.getDoctorid());
		diagnostics.setDoctorid(docter);
		
		Visit visit = visit_Service.getBYID(diagnostics_DTO.getVisitid());
		diagnostics.setVisitid(visit);
		
		return new ResponseEntity<>(HttpStatus.CREATED);
		
		
	}
	
	//Delete mapping method for delete diagnostics by id  in database
	@DeleteMapping("{id}")
	public ResponseEntity<Void> DeleteDiagnosticsById(@PathVariable("id") int id ){
		Diagnostics diagnostics = diagnostics_Service.getByDiagnosticsID(id);
		if(diagnostics==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}diagnostics_Service.deleteById(id);
		return new ResponseEntity<>(HttpStatus.MOVED_PERMANENTLY);
	}
}
