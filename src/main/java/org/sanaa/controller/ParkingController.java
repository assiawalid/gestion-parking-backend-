package org.sanaa.controller;

import java.util.List;

import org.sanaa.model.Parking;
import org.sanaa.service.IParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/parkings")
public class ParkingController {
    @Autowired
    IParkingService iParkingService;
    
    
    @PostMapping("/addParking")
	public Parking add(@RequestBody Parking parking) {
		return iParkingService.ajouterParking(parking);
		
	}
	@PutMapping("/updateParking")
     public Parking update(@RequestBody Parking parking) {
    	 return iParkingService.modifierParking(parking);
     }
	@DeleteMapping("/suppParking")
	public void delete(@PathVariable Parking parking) {
		iParkingService.supprimerParking(parking);
	}
	@GetMapping("/getParking")
	public List<Parking> getAll(){
		return iParkingService.findAll();
	}

}
