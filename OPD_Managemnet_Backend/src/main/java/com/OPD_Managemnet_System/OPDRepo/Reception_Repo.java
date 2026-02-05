package com.OPD_Managemnet_System.OPDRepo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.OPD_Managemnet_System.OPDEntitys.Reception;

//reception repo extends with JPA Repositry for make logic with database 
@Repository // access jpa method 
public interface Reception_Repo extends JpaRepository<Reception, Integer> {

	 Optional<Reception> findByEmail(String email);

	    // Check if Doctor exists by Email
	    Boolean existsByEmail(String email);
}
