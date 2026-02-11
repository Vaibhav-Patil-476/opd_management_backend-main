package com.OPD_Managemnet_System.OPDRepo;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.OPD_Managemnet_System.OPDEntitys.Visit;
import com.OPD_Managemnet_System.OPDEntitys.Visit_Report;

@Repository // access jpa method 
public interface Visit_Report_Repo extends JpaRepository<Visit_Report, Integer> {

//	 Visit_Report findByVisitid_Id(long visitId);
	 
	 List<Visit_Report> findByVisitid_Id(Long visitId);
	 
	
		
}
