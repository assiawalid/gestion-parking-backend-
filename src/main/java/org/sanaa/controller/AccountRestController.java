package org.sanaa.controller;

import org.sanaa.model.User;
import org.sanaa.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AccountRestController {
	@Autowired
	private AccountService accountService;
	
	
	@PostMapping("/registrer")
	public User registrer(@RequestBody RegistreForm registreForm) {
		if(!registreForm.getRepassword().equals(registreForm.getRepassword()))
		throw new RuntimeException("you must confirm your password");
		User us=accountService.findUserByUserName(registreForm.getUsername());	
	     if(us!=null) 
	    	throw new RuntimeException("this user already exist") ;
	    
		
		User user=new User();
		user.setUsername(registreForm.getUsername());
		user.setPassword(registreForm.getPassword());
	    accountService.save(user);
	    accountService.addRoleToUser(registreForm.getUsername(),"USER");
	    return user;
	}
}
