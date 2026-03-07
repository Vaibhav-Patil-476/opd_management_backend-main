package com.OPD_Managemnet_System.OPDServices;

import com.OPD_Managemnet_System.OPD_DTOs.ResetPasswordDto;
import com.OPD_Managemnet_System.Response.EmailResponce;

public interface ResetPasswordService {

	//this method for password rest after forget password
	EmailResponce ResetPassword(ResetPasswordDto passwordDto);
}
