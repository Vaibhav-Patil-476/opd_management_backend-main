package com.OPD_Managemnet_System.OPDRepo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.OPD_Managemnet_System.OPDEntitys.Doctor;

@Repository // access jpa method 
public interface Doctor_Repo extends JpaRepository<Doctor, Integer> {
	
	//optional method for find doctor email
    Optional<Doctor> findByEmail(String email);

    // Check if Doctor exists by Email
    Boolean existsByEmail(String email);
}
