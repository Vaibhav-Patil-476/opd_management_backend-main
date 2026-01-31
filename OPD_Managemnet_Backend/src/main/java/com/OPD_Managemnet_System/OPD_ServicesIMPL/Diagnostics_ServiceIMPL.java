package com.OPD_Managemnet_System.OPD_ServicesIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OPD_Managemnet_System.ExceptionHandling.DatabaseException;
import com.OPD_Managemnet_System.ExceptionHandling.ResourceNotFoundException;
import com.OPD_Managemnet_System.OPDEntitys.Diagnostics;
import com.OPD_Managemnet_System.OPDRepo.Diagnostics_Repo;
import com.OPD_Managemnet_System.OPDServices.Diagnostics_Service;

@Service
public class Diagnostics_ServiceIMPL implements Diagnostics_Service {

	//Create Object of Diagnostics_Repo file
	@Autowired
	private Diagnostics_Repo diagnostics_Repo;
	
	//Implement Abstract Methods(Save , GetAll, GetById, and delete)
	@Override
	public Diagnostics saveDiagnostics(Diagnostics diagnostics) {
		try {
			return diagnostics_Repo.save(diagnostics);
		} catch (Exception e) {
			throw new DatabaseException("Internal Server Error...!");
		}
		
	}

	@Override
	public List<Diagnostics> getAllDiagnostics() {
		try {
			return diagnostics_Repo.findAll();
		} catch (Exception e) {
			throw new ResourceNotFoundException("Diagnostics List not exists...!");
		}
		
	}

	@Override
	public Diagnostics getByDiagnosticsID(int id) {
		
		return diagnostics_Repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Diagnostics not exists with this id...!"));
	}

	@Override
	public void deleteById(int id) {
		try {
			diagnostics_Repo.deleteById(id);
		} catch (Exception e) {
			throw new ResourceNotFoundException("Diagnostics not exists with this id....!"+id);
		}
		
	}

}
