package com.OPD_Managemnet_System.OPDServices;

import java.util.List;

import org.springframework.stereotype.Service;

import com.OPD_Managemnet_System.OPDEntitys.Visit;

@Service
public interface Visit_Service {
	
	Visit save (Visit visit);
	
	List<Visit> getAll();
	
	Visit getBYID(int id);
	
	void deleteBYID(int id);

}
