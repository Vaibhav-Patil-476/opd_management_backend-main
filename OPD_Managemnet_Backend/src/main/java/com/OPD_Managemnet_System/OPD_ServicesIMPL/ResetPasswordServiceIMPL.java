package com.OPD_Managemnet_System.OPD_ServicesIMPL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.OPD_Managemnet_System.ExceptionHandling.ResourceNotFoundException;
import com.OPD_Managemnet_System.OPDEntitys.Doctor;
import com.OPD_Managemnet_System.OPDRepo.Doctor_Repo;
import com.OPD_Managemnet_System.OPDServices.ResetPasswordService;
import com.OPD_Managemnet_System.OPD_DTOs.ResetPasswordDto;
import com.OPD_Managemnet_System.Response.EmailResponce;

@Service
public class ResetPasswordServiceIMPL implements ResetPasswordService{
	
	@Autowired
	private Doctor_Repo doctor_Repo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public EmailResponce ResetPassword(ResetPasswordDto passwordDto) {
		
		Doctor doctor = doctor_Repo.findByEmail(passwordDto.getEmail()).orElseThrow(()-> new ResourceNotFoundException("Invalid Email....."));
		
		if(!doctor.isOtpVerified()) {
			throw new ResourceNotFoundException("OTP is not verified.....");
		}
		
		doctor.setPassword(passwordEncoder.encode(passwordDto.getNewPassword()));
		doctor.setOtp(null);
		doctor.setOtpVerified(false);
		
		doctor_Repo.save(doctor);
		
		EmailResponce responce= new EmailResponce();
		
		responce.setMessage("Passowrd Updated Successfully.....");
		responce.setSuccess(true);
		
		return responce;
	}

}
