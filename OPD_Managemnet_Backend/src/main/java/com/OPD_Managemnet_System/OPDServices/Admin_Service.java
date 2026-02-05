package com.OPD_Managemnet_System.OPDServices;

import java.util.List;

import com.OPD_Managemnet_System.OPDEntitys.Admin;

public interface Admin_Service {

	Admin saveAdmin(Admin admin ); //user defined method for save data
	
	List<Admin> getAllAdmin();  //user defined method for show list of doctor data
	
	Admin getadminById(int id); //user defined method for show doctor data by there id
	
	void deleteAdminById(int id);  //user defined method for delete doctor data by there id
}
