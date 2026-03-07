package com.OPD_Managemnet_System.OPD_Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.OPD_Managemnet_System.OPDServices.Auth_Service;
import com.OPD_Managemnet_System.OPDServices.EmailService;
import com.OPD_Managemnet_System.OPDServices.ResetPasswordService;
import com.OPD_Managemnet_System.OPDServices.VerifyEmailOtpService;
import com.OPD_Managemnet_System.OPD_DTOs.Login_Request;
import com.OPD_Managemnet_System.OPD_DTOs.ResetPasswordDto;
import com.OPD_Managemnet_System.OPD_DTOs.EmailSendOtpDTO;
import com.OPD_Managemnet_System.OPD_DTOs.VerifyEmailOTPDto;
import com.OPD_Managemnet_System.Response.EmailResponce;
import com.OPD_Managemnet_System.Response.JWtResponse;
import com.OPD_Managemnet_System.Response.Login_Response;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class Auth_Controller {

	// Inject service layer to perform Auth-related operations
	@Autowired
	private Auth_Service service;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private VerifyEmailOtpService verifyEmailOtp;
	
	@Autowired
	private ResetPasswordService resetPasswordService;

	// login controller
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
	
	@PostMapping("/email/send")
	public EmailResponce requestOtp(@Valid @RequestBody EmailSendOtpDTO otpDTO) {
		return emailService.sendEmail(otpDTO);
	}
	
	@PostMapping("/otp-verify")
	public EmailResponce verifyOtp(@Valid @RequestBody VerifyEmailOTPDto verifyEmailOTPDto) {
		
		return verifyEmailOtp.EmailOtpVerify(verifyEmailOTPDto);
	}
	
	@PostMapping("/forgot-password")
	public EmailResponce forgotPassword(@Valid @RequestBody ResetPasswordDto resetPasswordDto ) {
		
		return resetPasswordService.ResetPassword(resetPasswordDto);
	}
}
