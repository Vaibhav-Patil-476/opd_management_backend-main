package com.OPD_Managemnet_System.OPDServices;

import java.util.List;

import com.OPD_Managemnet_System.OPDEntitys.Pathology_Test;

public interface Pathology_Test_Service {

	Pathology_Test save(Pathology_Test pathology_Test);
	
	List<Pathology_Test> getAllPathology_Tests();
	
	Pathology_Test getPathology_TestById(int id);
	
	void DeletePathology_TestById(int id);
}
