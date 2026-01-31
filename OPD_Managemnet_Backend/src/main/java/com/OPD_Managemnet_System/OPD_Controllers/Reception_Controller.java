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
@RequestMapping("/api/reception")
public class Reception_Controller {

	@Autowired
	private Reception_Service reception_Service; 
	@Autowired
	private Doctor_Service doctor_Service;
	@Autowired
	private PasswordEncoder encoder;
	//Create APi for Save Reception Records
	@PostMapping("/register")
	public ResponseEntity<Reception> saveReceptionRecord(@Valid @RequestBody Reception_DTO reception_DTO){
		Reception reception = new Reception();
		
		reception.setEmail(reception_DTO.getEmail());
		reception.setPassword(encoder.encode(reception_DTO.getPassword()));
		reception.setName(reception_DTO.getName());
		reception.setMobileNo(reception_DTO.getMobileNo());
		reception.setAddress(reception_DTO.getAddress());
		reception.setToken(reception_DTO.getToken());
		reception.setCreated_at(reception_DTO.getCreated_at());
		reception.setUpdated_at(reception_DTO.getUpdated_at());
		reception.setRole(Role.RECEPTION);
		
		Doctor doctor = doctor_Service.getBYID(reception_DTO.getDoctorid());
		reception.setDoctorid(doctor);
		System.out.println(reception);
		Reception saveReceptionRecord=reception_Service.save(reception);
		
		return new ResponseEntity<>(saveReceptionRecord,HttpStatus.CREATED);
	}
	
	//Create APi for Get Reception Records List.
	@GetMapping("/")
	@PreAuthorize("hasRole('RECEPTION')")
	public  ResponseEntity<List<Reception>> getAllReceptionRecords(){
		List<Reception> reception =reception_Service.getallReception();
		
		if(reception==null) {
			return new ResponseEntity<List<Reception>>(HttpStatus.NOT_FOUND);
		}
	
		return new ResponseEntity<List<Reception>>(reception,HttpStatus.OK);
	}
	
	//Create APi for Get Reception Records by ID
	@GetMapping("/{id}")
	public ResponseEntity<Reception> getReceptionByID(@PathVariable("id") int id ){
		
		Reception reception = reception_Service.getReceptionById(id);
		
		if(reception==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(reception,HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	@PreAuthorize("hasRole('RECEPTION')")
	public ResponseEntity<Reception> updateReceptionRecord(@PathVariable ("id") int id,@Valid @RequestBody Reception_DTO reception_DTO ){
		Reception reception = reception_Service.getReceptionById(id);
		
		if(reception==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		reception.setName(reception_DTO.getName());
		reception.setMobileNo(reception_DTO.getMobileNo());
		reception.setAddress(reception_DTO.getAddress());
		reception.setToken(reception_DTO.getToken());
		
		reception.setUpdated_at(reception_DTO.getUpdated_at());
		
		Doctor doctor = doctor_Service.getBYID(reception_DTO.getDoctorid());
		reception.setDoctorid(doctor);
		
		Reception saveReceptionRecord=reception_Service.save(reception);
		
		return new ResponseEntity<>(saveReceptionRecord,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{Id}")
	@PreAuthorize("hasRole('RECEPTION')")
	public ResponseEntity<Void> deleteReceptionRecordById(@PathVariable("id") int id){
		
		Reception reception = reception_Service.getReceptionById(id);
		
		if(reception == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		reception_Service.deleteReceptionById(id);
		return new ResponseEntity<>(HttpStatus.MOVED_PERMANENTLY);
	}
			
	}
