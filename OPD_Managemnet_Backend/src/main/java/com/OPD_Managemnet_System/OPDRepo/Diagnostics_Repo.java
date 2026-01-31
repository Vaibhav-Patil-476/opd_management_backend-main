package com.OPD_Managemnet_System.OPDRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.OPD_Managemnet_System.OPDEntitys.Diagnostics;

//Extends repository for use Hibernate methods
public interface Diagnostics_Repo extends JpaRepository<Diagnostics, Integer> {

}
