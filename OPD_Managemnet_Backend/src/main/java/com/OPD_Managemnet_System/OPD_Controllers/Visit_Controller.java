package com.OPD_Managemnet_System.OPD_Controllers;

import java.time.LocalDate;
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
import com.OPD_Managemnet_System.OPDRepo.Visit_repo;
import com.OPD_Managemnet_System.OPDServices.Doctor_Service;
import com.OPD_Managemnet_System.OPDServices.Patient_Service;
import com.OPD_Managemnet_System.OPDServices.Visit_Service;
import com.OPD_Managemnet_System.OPD_DTOs.Visit_DTO;

import jakarta.validation.Valid;

@RequestMapping("/visit") // Base URL for Visit related APIs
@RestController
public class Visit_Controller {

	// ---------------------- AUTOWIRED SERVICES ----------------------

	@Autowired
	private Visit_Service visit_Service;
	// Handles Visit business logic

	@Autowired
	private Doctor_Service docter_Service;
	// Used to fetch doctor details

	@Autowired
	private Patient_Service patient_Service;
	
	@Autowired
	private Visit_repo visit_repo;
	// Used to fetch patient details

	// ---------------------- SAVE PATIENT VISIT ----------------------

	// API to create and save patient visit details
	@PostMapping("/")
	public ResponseEntity<Visit> SavePetientVisit(@Valid @RequestBody Visit_DTO visit_DTO) {

		// Create Visit entity object
		Visit visit = new Visit();

		// Map DTO values to Visit entity
		visit.setAddition_notes(visit_DTO.getAddition_notes());
		visit.setAdvice(visit_DTO.getAdvice());
		visit.setBp(visit_DTO.getBp());
		visit.setCns(visit_DTO.getCns());
		visit.setComplaints(visit_DTO.getComplaints());
		visit.setCreate_at(visit_DTO.getCreate_at());
		visit.setCurrent_medication(visit_DTO.getCurrent_medication());
		visit.setCvs(visit_DTO.getCvs());
		visit.setVisitDate(LocalDate.now());
		visit.setDiagnosis(visit_DTO.getDiagnosis());
		visit.setEcg(visit_DTO.getEcg());
		visit.setWeight(visit_DTO.getWeight());
		visit.setEdema(visit_DTO.getEdema());
		visit.setFasting_sugar(visit_DTO.getFasting_sugar());
		visit.setFollowup_date(visit_DTO.getFollowup_date());
		visit.setHb(visit_DTO.getHb());
		visit.setJaundice(visit_DTO.getJaundice());
		visit.setPa(visit_DTO.getPa());
		visit.setPallor(visit_DTO.getPallor());
		visit.setPast_history(visit_DTO.getPast_history());
		visit.setPp_sugar(visit_DTO.getPp_sugar());
		visit.setPulse(visit_DTO.getPulse());
		visit.setRandom_sugar(visit_DTO.getRandom_sugar());
		visit.setRespiration_rate(visit_DTO.getRespiration_rate());
		visit.setRespiration_rate(visit_DTO.getRespiration_rate());
		visit.setRs(visit_DTO.getRs());
		visit.setSaturation(visit_DTO.getSaturation());
		visit.setSugar(visit_DTO.getSugar());
		visit.setTemperature(visit_DTO.getTemperature());
		visit.setUpdate_at(visit_DTO.getUpdate_at());
		visit.setUrea_creatinine(visit_DTO.getUrea_creatinine());

		// Fetch and set doctor reference
		Doctor docter = docter_Service.getBYID(visit_DTO.getDocterid());
		visit.setDoctorid(docter);

		// Fetch and set patient reference
		Patient patient = patient_Service.getBYID(visit_DTO.getPatientid());
		visit.setPatientid(patient);

		// Save visit record
		Visit SavePatientVisit = visit_Service.save(visit);

		return new ResponseEntity<>(SavePatientVisit, HttpStatus.CREATED);
	}

	// ---------------------- GET ALL VISITS ----------------------

