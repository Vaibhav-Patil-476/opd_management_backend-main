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
@RequestMapping("/api/doctor")
public class Doctor_Controller {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
	@Autowired
	private Doctor_Service Doctor_Service;
	@Autowired
	private PasswordEncoder encoderConfig;
	
	
	@PostMapping("/register")
	public ResponseEntity<Doctor> saveDoctor( @Valid @RequestBody Doctor_DTO doctorDTO) {

		 System.out.println(">>> SAVE DOCTOR API HIT <<<");
	    Doctor doctor = new Doctor();

	    doctor.setName(doctorDTO.getName());
	    doctor.setMobileno(doctorDTO.getMobileno());
	    doctor.setAddress(doctorDTO.getAddress());
	    doctor.setEmail(doctorDTO.getEmail());
	    doctor.setPassword(encoderConfig.encode(doctorDTO.getPassword()));
	    doctor.setClinic_name(doctorDTO.getClinic_name());
	    doctor.setSpecialization(doctorDTO.getSpecialization());
	    doctor.setToken(doctorDTO.getToken());
	    doctor.setStatus(doctorDTO.getStatus());
	    doctor.setQualification(doctorDTO.getQualification());

	    // ✅ SET DATES HERE
	    doctor.setCreated_at(LocalDateTime.now());
	    doctor.setUpdated_at(LocalDateTime.now());

	    doctor.setRole(Role.DOCTOR);

	    Doctor savedDoctor = Doctor_Service.save(doctor);

	    return new ResponseEntity<>(savedDoctor, HttpStatus.CREATED);
	}

	
	
	@GetMapping("/")
	public ResponseEntity<List<Doctor>> GetAllDoctor(){
		
		List<Doctor> Doctor=Doctor_Service.ListofDoctors();
		if(Doctor==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}return new ResponseEntity<>(Doctor,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Doctor> GetByDoctorID(@PathVariable("id") int id){
		Doctor Doctor=Doctor_Service.getBYID(id);
		if(Doctor==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}return new ResponseEntity<>(Doctor,HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Doctor> UpdateDoctorRecord(@PathVariable("id") int id,@Valid @RequestBody Doctor_DTO Doctor_DTO){
		
		Doctor Doctor =Doctor_Service.getBYID(id);
		if(Doctor==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		Doctor.setName(Doctor_DTO.getName());
		Doctor.setMobileno(Doctor_DTO.getMobileno());
		Doctor.setAddress(Doctor_DTO.getAddress());
		Doctor.setPassword(encoderConfig.encode(Doctor_DTO.getPassword()));

		Doctor.setEmail(Doctor_DTO.getEmail());
		Doctor.setClinic_name(Doctor_DTO.getClinic_name());
		Doctor.setSpecialization(Doctor_DTO.getSpecialization());
		Doctor.setToken(Doctor_DTO.getToken());
		Doctor.setStatus(Doctor_DTO.getStatus());
	
		Doctor.setUpdated_at(Doctor_DTO.getUpdated_at());
		Doctor.setQualification(Doctor_DTO.getQualification());
		
		Doctor saveDoctor =Doctor_Service.save(Doctor);
		
		return new ResponseEntity<>(saveDoctor,HttpStatus.FOUND);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> DeleteDoctor(@PathVariable("id") int id){
		
		Doctor Doctor=Doctor_Service.getBYID(id);
		if(Doctor==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}Doctor_Service.delete(id);
		return new ResponseEntity<>(HttpStatus.MOVED_PERMANENTLY);
	}
}
