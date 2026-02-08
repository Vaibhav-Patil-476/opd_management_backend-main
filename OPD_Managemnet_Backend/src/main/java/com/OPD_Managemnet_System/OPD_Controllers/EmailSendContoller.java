package com.OPD_Managemnet_System.OPD_Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.OPD_Managemnet_System.OPDServices.EmailService;
import com.OPD_Managemnet_System.OPD_DTOs.EmailRequest;
import com.OPD_Managemnet_System.Response.EmailResponce;

@RestController
@RequestMapping("/api/email")
public class EmailSendContoller {

	@Autowired
	private EmailService emailService;
	
	@PostMapping("/send")
	public ResponseEntity<EmailResponce> sendEmail(@RequestBody EmailRequest request){
		
		return ResponseEntity.ok(emailService.sendEmail(request));
	}
}
