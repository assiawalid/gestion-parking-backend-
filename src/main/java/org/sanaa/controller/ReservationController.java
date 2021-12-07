package org.sanaa.controller;

import java.util.List;

import org.sanaa.model.Reservation;
import org.sanaa.service.IReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservations")
@CrossOrigin("*")
public class ReservationController {
	@Autowired
	IReservationService reservationService;

	@PostMapping
	
	public @ResponseBody Reservation add(@RequestBody Reservation res) {
		
     	return reservationService.add(res);
}

	@PutMapping
	public Reservation update(@RequestBody Reservation res) {
		return reservationService.update(res);
	}

	@DeleteMapping
	public void delete(@RequestBody Reservation res) {
		reservationService.delete(res);
		;
	}

	@GetMapping("/{id}")
	public Reservation getReservation(@PathVariable("id") int id) {
		System.out.println("getRes");
		return reservationService.getRes(id);
	}

	@GetMapping()
	public List<Reservation> getAll() {
		return reservationService.getAll();
	}

}