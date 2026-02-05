package com.OPD_Managemnet_System.OPDRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.OPD_Managemnet_System.OPDEntitys.Referral;

@Repository // access jpa method 
public interface Referral_Repo extends JpaRepository<Referral, Integer>{

}
