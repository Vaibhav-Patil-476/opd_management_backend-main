package com.OPD_Managemnet_System.OPDServices;

import com.OPD_Managemnet_System.OPD_DTOs.Login_Request;
import com.OPD_Managemnet_System.Response.JWtResponse;



public interface Auth_Service {

	 JWtResponse doctorlogin(Login_Request request);
	 JWtResponse receptionLogin(Login_Request request);
	 JWtResponse adminLogin(Login_Request request);
}
