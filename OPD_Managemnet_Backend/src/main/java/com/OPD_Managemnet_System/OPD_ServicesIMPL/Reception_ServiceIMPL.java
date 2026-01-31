package com.OPD_Managemnet_System.OPD_ServicesIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OPD_Managemnet_System.ExceptionHandling.DatabaseException;
import com.OPD_Managemnet_System.ExceptionHandling.ResourceNotFoundException;
import com.OPD_Managemnet_System.OPDEntitys.Reception;
import com.OPD_Managemnet_System.OPDRepo.Reception_Repo;
import com.OPD_Managemnet_System.OPDServices.Reception_Service;

//Business Logic implements
@Service
public class Reception_ServiceIMPL implements Reception_Service {

	//Create object of Reception Repositry 
	@Autowired
	private Reception_Repo reception_Repo;
	
	//Save New Reception Data
	@Override
	public Reception save(Reception reception) {
		try {
			return reception_Repo.save(reception);
		} catch (Exception e) {
			System.out.println("Password: " + reception.getPassword());
			System.out.println("Doctor: " + reception.getDoctorid());
			System.out.println("Email: " + reception.getEmail());

			throw new DatabaseException("Internal server Error...!");
		}
		
	}

	//Get All Reception 
	@Override
	public List<Reception> getallReception() {
		try {
			return reception_Repo.findAll() ;
		} catch (Exception e) {
			throw new ResourceNotFoundException("Reception list exist.....!");
		}
		
	}

	//Get Reception Data By id 
	@Override
	public Reception getReceptionById(int id) {
		return reception_Repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Reception not  exist by this id.....!"+id));
	}

	//Delete Reception method By id
	@Override
	public void deleteReceptionById(int id) {
		try {
			reception_Repo.deleteById(id);
		} catch (Exception e) {
			throw new ResourceNotFoundException("Reception not  exist by this id.....!"+id);
		}
		
	}

}
