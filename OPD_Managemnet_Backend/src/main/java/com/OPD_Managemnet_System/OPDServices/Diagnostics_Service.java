package com.OPD_Managemnet_System.OPDServices;

import java.util.List;

import org.springframework.stereotype.Service;

import com.OPD_Managemnet_System.OPDEntitys.Diagnostics;

@Service
public interface Diagnostics_Service {

	//Abstract Method for save Diagnostics 
	Diagnostics saveDiagnostics(Diagnostics diagnostics );
	
	//Abstract Method for get all Diagnostics  
	List<Diagnostics> getAllDiagnostics();
	
	//Abstract Method for get by  Diagnostics id 
	Diagnostics getByDiagnosticsID(int id);
	
	//Abstract Method for delete by Diagnostics id 
	void deleteById(int id);
}
