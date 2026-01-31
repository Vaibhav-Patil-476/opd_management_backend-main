package com.OPD_Managemnet_System.OPD_ServicesIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OPD_Managemnet_System.ExceptionHandling.DatabaseException;
import com.OPD_Managemnet_System.ExceptionHandling.ResourceNotFoundException;
import com.OPD_Managemnet_System.OPDEntitys.Referral;
import com.OPD_Managemnet_System.OPDRepo.Referral_Repo;
import com.OPD_Managemnet_System.OPDServices.Referral_Service;

@Service
public class Referral_ServiceIMPL implements Referral_Service{

	@Autowired
	private Referral_Repo referral_Repo;
	@Override
	public Referral save(Referral referral) {
		try {
			return referral_Repo.save(referral);
		} catch (Exception e) {
			throw new DatabaseException("Internal server error...!");
		}
		
	}

	@Override
	public List<Referral> getAllReferral() {
		try {
			return referral_Repo.findAll();
		} catch (Exception e) {
			throw new ResourceNotFoundException("Referral List is not Exist...!");
		}
		
	}

	@Override
	public Referral GetReferralById(int id) {
		
		return referral_Repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Referral not exist by this id....!"+id));
	}


	@Override
	public void deleteReferralById(int id) {
		try {
			referral_Repo.deleteById(id);
		} catch (Exception e) {
			throw new ResourceNotFoundException("Referral id not Exist....!");
		}
		
	}

	

}
