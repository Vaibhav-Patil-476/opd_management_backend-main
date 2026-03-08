package com.OPD_Managemnet_System.OPDServices;

import com.OPD_Managemnet_System.OPD_DTOs.EmailRequest;
import com.OPD_Managemnet_System.OPD_DTOs.EmailSendDTO;

import com.OPD_Managemnet_System.Response.EmailResponce;

public interface EmailService {

	//abstract method for email send logic
	EmailResponce doctorEmailSend(EmailSendDTO otpDTO);
	

	
	//Method for send mail to reception
	EmailResponce receptionEmailSend(EmailSendDTO sendDTO);
}
