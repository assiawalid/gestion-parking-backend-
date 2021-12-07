package org.sanaa.controller;

import java.util.List;

import org.sanaa.model.Role;
import org.sanaa.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class RoleController {
	@Autowired
	IRoleService iRoleService;
	
	 @PostMapping("/addRole")
		public Role add(@RequestBody Role parking) {
			return iRoleService.ajouterRole(parking);
			
		}
		@PutMapping("/updateRole")
	     public Role update(@RequestBody Role role) {
	    	 return iRoleService.modifierRole(role);
	     }
		@DeleteMapping("/suppRole")
		public void delete(@PathVariable Role role) {
			iRoleService.supprimerRole(role);
		}
		@GetMapping("/getRole")
		public List<Role> getAll(){
			return iRoleService.findAll();
		}

}
