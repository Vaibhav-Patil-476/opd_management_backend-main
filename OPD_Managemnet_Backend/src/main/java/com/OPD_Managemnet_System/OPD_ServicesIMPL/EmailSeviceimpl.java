package com.OPD_Managemnet_System.OPD_ServicesIMPL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.OPD_Managemnet_System.ExceptionHandling.ResourceNotFoundException;
import com.OPD_Managemnet_System.OPDEntitys.Doctor;
import com.OPD_Managemnet_System.OPDRepo.Doctor_Repo;
import com.OPD_Managemnet_System.OPDServices.EmailOtpGenerater;
import com.OPD_Managemnet_System.OPDServices.EmailService;
import com.OPD_Managemnet_System.OPD_DTOs.EmailRequest;
import com.OPD_Managemnet_System.OPD_DTOs.EmailSendOtpDTO;
import com.OPD_Managemnet_System.Response.EmailResponce;

@Service
public class EmailSeviceimpl implements EmailService {

	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private EmailOtpGenerater emailOtpGenerater;
	
	@Autowired
	private Doctor_Repo doctor_Repo;
	

	
	@Override
	public EmailResponce sendEmail(EmailSendOtpDTO otpDTO) {
		
		EmailResponce responce =new EmailResponce();
		
		Long otp=emailOtpGenerater.generateOTP();
		
		Doctor doctor = doctor_Repo.findByEmail(otpDTO.getEmail()).orElseThrow(()-> new ResourceNotFoundException("Invalid Doctor...."));
		
		doctor.setOtp(otp);
		doctor_Repo.save(doctor);
		try {
			SimpleMailMessage mail=new SimpleMailMessage();
			
			mail.setTo(otpDTO.getEmail());
			mail.setSubject("Password Recovery by Email");
			mail.setText("Your Email Otp is"+otp);
			 
			mailSender.send(mail);
			
			responce.setSuccess(true);
			responce.setMessage("Email sent succefully");
			
			 
		} catch (Exception e) {
			responce.setSuccess(false);
			responce.setMessage("Failed to sent Email");
		}
		
		return responce;
	}

}
