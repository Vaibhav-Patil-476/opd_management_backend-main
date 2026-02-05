package com.OPD_Managemnet_System.OPD_ServicesIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OPD_Managemnet_System.ExceptionHandling.DatabaseException;
import com.OPD_Managemnet_System.ExceptionHandling.ResourceNotFoundException;
import com.OPD_Managemnet_System.OPDEntitys.Medicine;
import com.OPD_Managemnet_System.OPDRepo.Medicine_Repo;
import com.OPD_Managemnet_System.OPDServices.Medicine_Service;

@Service
public class Medicine_ServiceIMPL implements Medicine_Service {

	@Autowired
	private Medicine_Repo medicine_Repo;

	@Override
	public Medicine save(Medicine medicine) {
		try {
			return medicine_Repo.save(medicine);// repository method
		} catch (Exception e) {
			throw new DatabaseException("Database Internal Error...!");
		}
	}

	@Override
	public List<Medicine> GetAllMedicine() {
		try {
			return medicine_Repo.findAll();// repository method
		} catch (Exception e) {
			throw new ResourceNotFoundException("medicine List not exists...!");
		}

	}

	@Override
	public Medicine GetMedicineById(int id) {

		return medicine_Repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Medicine Not exists with this id....!" + id));
	}

	@Override
	public void deleteById(int id) {
		try {
			medicine_Repo.deleteById(id);// repository method
		} catch (Exception e) {
			throw new ResourceNotFoundException("Medicine Not exists by this id....!" + id);
		}

	}

}