	// API to fetch all patient visit records
	@GetMapping("/")
	public ResponseEntity<List<Visit>> GetAllVisit() {

		List<Visit> visit = visit_Service.getAll();

		// Return 404 if no visit records found
		if (visit == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(visit, HttpStatus.OK);
	}

	// ---------------------- GET VISIT BY ID ----------------------

	// API to fetch visit record by ID
	@GetMapping("/{id}")
	public ResponseEntity<Visit> GetVisitById(@PathVariable("id") int id) {

		Visit visit = visit_Service.getBYID(id);

		// Return 404 if visit not found
		if (visit == null) {
			return new ResponseEntity<>(visit, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(visit, HttpStatus.OK);
	}

	// ---------------------- UPDATE VISIT ----------------------

	// API to update patient visit details by ID
	@PutMapping("/{id}")
	public ResponseEntity<Visit> UpdateVisitById(@PathVariable("id") int id, @Valid @RequestBody Visit_DTO visit_DTO) {

		Visit visit = visit_Service.getBYID(id);

		// Check if visit exists before update
		if (visit == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		// Update visit details
		visit.setAddition_notes(visit_DTO.getAddition_notes());
		visit.setAdvice(visit_DTO.getAdvice());
		visit.setBp(visit_DTO.getBp());
		visit.setCns(visit_DTO.getCns());
		visit.setComplaints(visit_DTO.getComplaints());
		visit.setCreate_at(visit_DTO.getCreate_at());
		visit.setCurrent_medication(visit_DTO.getCurrent_medication());
		visit.setCvs(visit_DTO.getCvs());
		visit.setVisitDate(LocalDate.now());
		visit.setDiagnosis(visit_DTO.getDiagnosis());
		visit.setEcg(visit_DTO.getEcg());
		visit.setWeight(visit_DTO.getWeight());
		visit.setEdema(visit_DTO.getEdema());
		visit.setFasting_sugar(visit_DTO.getFasting_sugar());
		visit.setFollowup_date(visit_DTO.getFollowup_date());
		visit.setHb(visit_DTO.getHb());
		visit.setJaundice(visit_DTO.getJaundice());
		visit.setPa(visit_DTO.getPa());
		visit.setPallor(visit_DTO.getPallor());
		visit.setPast_history(visit_DTO.getPast_history());
		visit.setPp_sugar(visit_DTO.getPp_sugar());
		visit.setPulse(visit_DTO.getPulse());
		visit.setRandom_sugar(visit_DTO.getRandom_sugar());
		visit.setRespiration_rate(visit_DTO.getRespiration_rate());
		visit.setRespiration_rate(visit_DTO.getRespiration_rate());
		visit.setRs(visit_DTO.getRs());
		visit.setSaturation(visit_DTO.getSaturation());
		visit.setSugar(visit_DTO.getSugar());
		visit.setTemperature(visit_DTO.getTemperature());
		visit.setUpdate_at(visit_DTO.getUpdate_at());
		visit.setUrea_creatinine(visit_DTO.getUrea_creatinine());
		// Update doctor reference
		Doctor docter = docter_Service.getBYID(visit_DTO.getDocterid());
		visit.setDoctorid(docter);

		// Update patient reference
		Patient patient = patient_Service.getBYID(visit_DTO.getPatientid());
		visit.setPatientid(patient);

		// Save updated visit record
		Visit SavePatientVisit = visit_Service.save(visit);

		return new ResponseEntity<>(SavePatientVisit, HttpStatus.CREATED);
	}

	// ---------------------- DELETE VISIT ----------------------

	// API to delete visit record by ID
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> DeleteVisitById(@PathVariable("id") int id) {

		Visit visit = visit_Service.getBYID(id);

		// Check if visit exists before deletion
		if (visit == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		// Delete visit record
		visit_Service.deleteBYID(id);

		return new ResponseEntity<>(HttpStatus.MOVED_PERMANENTLY);
	}
	
	// ---------------------- Get Visit Date  ----------------------
	
	@GetMapping("/todaysVisite")
	public ResponseEntity<List<Visit>> GetVisitDateByVisitid(){
		
		
		
		List<Visit> visit = visit_Service.findByVisitDate(LocalDate.now());
		
		if(visit==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(visit,HttpStatus.OK);
	}
}
