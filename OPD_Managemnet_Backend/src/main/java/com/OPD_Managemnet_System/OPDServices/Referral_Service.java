package com.OPD_Managemnet_System.OPDServices;

import java.util.List;

import com.OPD_Managemnet_System.OPDEntitys.Referral;

public interface Referral_Service {

	Referral save(Referral referral);// user defined method for save data

	List<Referral> getAllReferral();// user defined method for show list of doctor data

	Referral GetReferralById(int id);// user defined method for show doctor data by there id

	void deleteReferralById(int id); // user defined method for delete doctor data by there id
}
