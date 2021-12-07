package org.sanaa.controller;

import java.util.List;

import org.sanaa.dao.ServiceRepository;
import org.sanaa.model.Offre;
import org.sanaa.service.IOfrreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/offres")
@CrossOrigin("*")
public class OffreController {
	@Autowired
	IOfrreService ofrreService;
	@Autowired ServiceRepository serviceRepository;

	@PostMapping
	public Offre add(@RequestBody Offre offre) {
		return ofrreService.ajouterOffre(offre);

	}

	@PutMapping
	public Offre update(@RequestBody Offre offre) {
		return ofrreService.modifierOffre(offre);
	}

	@DeleteMapping
	public void delete(@RequestBody Offre offre) {
		ofrreService.supprimerOffre(offre);
	}

	@GetMapping
	public List<Offre> getAll() {
		return ofrreService.findAll();
	}
	
	@GetMapping("/{id}")
	public Offre getOne(@PathVariable("id")int id) {		
		return ofrreService.findById(id);
		
	}
}
