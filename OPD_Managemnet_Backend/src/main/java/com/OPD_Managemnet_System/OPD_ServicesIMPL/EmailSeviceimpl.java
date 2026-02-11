package com.OPD_Managemnet_System.OPD_ServicesIMPL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.OPD_Managemnet_System.OPDServices.EmailService;
import com.OPD_Managemnet_System.OPD_DTOs.EmailRequest;
import com.OPD_Managemnet_System.Response.EmailResponce;

@Service
public class EmailSeviceimpl implements EmailService {

	
	@Autowired
	private JavaMailSender mailSender;
	
	@Override
	public EmailResponce sendEmail(EmailRequest request) {
		
		EmailResponce responce =new EmailResponce();
		
		try {
			SimpleMailMessage mail=new SimpleMailMessage();
			
			mail.setTo(request.getTo());
			mail.setSubject(request.getSubject());
			mail.setText(request.getMessage());
			 
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
