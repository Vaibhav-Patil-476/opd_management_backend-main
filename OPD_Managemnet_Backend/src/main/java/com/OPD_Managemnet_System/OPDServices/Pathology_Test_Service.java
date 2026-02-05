package com.OPD_Managemnet_System.OPDServices;

import java.util.List;

import com.OPD_Managemnet_System.OPDEntitys.Pathology_Test;

public interface Pathology_Test_Service {

	Pathology_Test save(Pathology_Test pathology_Test); // user defined method for save data

	List<Pathology_Test> getAllPathology_Tests();// user defined method for show list of doctor data

	Pathology_Test getPathology_TestById(int id);// user defined method for show doctor data by there id

	void DeletePathology_TestById(int id); // user defined method for delete doctor data by there id
}
