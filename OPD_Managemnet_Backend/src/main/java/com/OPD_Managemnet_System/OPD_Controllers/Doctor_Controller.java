package com.OPD_Managemnet_System.OPD_Controllers;

import java.time.LocalDateTime;
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
import com.OPD_Managemnet_System.OPDEntitys.Role;
import com.OPD_Managemnet_System.OPDServices.Doctor_Service;
import com.OPD_Managemnet_System.OPD_DTOs.Doctor_DTO;
import com.OPD_Managemnet_System.Security.passwordEncoderConfig;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/doctor") // Base URL for Doctor APIs
public class Doctor_Controller {

	// ---------------------- AUTOWIRED SERVICES ----------------------

	@Autowired
	private Doctor_Service Doctor_Service; // Handles doctor business logic

	@Autowired
	private PasswordEncoder encoderConfig; // Used for password encryption

	// ---------------------- REGISTER DOCTOR ----------------------

	@PostMapping("/register")
	public ResponseEntity<Doctor> saveDoctor(@Valid @RequestBody Doctor_DTO doctorDTO) {

		// Log API hit for debugging
		System.out.println(">>> SAVE DOCTOR API HIT <<<");

		// Create Doctor entity object
		Doctor doctor = new Doctor();

		// Map DTO data to Entity
		doctor.setName(doctorDTO.getName());
		doctor.setMobileno(doctorDTO.getMobileno());
		doctor.setAddress(doctorDTO.getAddress());
		doctor.setEmail(doctorDTO.getEmail());

		// Encrypt password before saving
		doctor.setPassword(encoderConfig.encode(doctorDTO.getPassword()));

		doctor.setClinic_name(doctorDTO.getClinic_name());
		doctor.setSpecialization(doctorDTO.getSpecialization());
		doctor.setToken(doctorDTO.getToken());
		doctor.setStatus(doctorDTO.getStatus());
		doctor.setQualification(doctorDTO.getQualification());

		// Set creation and update timestamps
		doctor.setCreated_at(LocalDateTime.now());
		doctor.setUpdated_at(LocalDateTime.now());

		// Assign DOCTOR role
		doctor.setRole(Role.DOCTOR);

		// Save doctor record
		Doctor savedDoctor = Doctor_Service.save(doctor);

		return new ResponseEntity<>(savedDoctor, HttpStatus.CREATED);
	}

	// ---------------------- GET ALL DOCTORS ----------------------

	@GetMapping("/")
	public ResponseEntity<List<Doctor>> GetAllDoctor() {

		List<Doctor> Doctor = Doctor_Service.ListofDoctors();

		// Return 404 if no doctors found
		if (Doctor == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(Doctor, HttpStatus.OK);
	}

	// ---------------------- GET DOCTOR BY ID ----------------------

	@GetMapping("/{id}")
	public ResponseEntity<Doctor> GetByDoctorID(@PathVariable("id") int id) {

		Doctor Doctor = Doctor_Service.getBYID(id);

		// Return 404 if doctor not found
		if (Doctor == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(Doctor, HttpStatus.OK);
	}

	// ---------------------- UPDATE DOCTOR ----------------------

	@PutMapping("/{id}")
	public ResponseEntity<Doctor> UpdateDoctorRecord(@PathVariable("id") int id,
			@Valid @RequestBody Doctor_DTO Doctor_DTO) {

		Doctor Doctor = Doctor_Service.getBYID(id);

		// Check if doctor exists before update
		if (Doctor == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		// Update doctor details
		Doctor.setName(Doctor_DTO.getName());
		Doctor.setMobileno(Doctor_DTO.getMobileno());
		Doctor.setAddress(Doctor_DTO.getAddress());

		// Encrypt updated password
		Doctor.setPassword(encoderConfig.encode(Doctor_DTO.getPassword()));

		Doctor.setEmail(Doctor_DTO.getEmail());
		Doctor.setClinic_name(Doctor_DTO.getClinic_name());
		Doctor.setSpecialization(Doctor_DTO.getSpecialization());
		Doctor.setToken(Doctor_DTO.getToken());
		Doctor.setStatus(Doctor_DTO.getStatus());
		Doctor.setUpdated_at(Doctor_DTO.getUpdated_at());
		Doctor.setQualification(Doctor_DTO.getQualification());

		// Save updated doctor record
		Doctor saveDoctor = Doctor_Service.save(Doctor);

		return new ResponseEntity<>(saveDoctor, HttpStatus.FOUND);
	}

	// ---------------------- DELETE DOCTOR ----------------------

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> DeleteDoctor(@PathVariable("id") int id) {

		Doctor Doctor = Doctor_Service.getBYID(id);

		// Check if doctor exists before deletion
		if (Doctor == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}

		// Delete doctor record
		Doctor_Service.delete(id);

		return new ResponseEntity<>(HttpStatus.MOVED_PERMANENTLY);
	}
}
