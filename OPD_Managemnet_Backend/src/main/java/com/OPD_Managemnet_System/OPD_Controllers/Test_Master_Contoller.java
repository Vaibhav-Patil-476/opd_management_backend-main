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

@RequestMapping("/Test_Master")
@RestController
public class Test_Master_Contoller {

	@Autowired
	private Doctor_Service docter_Service;
	
	@Autowired
	private Test_Master_Service master_Service;
	
	@PostMapping("/")
	public ResponseEntity<Test_Master> SaveTest_Master(@Valid @RequestBody Test_Master_DTO test_master_DTO){
		
		Test_Master test_master = new Test_Master();
		
		test_master.setTest_name(test_master_DTO.getTest_name());
		test_master.setNormal_range(test_master_DTO.getNormal_range());
		test_master.setUnit(test_master_DTO.getUnit());
		
		Doctor docter=docter_Service.getBYID(test_master_DTO.getDocterid());
		test_master.setDoctorid(docter);
		
		Test_Master saveTest_Master=master_Service.save(test_master);
		return new ResponseEntity<>(saveTest_Master,HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Test_Master>> GetAllTest_Master(){
		
		List<Test_Master> test_Master=master_Service.ListofTest_Master();
		if(test_Master==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}return new ResponseEntity<>(test_Master,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Test_Master> GetByTest_MasterID(@PathVariable("id") int id){
		Test_Master	test_Master=master_Service.getBYTest_MasterID(id);
		if(test_Master==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}return new ResponseEntity<>(test_Master,HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Test_Master> UpdateDocterRecord(@PathVariable("id") int id,@Valid @RequestBody Test_Master_DTO test_master_DTO){
		
		Test_Master test_master =master_Service.getBYTest_MasterID(id);
		if(test_master==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		test_master.setTest_name(test_master_DTO.getTest_name());
		test_master.setNormal_range(test_master_DTO.getNormal_range());
		test_master.setUnit(test_master_DTO.getUnit());
		
		Doctor docter=docter_Service.getBYID(test_master_DTO.getDocterid());
		test_master.setDoctorid(docter);
		
		Test_Master saveTest_Master=master_Service.save(test_master);
		return new ResponseEntity<>(saveTest_Master,HttpStatus.CREATED);
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> DeleteTest_Master(@PathVariable("id") int id){
		
		Test_Master test_master=master_Service.getBYTest_MasterID(id);
		if(test_master==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}docter_Service.delete(id);
		return new ResponseEntity<>(HttpStatus.MOVED_PERMANENTLY);
	}
}
