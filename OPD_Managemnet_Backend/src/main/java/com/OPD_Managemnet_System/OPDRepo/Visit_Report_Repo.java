package com.OPD_Managemnet_System.OPDRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.OPD_Managemnet_System.OPDEntitys.Visit_Report;

@Repository
public interface Visit_Report_Repo extends JpaRepository<Visit_Report, Integer> {

}
