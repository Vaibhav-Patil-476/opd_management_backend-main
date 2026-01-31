package com.OPD_Managemnet_System.OPD_ServicesIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OPD_Managemnet_System.ExceptionHandling.DatabaseException;
import com.OPD_Managemnet_System.ExceptionHandling.ResourceNotFoundException;
import com.OPD_Managemnet_System.OPDEntitys.Pathology_Test;
import com.OPD_Managemnet_System.OPDRepo.Pathology_Test_Repo;
import com.OPD_Managemnet_System.OPDServices.Pathology_Test_Service;

@Service
public class Pathology_Test_ServiceIMPL implements Pathology_Test_Service{

	@Autowired
	private Pathology_Test_Repo pathology_Test_Repo;
	
	@Override
	public Pathology_Test save(Pathology_Test pathology_Test) {
		try {
			return pathology_Test_Repo.save(pathology_Test);
		} catch (Exception e) {
			throw new DatabaseException("Internal Server Exception....!");
		}
		
	}

	@Override
	public List<Pathology_Test> getAllPathology_Tests() {
		try {
			return pathology_Test_Repo.findAll();
		} catch (Exception e) {
			throw new ResourceNotFoundException("Pathology_Test list not exist...!");
		}
		
	}

	@Override
	public Pathology_Test getPathology_TestById(int id) {
		
		return pathology_Test_Repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Pathology_Test not exists by id....!"+id));
	}

	@Override
	public void DeletePathology_TestById(int id) {
		try {
			pathology_Test_Repo.deleteById(id);
		} catch (Exception e) {
			throw new ResourceNotFoundException("Pathology_Test not exists by this id.....!"+id);
		}
		
	}

}
