package com.OPD_Managemnet_System.OPD_ServicesIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OPD_Managemnet_System.ExceptionHandling.DatabaseException;
import com.OPD_Managemnet_System.ExceptionHandling.ResourceNotFoundException;
import com.OPD_Managemnet_System.OPDEntitys.Admin;
import com.OPD_Managemnet_System.OPDRepo.Admin_Repo;
import com.OPD_Managemnet_System.OPDServices.Admin_Service;

@Service
public class Admin_ServiceIMPl implements Admin_Service {
	
	@Autowired
	private Admin_Repo admin_Repo;

	@Override
	public Admin saveAdmin(Admin admin) {
		try {
			return admin_Repo.save(admin) ;
		} catch (Exception e) {
			throw new DatabaseException("Internal Server Error...!");
		}
		
	}

	@Override
	public List<Admin> getAllAdmin() {
		try {
			return admin_Repo.findAll();
		} catch (Exception e) {
			throw new ResourceNotFoundException("Admin List not Exist...!");
		}
	}

	@Override
	public Admin getadminById(int id) {
		
		return admin_Repo.findById (id).orElseThrow(()-> new ResourceNotFoundException("Admin not Exist by this Id...!"+id));
	}

	@Override
	public void deleteAdminById(int id) {
		try {
			admin_Repo.deleteById(id);
		} catch (Exception e) {
			throw new ResourceNotFoundException("Admin not Exist by this Id...!"+id);
		}
	}

}
