package com.OPD_Managemnet_System.OPD_ServicesIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OPD_Managemnet_System.ExceptionHandling.DatabaseException;
import com.OPD_Managemnet_System.ExceptionHandling.ResourceNotFoundException;
import com.OPD_Managemnet_System.OPDEntitys.Test_Master;
import com.OPD_Managemnet_System.OPDRepo.Test_Master_Repo;
import com.OPD_Managemnet_System.OPDServices.Test_Master_Service;

@Service
public class Test_Master_ServiceIMPL implements Test_Master_Service {

	@Autowired
	private Test_Master_Repo master_Repo;

	@Override
	public Test_Master save(Test_Master test_Master) {
		try {
			return master_Repo.save(test_Master);// repository method
		} catch (Exception e) {
			throw new DatabaseException("Internal server Error...!");
		}

	}

	@Override
	public List<Test_Master> ListofTest_Master() {
		try {
			return master_Repo.findAll();// repository method
		} catch (Exception e) {
			throw new ResourceNotFoundException("Test_Master List not exist...!");
		}

	}

	@Override
	public Test_Master getBYTest_MasterID(int id) {

		return master_Repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("This Test_Master is not exist....!"));
	}

	@Override
	public void deleteById(int id) {
		try {
			master_Repo.deleteById(id);// repository method
		} catch (Exception e) {
			throw new ResourceNotFoundException("This Test_Master is not exist....!");
		}

	}

}
