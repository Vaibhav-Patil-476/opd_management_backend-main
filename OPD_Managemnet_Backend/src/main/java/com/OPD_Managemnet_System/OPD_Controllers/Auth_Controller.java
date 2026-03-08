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
import com.OPD_Managemnet_System.OPD_DTOs.EmailSendDTO;

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

//--------------------------------------Doctor Email send Controller-------------------------------------------	
	@PostMapping("/doctor/email-send")
	public EmailResponce requestOtp(@Valid @RequestBody EmailSendDTO otpDTO) {
		return emailService.doctorEmailSend(otpDTO);
//--------------------------------------Reception Email send Controller-------------------------------------------
	}
	@PostMapping("/reception/email-send")
		public EmailResponce receptionMailSend(@Valid @RequestBody EmailSendDTO otpDTO) {
			return emailService.receptionEmailSend(otpDTO);
	}
//--------------------------------------Doctor OTP verify Controller-------------------------------------------	
	@PostMapping("/doctor/otp-verify")
	public EmailResponce doctorverifyOtp(@Valid @RequestBody VerifyEmailOTPDto verifyEmailOTPDto) {

		return verifyEmailOtp.DoctorEmailOtpVerify(verifyEmailOTPDto);
	}
//--------------------------------------Doctor Forgot Password Controller-------------------------------------------
	@PostMapping("/doctor/forgot-password")
	public EmailResponce doctorForgotPassword(@Valid @RequestBody ResetPasswordDto resetPasswordDto) {

		return resetPasswordService.DoctorResetPassword(resetPasswordDto);
	}
	//--------------------------------------Reception OTP verify Controller-------------------------------------------	
	@PostMapping("/reception/otp-verify")
	public EmailResponce receptionVerifyOtp(@Valid @RequestBody VerifyEmailOTPDto verifyEmailOTPDto) {

		return verifyEmailOtp.ReceptionEmailOtpVerify(verifyEmailOTPDto);
	}
	//--------------------------------------Reception Forgot Controller-------------------------------------------	
	@PostMapping("/reception/forgot-password")
	public EmailResponce receptionForgotPassword(@Valid @RequestBody ResetPasswordDto resetPasswordDto) {

		return resetPasswordService.ReceptionResetPassword(resetPasswordDto);
}}
	
