package com.OPD_Managemnet_System.OPDServices;

import com.OPD_Managemnet_System.OPD_DTOs.ResetPasswordDto;
import com.OPD_Managemnet_System.Response.EmailResponce;

public interface ResetPasswordService {

	//this method for doctor password rest after forget password
	EmailResponce DoctorResetPassword(ResetPasswordDto passwordDto);
	
	//this method for reception password rest after forget password
	EmailResponce ReceptionResetPassword(ResetPasswordDto passwordDto);

}
