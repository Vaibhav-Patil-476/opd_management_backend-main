package com.OPD_Managemnet_System.OPDServices;

import java.util.List;

import com.OPD_Managemnet_System.OPDEntitys.Test_Master;

public interface Test_Master_Service {

	Test_Master save(Test_Master test_Master);//user defined method for save data
	
	List<Test_Master> ListofTest_Master(); //user defined method for show list of doctor data
	
	Test_Master getBYTest_MasterID(int id);//user defined method for show doctor data by there id
	
	void deleteById (int id);//user defined method for delete doctor data by there id
}
