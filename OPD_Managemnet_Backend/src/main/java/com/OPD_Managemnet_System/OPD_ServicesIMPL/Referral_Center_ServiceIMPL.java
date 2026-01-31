package com.OPD_Managemnet_System.OPD_ServicesIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.sql.init.DatabaseInitializationSettings;
import org.springframework.stereotype.Service;

import com.OPD_Managemnet_System.ExceptionHandling.DatabaseException;
import com.OPD_Managemnet_System.ExceptionHandling.ResourceNotFoundException;
import com.OPD_Managemnet_System.OPDEntitys.Referral_Center;
import com.OPD_Managemnet_System.OPDRepo.Referral_Center_Repo;
import com.OPD_Managemnet_System.OPDServices.Referral_Center_Service;

@Service
public class Referral_Center_ServiceIMPL implements Referral_Center_Service{

	@Autowired
	private Referral_Center_Repo referral_Center_Repo;
	@Override
	public Referral_Center save(Referral_Center referral_Center) {
		try {
			return referral_Center_Repo.save(referral_Center);
		} catch (Exception e) {
			throw new DatabaseException("Internal server Error...!");
		}
		
	}

	@Override
	public List<Referral_Center> GetAllMedicine() {
		try {
			return referral_Center_Repo.findAll();
		} catch (Exception e) {
			throw new ResourceNotFoundException("Referral_Center list not exists....!");
		}
		
	}

	@Override
	public Referral_Center GetReferral_CenterById(int id) {
		
		return referral_Center_Repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Referral_Center not exists by this id....!"+id));
	}

	@Override
	public void deleteById(int id) {
		try {
			referral_Center_Repo.deleteById(id);
		} catch (Exception e) {
			throw new ResourceNotFoundException("Referral_Center not exists by id...!");
		}
		
	}

}
