package com.OPD_Managemnet_System.OPDServices;

import java.util.List;

import com.OPD_Managemnet_System.OPDEntitys.Medicine;

public interface Medicine_Service {

	//Create Abstract Method (Save , GetAll ,ByID and DeleteById)
	Medicine save (Medicine medicine);
	
	List<Medicine> GetAllMedicine();
	
	Medicine GetMedicineById(int id);
	
	void deleteById(int id);
}
