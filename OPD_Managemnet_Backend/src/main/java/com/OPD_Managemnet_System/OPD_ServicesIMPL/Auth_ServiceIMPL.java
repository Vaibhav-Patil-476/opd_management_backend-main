package com.OPD_Managemnet_System.OPD_ServicesIMPL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.OPD_Managemnet_System.ExceptionHandling.ResourceNotFoundException;
import com.OPD_Managemnet_System.OPDEntitys.Admin;
import com.OPD_Managemnet_System.OPDEntitys.Doctor;
import com.OPD_Managemnet_System.OPDEntitys.Reception;
import com.OPD_Managemnet_System.OPDRepo.Admin_Repo;
import com.OPD_Managemnet_System.OPDRepo.Doctor_Repo;
import com.OPD_Managemnet_System.OPDRepo.Reception_Repo;
import com.OPD_Managemnet_System.OPDServices.Auth_Service;
import com.OPD_Managemnet_System.OPD_DTOs.Login_Request;
import com.OPD_Managemnet_System.Response.AdminResponce;
import com.OPD_Managemnet_System.Response.DoctorResponce;
import com.OPD_Managemnet_System.Response.JWtResponse;
import com.OPD_Managemnet_System.Response.Login_Response;
import com.OPD_Managemnet_System.Response.ReceptionResponce;
import com.OPD_Managemnet_System.Security.JWTUtil;


@Service
public class Auth_ServiceIMPL implements Auth_Service {
	@Autowired
	private  Doctor_Repo doctor_Repo;
	
	@Autowired
	private Admin_Repo admin_Repo;
	
	@Autowired
	private Reception_Repo reception_Repo;
	
	@Autowired
	private  PasswordEncoder passwordEncoder;
	
	@Autowired
	private  JWTUtil jwtUtil;


	@Override
	public JWtResponse doctorlogin(Login_Request request) {
		Doctor doctor =doctor_Repo.findByEmail(request.getEmail()).orElseThrow(() -> new ResourceNotFoundException("Email not found"));
		
		if(!passwordEncoder.matches(request.getPassword(), doctor.getPassword())) {
			throw new RuntimeException("Invalid  Password...!");
		}
		
		 DoctorResponce responce = new DoctorResponce();
	        responce.setId(doctor.getId());
	        responce.setName(doctor.getName());
	        responce.setEmail(doctor.getEmail());
	        responce.setAddress(doctor.getAddress());
	        responce.setClinic_name(doctor.getClinic_name());
	        responce.setMobileno(doctor.getMobileno());
	        responce.setQualification(doctor.getQualification());
	        responce.setSpecialization(doctor.getSpecialization());
	        
		  // Generate JWT token
	        String token = jwtUtil.generateToken(
		        doctor.getEmail(),
		        doctor.getRole().name());
		        return new JWtResponse(token,doctor.getRole(),responce);
		
	}


	@Override
	public JWtResponse adminLogin(Login_Request request) {
		Admin admin = admin_Repo.findByEmail(request.getEmail())
				.orElseThrow(() -> new ResourceNotFoundException("Email not found"));
		
		if(!passwordEncoder.matches(request.getPassword(), admin.getPassword())) {
			throw new RuntimeException("Invalid password");
		}
		AdminResponce response = new AdminResponce();
		response.setId(admin.getId());
		response.setEmail(admin.getEmail());
		response.setName(admin.getName());
		response.setMobileno(admin.getMobileNo());
		
		 // Generate JWT token
		 String token = jwtUtil.generateToken(
			        admin.getEmail(),
			        admin.getRole().name());
		 
        return new JWtResponse(token, admin.getRole(), response);
	
		 
       
       
	}

	@Override
	public JWtResponse receptionLogin(Login_Request request) {
		
		Reception reception = reception_Repo.findByEmail(request.getEmail())
				.orElseThrow(() -> new ResourceNotFoundException("Email not found"));
		
		if(!passwordEncoder.matches(request.getPassword(), reception.getPassword())) {
			throw new RuntimeException("Invalid password");
		}
		ReceptionResponce response = new ReceptionResponce();
		response.setId(reception.getId());
		
		response.setDoctor_id(reception.getDoctorid().getId());
		response.setEmail(reception.getEmail());
		response.setName(reception.getName());
		response.setPhoneNo(reception.getMobileNo());
		response.setShift(reception.getShift());
		
		  // Generate JWT token
        String token = jwtUtil.generateToken(
        		reception.getEmail(),
        		reception.getRole().name());
        return new JWtResponse(token, reception.getRole(), response);
	
	}
		
	
		
	}

