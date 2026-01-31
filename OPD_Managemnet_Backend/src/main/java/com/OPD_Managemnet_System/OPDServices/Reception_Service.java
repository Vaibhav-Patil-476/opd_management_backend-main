package com.OPD_Managemnet_System.OPDServices;

import java.util.List;

import com.OPD_Managemnet_System.OPDEntitys.Reception;

//Business logic
public interface Reception_Service {

	//Abstract Method for save Reception
	Reception save(Reception reception);
	
	//Abstract Method for get list of Reception
	List<Reception> getallReception();
	
	//Abstract Method for get Reception by id
	Reception getReceptionById(int id);
	
	//Abstract Method for delete Reception 
	void  deleteReceptionById(int id);
	
}
