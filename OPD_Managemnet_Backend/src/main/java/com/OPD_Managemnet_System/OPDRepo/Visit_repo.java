package com.OPD_Managemnet_System.OPDRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.OPD_Managemnet_System.OPDEntitys.Visit;

@Repository // access jpa method 
public interface Visit_repo extends JpaRepository<Visit, Integer> {

}
