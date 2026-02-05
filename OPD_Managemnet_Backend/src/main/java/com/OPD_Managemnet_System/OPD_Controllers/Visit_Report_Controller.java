package com.OPD_Managemnet_System.OPD_Controllers;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.http.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.OPD_Managemnet_System.OPDEntitys.Visit;
import com.OPD_Managemnet_System.OPDEntitys.Visit_Report;
import com.OPD_Managemnet_System.OPDServices.Visit_Report_Service;
import com.OPD_Managemnet_System.OPDServices.Visit_Service;
import com.OPD_Managemnet_System.OPD_DTOs.Visit_Report_DTO;
import com.OPD_Managemnet_System.Security.FileStorageUtil;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Visit_Report")
public class Visit_Report_Controller {

	// ---------------------- AUTOWIRED SERVICES ----------------------

	@Autowired
	private Visit_Report_Service visit_Report_Service;

	@Autowired
	private Visit_Service visit_Service;
	@Autowired
	private FileStorageUtil fileStorageUtil;

	@PostMapping(value = "/", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Visit_Report> saveVisitReport(@Valid @ModelAttribute Visit_Report_DTO visitReportDTO,
			@RequestPart("file_url") MultipartFile file) {
		// 1️⃣ Validate file
		if (file == null || file.isEmpty()) {
			return ResponseEntity.badRequest().body(null);
		}

		// 2️⃣ Save file
		String fileUrl = fileStorageUtil.saveFile(file);
		String fileName = file.getOriginalFilename();
		String fileType = file.getContentType();

		// 3️⃣ Build entity
		Visit_Report visitReport = new Visit_Report();
		visitReport.setVisitid(visit_Service.getBYID(visitReportDTO.getVisitid()));
		visitReport.setFile_url(fileUrl);
		visitReport.setFile_name(fileName);
		visitReport.setFile_type(fileType);
		visitReport.setCreated_at(LocalDateTime.now());

		// 4️⃣ Save
		Visit_Report saved = visit_Report_Service.save(visitReport);

		return new ResponseEntity<>(saved, HttpStatus.CREATED);
	}

	// ---------------------- GET ALL MEDICINES ----------------------

	@GetMapping("/")
	public ResponseEntity<List<Visit_Report>> GetAllReport() {
		List<Visit_Report> visit_Report = visit_Report_Service.GetAllVisit_Report();
		if (visit_Report == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(visit_Report, HttpStatus.OK);
	}



//	// ---------------------- GET MEDICINE BY ID ----------------------
//
	@GetMapping("/{id}")
	public ResponseEntity<Visit_Report> GetAllVisitReportById(@PathVariable("id") int id) {
		Visit_Report visit_Report = visit_Report_Service.GetAllVisit_ReportByid(id);

		// Return 404 if medicine not found
		if (visit_Report == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(visit_Report, HttpStatus.OK);
	}

	// ---------------------- UPDATE MEDICINE ----------------------

	@PutMapping(value = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Visit_Report> updateVisitReport(@PathVariable("id") int id,@ModelAttribute Visit_Report_DTO visitReportDTO,
			@RequestPart(value = "file_url", required = false) MultipartFile file) {

		Visit_Report visitReport = visit_Report_Service.GetAllVisit_ReportByid(id);

		if (visitReport == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		// update file only if provided
		if (file != null && !file.isEmpty()) {
			String fileUrl = fileStorageUtil.saveFile(file);
			visitReport.setFile_url(fileUrl);
			visitReport.setFile_name(file.getOriginalFilename());
			visitReport.setFile_type(file.getContentType());
		}

		visitReport.setVisitid(visit_Service.getBYID(visitReportDTO.getVisitid()));

		Visit_Report saved = visit_Report_Service.save(visitReport);
		return new ResponseEntity<>(saved, HttpStatus.OK);
	}

	// ---------------------- DELETE MEDICINE ----------------------

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> DeleteVisitReportById(@PathVariable("id") int id) {
		Visit_Report visit_Report = visit_Report_Service.GetAllVisit_ReportByid(id);
		if (visit_Report == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		visit_Report_Service.deleteById(id);
		return new ResponseEntity<>(HttpStatus.MOVED_PERMANENTLY);
	}
}
