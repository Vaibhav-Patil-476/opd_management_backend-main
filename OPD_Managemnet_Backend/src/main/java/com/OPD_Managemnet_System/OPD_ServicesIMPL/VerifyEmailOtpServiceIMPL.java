package com.OPD_Managemnet_System.OPD_ServicesIMPL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OPD_Managemnet_System.ExceptionHandling.ResourceNotFoundException;
import com.OPD_Managemnet_System.OPDEntitys.Doctor;
import com.OPD_Managemnet_System.OPDEntitys.Reception;
import com.OPD_Managemnet_System.OPDRepo.Doctor_Repo;
import com.OPD_Managemnet_System.OPDRepo.Reception_Repo;
import com.OPD_Managemnet_System.OPDServices.VerifyEmailOtpService;
import com.OPD_Managemnet_System.OPD_DTOs.VerifyEmailOTPDto;
import com.OPD_Managemnet_System.Response.EmailResponce;

@Service
public class VerifyEmailOtpServiceIMPL implements VerifyEmailOtpService  {

	@Autowired
	private Doctor_Repo doctor_Repo;
	
	@Autowired
	private Reception_Repo reception_Repo;
	
	@Override
	public EmailResponce DoctorEmailOtpVerify(VerifyEmailOTPDto verifyEmailOTPDto) {
		
		Doctor doctor = doctor_Repo.findByEmail(verifyEmailOTPDto.getEmail()).orElseThrow(()-> new ResourceNotFoundException("Email is not Valid...."));
		
		if(!doctor.getOtp().equals(verifyEmailOTPDto.getOtp())) {
			throw new ResourceNotFoundException("Invalid OTP");
		}
		
		doctor.setOtpVerified(true);
		doctor_Repo.save(doctor);
		
		EmailResponce responce = new EmailResponce();
		
		responce.setMessage("OTP verfied....");
		responce.setSuccess(true);
		
		return responce;
	}


//------------------------------------ Reception Email OTP Verify-------------------------------------------------

	@Override
	public EmailResponce ReceptionEmailOtpVerify(VerifyEmailOTPDto verifyEmailOTPDto) {
	
		Reception reception = reception_Repo.findByEmail(verifyEmailOTPDto.getEmail()).orElseThrow(()-> new ResourceNotFoundException("Email is not Valid...."));
		
		if(!reception.getOtp().equals(verifyEmailOTPDto.getOtp())) {
			throw new ResourceNotFoundException("Invalid OTP");
		}
		reception.setOtpVerified(true);
		reception_Repo.save(reception);
		
		EmailResponce responce = new EmailResponce();
		
		responce.setMessage("OTP verfied....");
		responce.setSuccess(true);
		
		return responce;
	}
	
	
}
