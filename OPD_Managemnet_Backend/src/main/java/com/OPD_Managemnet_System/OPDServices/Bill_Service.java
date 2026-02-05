package com.OPD_Managemnet_System.OPDServices;

import java.util.List;

import com.OPD_Managemnet_System.OPDEntitys.Bill;

public interface Bill_Service {

	Bill save(Bill bill);// user defined method for save data

	List<Bill> GetallBill();// user defined method for show list of doctor data

	Bill GetBillById(int id);// user defined method for show doctor data by there id

	void deleteBillById(int id);// user defined method for delete doctor data by there id
}
