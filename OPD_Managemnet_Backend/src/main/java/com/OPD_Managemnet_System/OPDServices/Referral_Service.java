package com.OPD_Managemnet_System.OPDServices;

import java.util.List;

import com.OPD_Managemnet_System.OPDEntitys.Referral;

public interface Referral_Service {

	Referral save(Referral referral);
	
	List<Referral> getAllReferral();
	
	Referral GetReferralById(int id);
	
	void deleteReferralById(int id);
}
