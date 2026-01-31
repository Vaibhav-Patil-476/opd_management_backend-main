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
import com.OPD_Managemnet_System.OPDEntitys.Visit;
import com.OPD_Managemnet_System.OPDServices.Doctor_Service;
import com.OPD_Managemnet_System.OPDServices.Patient_Service;
import com.OPD_Managemnet_System.OPDServices.Visit_Service;
import com.OPD_Managemnet_System.OPD_DTOs.Visit_DTO;

import jakarta.validation.Valid;

@RequestMapping("OPD/Visit")
@RestController
public class Visit_Controller {

	@Autowired
	private Visit_Service visit_Service;
	
	@Autowired
	private Doctor_Service docter_Service;
	
	@Autowired
	private Patient_Service patient_Service;
	
	@PostMapping("/")
	public ResponseEntity<Visit> SavePetientVisit(@Valid @RequestBody Visit_DTO visit_DTO){
		Visit visit = new Visit();
		
		visit.setAddition_notes(visit_DTO.getAddition_notes());
		visit.setAdvice(visit_DTO.getAdvice());
		visit.setBp(visit_DTO.getBp());
		visit.setCns(visit_DTO.getCns());
		visit.setComplaints(visit_DTO.getComplaints());
		visit.setCreate_at(visit_DTO.getCreate_at());
		visit.setCurrent_medication(visit_DTO.getCurrent_medication());
		visit.setCvs(visit.getCvs());
		visit.setDate(visit_DTO.getDate());
		visit.setDiagnosis(visit_DTO.getDiagnosis());
		visit.setEcg(visit_DTO.getEcg());
		visit.setWeight(visit_DTO.getWeight());
		visit.setEdema(visit_DTO.getEdema());
		visit.setFasting_sugar(visit_DTO.getFasting_sugar());
		visit.setFollowup_date(visit_DTO.getFollowup_date());
		visit.setHb(visit.getHb());
		visit.setJaundice(visit.getJaundice());
		visit.setPa(visit.getPa());
		visit.setPallor(visit.getPallor());
		visit.setPast_history(visit.getPast_history());
		visit.setPp_sugar(visit.getPp_sugar());
		visit.setPulse(visit_DTO.getPulse());
		visit.setRandom_sugar(visit_DTO.getRandom_sugar());
		visit.setRespiration_rate(visit.getRespiration_rate());
		visit.setRespiration_rate(visit.getRespiration_rate());
		visit.setRs(visit_DTO.getRs());
		visit.setSaturation(visit_DTO.getSaturation());
		visit.setSugar(visit.getSugar());
		visit.setTemperature(visit_DTO.getTemperature());
		visit.setUpdate_at(visit_DTO.getUpdate_at());
		visit.setUrea_creatinine(visit_DTO.getUrea_creatinine());
		
		Doctor docter= docter_Service.getBYID(visit_DTO.getDocterid());
		visit.setDoctorid(docter);
		
		Patient patient = patient_Service.getBYID(visit_DTO.getPatientid());
		visit.setPatientid(patient);
		
		Visit SavePatientVisit=visit_Service.save(visit);
		
		return new ResponseEntity<>(SavePatientVisit,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Visit>> GetAllVisit(){
		
		List<Visit> visit = visit_Service.getAll();
		if(visit==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}return new ResponseEntity<>(visit,HttpStatus.OK);
		
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Visit> GetVisitById(@PathVariable("id") int id ){
		
		Visit visit = visit_Service.getBYID(id);
		if(visit==null) {
			return new ResponseEntity<>(visit,HttpStatus.NOT_FOUND);
		}return new ResponseEntity<>(visit,HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Visit> UpdateVisitById(@PathVariable("id") int id,@Valid @RequestBody Visit_DTO visit_DTO){
		
		Visit visit= visit_Service.getBYID(id);
		if(visit==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		visit.setAddition_notes(visit_DTO.getAddition_notes());
		visit.setAdvice(visit_DTO.getAdvice());
		visit.setBp(visit_DTO.getBp());
		visit.setCns(visit_DTO.getCns());
		visit.setComplaints(visit_DTO.getComplaints());
		visit.setCreate_at(visit_DTO.getCreate_at());
		visit.setCurrent_medication(visit_DTO.getCurrent_medication());
		visit.setCvs(visit.getCvs());
		visit.setDate(visit_DTO.getDate());
		visit.setDiagnosis(visit_DTO.getDiagnosis());
		visit.setEcg(visit_DTO.getEcg());
		visit.setWeight(visit_DTO.getWeight());
		visit.setEdema(visit_DTO.getEdema());
		visit.setFasting_sugar(visit_DTO.getFasting_sugar());
		visit.setFollowup_date(visit_DTO.getFollowup_date());
		visit.setHb(visit.getHb());
		visit.setJaundice(visit.getJaundice());
		visit.setPa(visit.getPa());
		visit.setPallor(visit.getPallor());
		visit.setPast_history(visit.getPast_history());
		visit.setPp_sugar(visit.getPp_sugar());
		visit.setPulse(visit_DTO.getPulse());
		visit.setRandom_sugar(visit_DTO.getRandom_sugar());
		visit.setRespiration_rate(visit.getRespiration_rate());
		visit.setRespiration_rate(visit.getRespiration_rate());
		visit.setRs(visit_DTO.getRs());
		visit.setSaturation(visit_DTO.getSaturation());
		visit.setSugar(visit.getSugar());
		visit.setTemperature(visit_DTO.getTemperature());
		visit.setUpdate_at(visit_DTO.getUpdate_at());
		visit.setUrea_creatinine(visit_DTO.getUrea_creatinine());
		
		Doctor docter= docter_Service.getBYID(visit_DTO.getDocterid());
		visit.setDoctorid(docter);
		
		Patient patient = patient_Service.getBYID(visit_DTO.getPatientid());
		visit.setPatientid(patient);
		
		Visit SavePatientVisit=visit_Service.save(visit);
		
		return new ResponseEntity<>(SavePatientVisit,HttpStatus.CREATED);
		
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> DeleteVisitById(@PathVariable("id") int id){
		Visit visit=visit_Service.getBYID(id);
		if(visit==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}visit_Service.deleteBYID(id);
		return new ResponseEntity<>(HttpStatus.MOVED_PERMANENTLY);
	}
}
