package com.OPD_Managemnet_System.OPDServices;

import java.util.List;

import com.OPD_Managemnet_System.OPDEntitys.Test_Master;

public interface Test_Master_Service {

	Test_Master save(Test_Master test_Master);
	
	List<Test_Master> ListofTest_Master();
	
	Test_Master getBYTest_MasterID(int id);
	
	void deleteById (int id);
}
