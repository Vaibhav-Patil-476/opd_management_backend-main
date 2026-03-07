package com.OPD_Managemnet_System.OPDServices;

import java.util.Random;

import org.springframework.context.annotation.Configuration;

@Configuration
public class EmailOtpGenerater {

	public long generateOTP(){
		return 100000 + new Random().nextInt(900000);
	}
}
