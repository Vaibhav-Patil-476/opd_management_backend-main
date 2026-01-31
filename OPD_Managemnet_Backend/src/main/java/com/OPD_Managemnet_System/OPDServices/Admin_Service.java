package com.OPD_Managemnet_System.OPDServices;

import java.util.List;

import com.OPD_Managemnet_System.OPDEntitys.Admin;

public interface Admin_Service {

	Admin saveAdmin(Admin admin );
	
	List<Admin> getAllAdmin();
	
	Admin getadminById(int id);
	
	void deleteAdminById(int id);
}
