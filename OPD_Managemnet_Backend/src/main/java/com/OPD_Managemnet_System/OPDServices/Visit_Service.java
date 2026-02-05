package com.OPD_Managemnet_System.OPDServices;

import java.util.List;

import org.springframework.stereotype.Service;

import com.OPD_Managemnet_System.OPDEntitys.Visit;

@Service
public interface Visit_Service {
	
	Visit save (Visit visit); //user defined method for save data
	
	List<Visit> getAll(); //user defined method for show list of doctor data
	
	Visit getBYID(int id); //user defined method for show doctor data by there id
	
	void deleteBYID(int id);//user defined method for delete doctor data by there id

}
