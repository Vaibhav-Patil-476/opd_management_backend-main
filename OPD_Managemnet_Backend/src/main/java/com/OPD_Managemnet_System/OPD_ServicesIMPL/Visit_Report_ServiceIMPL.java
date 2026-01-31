package com.OPD_Managemnet_System.OPD_ServicesIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OPD_Managemnet_System.ExceptionHandling.DatabaseException;
import com.OPD_Managemnet_System.ExceptionHandling.ResourceNotFoundException;
import com.OPD_Managemnet_System.OPDEntitys.Visit_Report;
import com.OPD_Managemnet_System.OPDRepo.Visit_Report_Repo;
import com.OPD_Managemnet_System.OPDServices.Visit_Report_Service;

@Service
public class Visit_Report_ServiceIMPL implements Visit_Report_Service {

	@Autowired
	private Visit_Report_Repo visit_Report_Repo;
	
	@Override
	public Visit_Report save(Visit_Report visit_report) {
		try {
			return visit_Report_Repo.save(visit_report);
		} catch (Exception e) {
			throw new DatabaseException("Internal server error...!");
		}
		
	}

	@Override
	public List<Visit_Report> GetAllVisit_Report() {
		try {
			return visit_Report_Repo.findAll();
		} catch (Exception e) {
			throw new ResourceNotFoundException("Visit Report not exist...!");
		}
		
	}

	@Override
	public Visit_Report GetAllVisit_ReportByid(int id) {
		  
		return visit_Report_Repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Visit Report not exist by this id....!"+id));
	}

	@Override
	public void deleteById(int id) {
		try {
			visit_Report_Repo.deleteById(id);
		} catch (Exception e) {
			throw new ResourceNotFoundException("Visit Report not exist by this id....!"+id);
		}
		
	}

}
