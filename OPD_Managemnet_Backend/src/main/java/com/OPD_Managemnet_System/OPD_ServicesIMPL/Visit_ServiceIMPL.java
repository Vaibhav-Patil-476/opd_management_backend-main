package com.OPD_Managemnet_System.OPD_ServicesIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OPD_Managemnet_System.ExceptionHandling.DatabaseException;
import com.OPD_Managemnet_System.ExceptionHandling.ResourceNotFoundException;
import com.OPD_Managemnet_System.OPDEntitys.Visit;
import com.OPD_Managemnet_System.OPDRepo.Visit_repo;
import com.OPD_Managemnet_System.OPDServices.Visit_Service;

@Service
public class Visit_ServiceIMPL implements Visit_Service {

	@Autowired
	private Visit_repo visit_repo;

	@Override
	public Visit save(Visit visit) {
		try {
			return visit_repo.save(visit);// repository method
		} catch (Exception e) {
			throw new DatabaseException("Internal Server Error...!");
		}

	}

	@Override
	public List<Visit> getAll() {
		try {
			return visit_repo.findAll();// repository method
		} catch (Exception e) {
			throw new ResourceNotFoundException("Visit List not Exist....!");
		}

	}

	@Override
	public Visit getBYID(int id) {

		return visit_repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Visit is not exist by this id...!" + id));
	}

	@Override
	public void deleteBYID(int id) {
		try {
			visit_repo.deleteById(id);// repository method
		} catch (Exception e) {
			throw new ResourceNotFoundException("Vist is not exist by this id" + id);
		}

	}

}
