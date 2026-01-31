package com.OPD_Managemnet_System.OPD_Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.OPD_Managemnet_System.OPDEntitys.Admin;
import com.OPD_Managemnet_System.OPDEntitys.Role;
import com.OPD_Managemnet_System.OPDServices.Admin_Service;
import com.OPD_Managemnet_System.OPD_DTOs.Admin_DTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/admin")
public class Admin_Controller {

	@Autowired
	private Admin_Service admin_Service;
	@Autowired
	private PasswordEncoder encoder;
	@PostMapping("/register")
	public ResponseEntity<Admin> saveAdminRecord(@Valid @RequestBody Admin_DTO admin_DTO) {

		Admin admin = new Admin();

		admin.setName(admin_DTO.getName());
		admin.setEmail(admin_DTO.getEmail());
		admin.setCreate_at(admin_DTO.getCreate_at());
		admin.setMobileNo(admin_DTO.getMobileNo());
		admin.setPassword(encoder.encode(admin_DTO.getPassword()));
		admin.setUpdatet_at(admin_DTO.getUpdatet_at());
		admin.setRole(Role.ADMIN);
		Admin saveAdmin = admin_Service.saveAdmin(admin);
		return new ResponseEntity<>(saveAdmin, HttpStatus.OK);
	}

	@GetMapping("/")
	public ResponseEntity<List<Admin>> getAllAdminRecords() {

		List<Admin> admin = admin_Service.getAllAdmin();

		if (admin == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(admin, HttpStatus.FOUND);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Admin> getAdminRecordById(@PathVariable("id") int id) {

		Admin admin = admin_Service.getadminById(id);

		if (admin == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Admin>(admin, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Admin> updateAdminRecords(@PathVariable("id") int id,@Valid @RequestBody Admin_DTO admin_DTO) {
		Admin admin = admin_Service.getadminById(id);

		if (admin == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		admin.setName(admin_DTO.getName());
		admin.setEmail(admin_DTO.getEmail());
	
		admin.setMobileNo(admin_DTO.getMobileNo());
		admin.setPassword(admin_DTO.getPassword());
		admin.setUpdatet_at(admin_DTO.getUpdatet_at());

		Admin saveAdmin = admin_Service.saveAdmin(admin);
		return new ResponseEntity<>(saveAdmin, HttpStatus.CREATED);

	}
		@DeleteMapping("/{id}")
		public ResponseEntity<Void> updateAdminRecords(@PathVariable("id") int id) {
			
			Admin admin=admin_Service.getadminById(id);
			if(admin==null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			admin_Service.deleteAdminById(id);
			return new ResponseEntity<Void>(HttpStatus.MOVED_PERMANENTLY); 
		}
		
}