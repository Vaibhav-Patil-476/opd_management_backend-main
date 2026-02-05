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

import com.OPD_Managemnet_System.OPDEntitys.Medicine;
import com.OPD_Managemnet_System.OPDEntitys.Prescription;
import com.OPD_Managemnet_System.OPDEntitys.Visit;
import com.OPD_Managemnet_System.OPDServices.Medicine_Service;
import com.OPD_Managemnet_System.OPDServices.PrescriptionService;
import com.OPD_Managemnet_System.OPDServices.Visit_Service;
import com.OPD_Managemnet_System.OPD_DTOs.PrescriptionDTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/prescription")
public class PrescriptionContoller {

	@Autowired
	private PrescriptionService prescriptionService;

	@Autowired
	private Visit_Service visit_Service;

	@Autowired
	private Medicine_Service medicine_Service;

	// ---------------------- Save Prescription Record ----------------------
	@PostMapping("/")
	public ResponseEntity<Prescription> savePriscription(@Valid @RequestBody PrescriptionDTO prescriptionDTO) {

		Prescription prescription = new Prescription();

		// Map DTO values to Prescription entity
		prescription.setAfternoon_dose(prescriptionDTO.getAfternoon_dose());
		prescription.setCreated_at(prescriptionDTO.getCreated_at());
		prescription.setDosage(prescriptionDTO.getDosage());
		prescription.setDose_qty(prescriptionDTO.getDose_qty());
		prescription.setDose_unit(prescriptionDTO.getDose_unit());
		prescription.setDuration_day(prescriptionDTO.getDuration_day());
		prescription.setEvening_dose(prescriptionDTO.getEvening_dose());
		prescription.setInstructions(prescriptionDTO.getInstructions());
		prescription.setMorning_dose(prescriptionDTO.getMorning_dose());
		prescription.setQuantity(prescriptionDTO.getQuantity());
		prescription.setTotal_quantity(prescriptionDTO.getTotal_quantity());

		// Fetch visit using visitid
		Visit visit = visit_Service.getBYID(prescriptionDTO.getVisitid());

		// Fetch medicine Record by mediciId
		Medicine medicine = medicine_Service.GetMedicineById(prescriptionDTO.getMedicineid());

		// Save Prescription Record
		Prescription saveprescription = prescriptionService.savePrescription(prescription);

		return new ResponseEntity<>(saveprescription, HttpStatus.CREATED);
	}

	
	// ---------------------- Get ALl Prescription Record ----------------------
	
	@GetMapping("/")
	public ResponseEntity<List<Prescription>> getallPriscription() {
		List<Prescription> prescription = prescriptionService.getAllPrescription();

		if (prescription == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.OK);

	}

	// ---------------------- Get Prescription Record By Id ----------------------
	
	@GetMapping("/{id}")
	public ResponseEntity<Prescription> getPrescripionByid(@Valid @PathVariable("id") int id) {

		Prescription prescription = prescriptionService.getPrescriptionbyId(id);

		if (prescription == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(prescription, HttpStatus.OK);
	}

	// ---------------------- Update Prescription Record ----------------------
	
	@PutMapping("/{id}")
	public ResponseEntity<Prescription> updatePriscription(@Valid @PathVariable("id") int id,
			@RequestBody PrescriptionDTO prescriptionDTO) {

		Prescription prescription = prescriptionService.getPrescriptionbyId(id);

		if (prescription == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		prescription.setAfternoon_dose(prescriptionDTO.getAfternoon_dose());
		prescription.setCreated_at(prescriptionDTO.getCreated_at());
		prescription.setDosage(prescriptionDTO.getDosage());
		prescription.setDose_qty(prescriptionDTO.getDose_qty());
		prescription.setDose_unit(prescriptionDTO.getDose_unit());
		prescription.setDuration_day(prescriptionDTO.getDuration_day());
		prescription.setEvening_dose(prescriptionDTO.getEvening_dose());
		prescription.setInstructions(prescriptionDTO.getInstructions());
		prescription.setMorning_dose(prescriptionDTO.getMorning_dose());
		prescription.setQuantity(prescriptionDTO.getQuantity());
		prescription.setTotal_quantity(prescriptionDTO.getTotal_quantity());

		// Fetch visit using visitid
		Visit visit = visit_Service.getBYID(prescriptionDTO.getVisitid());

		// Fetch medicine Record by mediciId
		Medicine medicine = medicine_Service.GetMedicineById(prescriptionDTO.getMedicineid());

		// Save Prescription Record
		Prescription saveprescription = prescriptionService.savePrescription(prescription);

		return new ResponseEntity<>(saveprescription, HttpStatus.CREATED);
	}

	// ---------------------- Delete Prescription ----------------------
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePrescriptionById(@Valid @PathVariable("id") int id) {

		Prescription prescription = prescriptionService.getPrescriptionbyId(id);

		// Check if reception exists before deletion
		if (prescription == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		// Delete reception record
		prescriptionService.deletePrescriptionbyId(id);
		return new ResponseEntity<>(HttpStatus.MOVED_PERMANENTLY);

	}
}
