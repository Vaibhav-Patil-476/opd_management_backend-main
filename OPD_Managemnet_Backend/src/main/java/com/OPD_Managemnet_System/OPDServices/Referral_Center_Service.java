package com.OPD_Managemnet_System.OPDServices;

import java.util.List;

import com.OPD_Managemnet_System.OPDEntitys.Referral_Center;

public interface Referral_Center_Service {

	Referral_Center save(Referral_Center referral_Center);// user defined method for save data

	List<Referral_Center> GetAllMedicine(); // user defined method for show list of doctor data

	Referral_Center GetReferral_CenterById(int id);// user defined method for show doctor data by there id

	void deleteById(int id); // user defined method for delete doctor data by there id
}
