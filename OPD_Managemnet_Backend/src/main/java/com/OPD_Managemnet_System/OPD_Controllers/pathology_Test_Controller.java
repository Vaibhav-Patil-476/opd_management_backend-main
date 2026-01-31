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

import com.OPD_Managemnet_System.OPDEntitys.Pathology_Test;
import com.OPD_Managemnet_System.OPDEntitys.Test_Master;
import com.OPD_Managemnet_System.OPDEntitys.Visit;
import com.OPD_Managemnet_System.OPDServices.Pathology_Test_Service;
import com.OPD_Managemnet_System.OPDServices.Test_Master_Service;
import com.OPD_Managemnet_System.OPDServices.Visit_Service;
import com.OPD_Managemnet_System.OPD_DTOs.Pathology_Test_DTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Pathology")
public class pathology_Test_Controller {

	@Autowired
	private Visit_Service visit_Service;
	
	@Autowired
	private Test_Master_Service test_Master_Service;
	
	@Autowired
	private Pathology_Test_Service pathology_Test_Service;
	
	@PostMapping("/")
	public ResponseEntity<Pathology_Test> SavePathologyTest(@Valid@RequestBody Pathology_Test_DTO pathology_Test_DTO ){
		Pathology_Test pathologyTest= new Pathology_Test();
		
		pathologyTest.setCreate_at(pathology_Test_DTO.getCreate_at());
		pathologyTest.setRemark(pathology_Test_DTO.getRemark());
		pathologyTest.setReport_file(pathology_Test_DTO.getReport_file());
		pathologyTest.setResult(pathology_Test_DTO.getResult());
		
		Visit visit=visit_Service.getBYID(pathology_Test_DTO.getVisitid());
		pathologyTest.setVisitid(visit);
		
		Test_Master testmaster=test_Master_Service.getBYTest_MasterID(pathology_Test_DTO.getTestid());
		pathologyTest.setTestid(testmaster);
		
		Pathology_Test SavePathologyTest=pathology_Test_Service.save(pathologyTest);
		return new ResponseEntity<>(SavePathologyTest,HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Pathology_Test>> GetAllPathologyTest(){
	   List<Pathology_Test> pathologyTest=pathology_Test_Service.getAllPathology_Tests();
		if(pathologyTest==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}return new ResponseEntity<>(pathologyTest,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Pathology_Test> GetPathologyTestById(@PathVariable("id")int id ){
		Pathology_Test pathologyTest=pathology_Test_Service.getPathology_TestById(id);
		if(pathologyTest==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}return new ResponseEntity<>(pathologyTest,HttpStatus.OK);
}
	
	@PutMapping("/{id}")
	public ResponseEntity<Pathology_Test> UpdatePathologyTestById(@PathVariable("id")int id,@Valid@RequestBody Pathology_Test_DTO pathology_Test_DTO ){
		Pathology_Test pathologyTest=pathology_Test_Service.getPathology_TestById(id);
		if(pathologyTest==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		pathologyTest.setCreate_at(pathology_Test_DTO.getCreate_at());
		pathologyTest.setRemark(pathology_Test_DTO.getRemark());
		pathologyTest.setReport_file(pathology_Test_DTO.getReport_file());
		pathologyTest.setResult(pathology_Test_DTO.getResult());
		
		Visit visit=visit_Service.getBYID(pathology_Test_DTO.getVisitid());
		pathologyTest.setVisitid(visit);
		
		Test_Master testmaster=test_Master_Service.getBYTest_MasterID(pathology_Test_DTO.getTestid());
		pathologyTest.setTestid(testmaster);
		
		Pathology_Test SavePathologyTest=pathology_Test_Service.save(pathologyTest);
		return new ResponseEntity<>(SavePathologyTest,HttpStatus.CREATED);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Pathology_Test> DaletePathologyTestById(@PathVariable("id")int id){
		Pathology_Test pathologyTest=pathology_Test_Service.getPathology_TestById(id);
		if(pathologyTest==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}pathology_Test_Service.DeletePathology_TestById(id);
		return new ResponseEntity<>(pathologyTest,HttpStatus.MOVED_PERMANENTLY);
	}
}
