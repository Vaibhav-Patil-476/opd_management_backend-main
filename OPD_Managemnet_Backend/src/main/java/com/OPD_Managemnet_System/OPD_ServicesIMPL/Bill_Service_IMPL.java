package com.OPD_Managemnet_System.OPD_ServicesIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OPD_Managemnet_System.ExceptionHandling.DatabaseException;
import com.OPD_Managemnet_System.ExceptionHandling.ResourceNotFoundException;
import com.OPD_Managemnet_System.OPDEntitys.Bill;
import com.OPD_Managemnet_System.OPDRepo.Bill_Repo;
import com.OPD_Managemnet_System.OPDServices.Bill_Service;

@Service
public class Bill_Service_IMPL implements Bill_Service {

	@Autowired
	private Bill_Repo bill_Repo;

	@Override
	public Bill save(Bill bill) {
		try {
			return bill_Repo.save(bill);// repository method
		} catch (Exception e) {
			throw new DatabaseException("Internal Server Error..!");
		}

	}

	@Override
	public List<Bill> GetallBill() {
		try {
			return bill_Repo.findAll();// repository method
		} catch (Exception e) {
			throw new ResourceNotFoundException("List's of Bill not exists....!");
		}

	}

	@Override
	public Bill GetBillById(int id) {

		return bill_Repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("This Id is not Bill id not exists.....!"));
	}

	@Override
	public void deleteBillById(int id) {
		try {
			bill_Repo.deleteById(id);// repository method
		} catch (Exception e) {
			throw new ResourceNotFoundException("This id not exists....!");
		}

	}

}
