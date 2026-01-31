package com.OPD_Managemnet_System.OPD_Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.OPD_Managemnet_System.OPDServices.Auth_Service;
import com.OPD_Managemnet_System.OPD_DTOs.Login_Request;
import com.OPD_Managemnet_System.Response.JWtResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class Auth_Controller {

	@Autowired
	private  Auth_Service service;
	
	//login controller
	@PostMapping("/login/doctor")
	public JWtResponse DoctorLogin(@Valid @RequestBody Login_Request request) {
		return service.doctorlogin(request);
	}
	
	@PostMapping("/login/reception")
	public JWtResponse receptionLogin(@Valid @RequestBody Login_Request request) {
		return service.receptionLogin(request);
	}
	
	@PostMapping("/login/admin")
	public JWtResponse adminLogin(@Valid @RequestBody Login_Request request) {
		return service.adminLogin(request);
	}
}
