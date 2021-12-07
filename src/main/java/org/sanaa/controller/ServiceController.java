package org.sanaa.controller;

import java.util.List;

import org.sanaa.model.Service;
import org.sanaa.service.IServiceService;
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
@RequestMapping("/ser")
@CrossOrigin("*")
public class ServiceController {
	@Autowired
    IServiceService serviceService;

    
    @PostMapping
	public Service add(@RequestBody Service service) {
		return serviceService.addService(service);
		
	}
	@PutMapping
     public Service update(@RequestBody Service service) {
    	 return serviceService.updateService(service);
     }
	@DeleteMapping
	public void delete(@PathVariable Service service) {
		serviceService.deleteService(service);
	}
	@GetMapping
	public List<Service> getAll(){
		return serviceService.getAllService();
	}
	@GetMapping("/{id}")
   public Service getOne(@PathVariable("id") int id) {
		
	   return serviceService.getService(id);
   }
	public List<Service> getServices(int idOfrre){
		
		return null;
	}
}
