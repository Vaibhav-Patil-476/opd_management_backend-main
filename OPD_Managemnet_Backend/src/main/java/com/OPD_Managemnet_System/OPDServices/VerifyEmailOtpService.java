package com.OPD_Managemnet_System.OPDServices;

import com.OPD_Managemnet_System.OPD_DTOs.VerifyEmailOTPDto;
import com.OPD_Managemnet_System.Response.EmailResponce;

public interface VerifyEmailOtpService {

	EmailResponce EmailOtpVerify(VerifyEmailOTPDto verifyEmailOTPDto);
}
