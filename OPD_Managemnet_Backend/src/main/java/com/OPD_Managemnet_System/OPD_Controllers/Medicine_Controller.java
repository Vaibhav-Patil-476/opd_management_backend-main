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
@RequestMapping("/Medicine")
public class Medicine_Controller {

	@Autowired
	private Medicine_Service medicine_Service;
	
	@Autowired
	private Doctor_Service docter_Service;
	
	@PostMapping("/")
	private ResponseEntity<Medicine> SaveMedicine(@Valid@RequestBody Medicine_DTO medicine_DTO){
		Medicine medicine = new Medicine();
		
		medicine.setName(medicine_DTO.getName());
		medicine.setType(medicine_DTO.getType());
		
		Doctor docter=docter_Service.getBYID(medicine_DTO.getDocterid());
		medicine.setDoctorid(docter);
		
		Medicine savemedicine=medicine_Service.save(medicine);
		return new ResponseEntity<>(savemedicine,HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	private ResponseEntity<List<Medicine>> GetAllMedicine(){
		List<Medicine> medicine = medicine_Service.GetAllMedicine();
		if(medicine==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}return new ResponseEntity<>(medicine,HttpStatus.OK);
		
	}
	@GetMapping("/{id}")
	private ResponseEntity<Medicine> GetMedicineById(@PathVariable("id") int id){
		Medicine medicine = medicine_Service.GetMedicineById(id);
		if(medicine==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}return new ResponseEntity<>(medicine,HttpStatus.OK);
	}
		
	
	@PutMapping("/{id}")
	private ResponseEntity<Medicine> UpdateMedicineById(@PathVariable("id") int id,@Valid @RequestBody Medicine_DTO medicine_DTO){
	Medicine medicine = medicine_Service.GetMedicineById(id);
	if(medicine==null) {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	medicine.setName(medicine_DTO.getName());
	medicine.setType(medicine_DTO.getType());
	
	Doctor docter=docter_Service.getBYID(medicine_DTO.getDocterid());
	medicine.setDoctorid(docter);
	
	Medicine savemedicine=medicine_Service.save(medicine);
	return new ResponseEntity<>(savemedicine,HttpStatus.CREATED);
	
}
	
	@DeleteMapping("/{id}")
	private ResponseEntity<Medicine> DeleteMedicineById(@PathVariable("id") int id){
		Medicine medicine = medicine_Service.GetMedicineById(id);
		if(medicine==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}medicine_Service.deleteById(id);
		return new ResponseEntity<>(HttpStatus.MOVED_PERMANENTLY);
	}
}
