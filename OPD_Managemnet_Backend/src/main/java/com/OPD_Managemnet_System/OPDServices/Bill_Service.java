package com.OPD_Managemnet_System.OPDServices;

import java.util.List;

import com.OPD_Managemnet_System.OPDEntitys.Bill;

public interface Bill_Service {

	Bill save(Bill bill);
	
	List<Bill> GetallBill();
	
	Bill GetBillById(int id);
	
	void deleteBillById(int id);
}
