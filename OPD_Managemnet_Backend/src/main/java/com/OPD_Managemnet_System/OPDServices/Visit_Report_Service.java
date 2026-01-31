package com.OPD_Managemnet_System.OPDServices;

import java.util.List;

import com.OPD_Managemnet_System.OPDEntitys.Visit_Report;

public interface Visit_Report_Service {

	Visit_Report save(Visit_Report visit_report);
	
	List<Visit_Report> GetAllVisit_Report();
	
	Visit_Report GetAllVisit_ReportByid(int id);
	
	void deleteById(int id);
}
