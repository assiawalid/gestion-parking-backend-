package org.sanaa.controller;

import org.sanaa.model.Paiement;
import org.sanaa.service.impl.PaiementServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paiements")
@CrossOrigin("*")
public class PaiementController {
	@Autowired
	PaiementServiceImpl paiementServiceImpl;
	@PostMapping
	public @ResponseBody Paiement addPaiment(@RequestBody Paiement p) {
		System.out.println("paiement  avec succé");
		
		return paiementServiceImpl.addPaiement(p);
	}
	@GetMapping
	public Paiement getPaiement(int id) {
		return paiementServiceImpl.getPaiement(id);
		
	}

}
