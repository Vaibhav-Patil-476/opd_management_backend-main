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

import com.OPD_Managemnet_System.OPDEntitys.Bill;
import com.OPD_Managemnet_System.OPDEntitys.Visit;
import com.OPD_Managemnet_System.OPDServices.Bill_Service;
import com.OPD_Managemnet_System.OPDServices.Visit_Service;
import com.OPD_Managemnet_System.OPD_DTOs.Bill_DTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Bill")
public class Bill_Controller {
	
	@Autowired
	private Bill_Service bill_Service;
	
	@Autowired
	private Visit_Service visit_Service;
	
	@PostMapping("/")
	public ResponseEntity<Bill> SaveBill(@Valid@RequestBody Bill_DTO bill_DTO){
		Bill bill = new Bill();
		
		bill.setConcession(bill_DTO.getConcession());
		bill.setConsultation_fee(bill_DTO.getConsultation_fee());
		bill.setCreated_at(bill_DTO.getCreated_at());
		bill.setPaid_amount(bill_DTO.getPaid_amount());
		bill.setPayment_status(bill_DTO.getPayment_status());
		bill.setPaymet_method(bill_DTO.getPaymet_method());
		bill.setPending_amount(bill_DTO.getPending_amount());
		bill.setTotal_amount(bill_DTO.getTotal_amount());
		
		Visit visit=visit_Service.getBYID(bill_DTO.getVisitid());
		
		Bill Savebill=bill_Service.save(bill);
		
		return new ResponseEntity<>(Savebill,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Bill>> GetAllBill(){
		List<Bill> bill=bill_Service.GetallBill();
		if(bill==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}return new ResponseEntity<>(bill,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Bill> GetAllBillById(@PathVariable("id")int id) {
		Bill bill=bill_Service.GetBillById(id);
		if(bill==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}return new ResponseEntity<>(bill,HttpStatus.OK);
		
}
	@PutMapping("{id}")
	public ResponseEntity<Bill> UpdateAllBillById(@PathVariable("id")int id,@Valid @RequestBody Bill_DTO bill_DTO){
		Bill bill=bill_Service.GetBillById(id);
		if(bill==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	bill.setConcession(bill_DTO.getConcession());
	bill.setConsultation_fee(bill_DTO.getConsultation_fee());
	bill.setCreated_at(bill_DTO.getCreated_at());
	bill.setPaid_amount(bill_DTO.getPaid_amount());
	bill.setPayment_status(bill_DTO.getPayment_status());
	bill.setPaymet_method(bill_DTO.getPaymet_method());
	bill.setPending_amount(bill_DTO.getPending_amount());
	bill.setTotal_amount(bill_DTO.getTotal_amount());
	
	Visit visit=visit_Service.getBYID(bill_DTO.getVisitid());
	
	Bill Savebill=bill_Service.save(bill);
	
	return new ResponseEntity<>(Savebill,HttpStatus.CREATED);
	
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Bill> UpdateAllBillById(@PathVariable("id")int id){
		Bill bill=bill_Service.GetBillById(id);
		if(bill==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}bill_Service.deleteBillById(id);
	return new ResponseEntity<>(HttpStatus.MOVED_PERMANENTLY);
	}
}
