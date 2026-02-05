package com.OPD_Managemnet_System.OPDRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.OPD_Managemnet_System.OPDEntitys.Medicine;

@Repository // access jpa method 
public interface Medicine_Repo extends JpaRepository<Medicine, Integer> {

}
