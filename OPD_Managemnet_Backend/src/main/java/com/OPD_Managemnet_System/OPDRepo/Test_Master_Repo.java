package com.OPD_Managemnet_System.OPDRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.OPD_Managemnet_System.OPDEntitys.Test_Master;

@Repository
public interface Test_Master_Repo extends JpaRepository<Test_Master, Integer> {

}
