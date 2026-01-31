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

import com.OPD_Managemnet_System.OPDEntitys.Visit;
import com.OPD_Managemnet_System.OPDEntitys.Visit_Report;
import com.OPD_Managemnet_System.OPDServices.Visit_Report_Service;
import com.OPD_Managemnet_System.OPDServices.Visit_Service;
import com.OPD_Managemnet_System.OPD_DTOs.Visit_Report_DTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Visit_Report")
public class Visit_Report_Controller {

	@Autowired
	private Visit_Report_Service visit_Report_Service;
	
	@Autowired
	private Visit_Service visit_Service;
	
	@PostMapping("/")
	public ResponseEntity<Visit_Report> SaveVisitReport(@Valid @RequestBody Visit_Report_DTO visit_Report_DTO){
		Visit_Report visit_Report= new Visit_Report();
		
		visit_Report.setCreated_at(visit_Report_DTO.getCreated_at());
		visit_Report.setFile_name(visit_Report_DTO.getFile_name());
		visit_Report.setFile_type(visit_Report_DTO.getFile_type());
		visit_Report.setFile_url(visit_Report_DTO.getFile_url());
		
		Visit visit=visit_Service.getBYID(visit_Report_DTO.getVisitid());
		visit_Report.setVisitid(visit);
		
		Visit_Report SaveVisit_Report=visit_Report_Service.save(visit_Report);
		
		return new ResponseEntity<>(SaveVisit_Report,HttpStatus.CREATED);
		
	}

	@GetMapping("/")
	public ResponseEntity<List<Visit_Report>> GetAllReport(){
		List<Visit_Report> visit_Report = visit_Report_Service.GetAllVisit_Report();
		if(visit_Report==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}return new ResponseEntity<>(visit_Report,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Visit_Report> GetAllVisitReportById(@PathVariable("id") int id){
		Visit_Report visit_Report=visit_Report_Service.GetAllVisit_ReportByid(id);
		if(visit_Report==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}		
		return new ResponseEntity<>(visit_Report,HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Visit_Report> UpdateAllVisitReportById(@PathVariable("id") int id,@Valid @RequestBody Visit_Report_DTO visit_Report_DTO){
		Visit_Report visit_Report=visit_Report_Service.GetAllVisit_ReportByid(id);
		if(visit_Report==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}visit_Report.setCreated_at(visit_Report_DTO.getCreated_at());
		visit_Report.setFile_name(visit_Report_DTO.getFile_name());
		visit_Report.setFile_type(visit_Report_DTO.getFile_type());
		visit_Report.setFile_url(visit_Report_DTO.getFile_url());
		
		Visit visit=visit_Service.getBYID(visit_Report_DTO.getVisitid());
		visit_Report.setVisitid(visit);
		
		Visit_Report SaveVisit_Report=visit_Report_Service.save(visit_Report);
		
		return new ResponseEntity<>(SaveVisit_Report,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> DeleteVisitReportById(@PathVariable("id") int id){
		Visit_Report visit_Report=visit_Report_Service.GetAllVisit_ReportByid(id);
		if(visit_Report==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}visit_Report_Service.deleteById(id);
		return new ResponseEntity<>(HttpStatus.MOVED_PERMANENTLY);
	}
}

