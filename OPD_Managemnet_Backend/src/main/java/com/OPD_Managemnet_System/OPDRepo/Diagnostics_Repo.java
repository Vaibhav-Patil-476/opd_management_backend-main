package com.OPD_Managemnet_System.OPDRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.OPD_Managemnet_System.OPDEntitys.Diagnostics;


@Repository // access jpa method 
public interface Diagnostics_Repo extends JpaRepository<Diagnostics, Integer> {

}
