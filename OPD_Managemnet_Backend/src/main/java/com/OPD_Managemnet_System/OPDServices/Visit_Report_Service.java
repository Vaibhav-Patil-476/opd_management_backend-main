package com.OPD_Managemnet_System.OPDServices;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;
import com.OPD_Managemnet_System.OPDEntitys.Visit_Report;


public interface Visit_Report_Service {

	Visit_Report save(Visit_Report visit_report); //user defined method for save data
	
	List<Visit_Report> GetAllVisit_Report();//user defined method for show list of doctor data
	
	Visit_Report GetAllVisit_ReportByid(int id);//user defined method for show doctor data by there id
	
	void deleteById(int id);//user defined method for delete doctor data by there id
	
	
}