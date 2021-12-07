package org.sanaa.service.impl;

import java.util.List;

import org.sanaa.dao.ReservationRepository;
import org.sanaa.model.Reservation;
import org.sanaa.service.IReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ReservationServiceImp implements IReservationService {
	@Autowired
	ReservationRepository reservationRepository;

	@Override
	public Reservation add(Reservation res) {
		return reservationRepository.save(res);
	}

	@Override
	public Reservation update(Reservation res) {
		
		return reservationRepository.save(res);
	}

	@Override
	public void delete(Reservation res) {
		reservationRepository.delete(res);
		
	}

	@Override
	public Reservation getRes(int id) {
		return reservationRepository.findById(id).get();
	}

	@Override
	public List<Reservation> getAll() {
		return reservationRepository.findAll();
	}

}
