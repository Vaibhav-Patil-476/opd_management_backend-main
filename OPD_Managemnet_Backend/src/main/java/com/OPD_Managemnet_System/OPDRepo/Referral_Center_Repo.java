package com.OPD_Managemnet_System.OPDRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.OPD_Managemnet_System.OPDEntitys.Referral_Center;

@Repository // access jpa method 
public interface Referral_Center_Repo extends JpaRepository<Referral_Center, Integer> {

}
