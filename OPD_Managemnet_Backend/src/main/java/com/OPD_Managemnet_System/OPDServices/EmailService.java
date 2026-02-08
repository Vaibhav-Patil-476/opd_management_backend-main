package com.OPD_Managemnet_System.OPDServices;

import com.OPD_Managemnet_System.OPD_DTOs.EmailRequest;
import com.OPD_Managemnet_System.Response.EmailResponce;

public interface EmailService {

	//abstract method for email send logic
	EmailResponce sendEmail(EmailRequest request);
}
