package com.OPD_Managemnet_System.OPDRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.OPD_Managemnet_System.OPDEntitys.Pathology_Test;

@Repository
public interface Pathology_Test_Repo extends JpaRepository<Pathology_Test, Integer> {

}
