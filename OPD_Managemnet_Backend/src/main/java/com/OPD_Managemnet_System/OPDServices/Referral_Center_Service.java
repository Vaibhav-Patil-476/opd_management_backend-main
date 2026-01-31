package com.OPD_Managemnet_System.OPDServices;

import java.util.List;

import com.OPD_Managemnet_System.OPDEntitys.Referral_Center;


public interface Referral_Center_Service {

	//create abstract method
	Referral_Center save (Referral_Center referral_Center);
	
	List<Referral_Center> GetAllMedicine();
	
	Referral_Center GetReferral_CenterById(int id);
	
	void deleteById(int id);
}
