package com.OPD_Managemnet_System.OPDServices;

import java.util.List;

import com.OPD_Managemnet_System.OPDEntitys.Medicine;

public interface Medicine_Service {

	Medicine save(Medicine medicine);// user defined method for save data

	List<Medicine> GetAllMedicine(); // user defined method for show list of doctor data

	Medicine GetMedicineById(int id);// user defined method for show doctor data by there id

	void deleteById(int id); // user defined method for delete doctor data by there id
}
