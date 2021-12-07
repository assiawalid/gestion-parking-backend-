package org.sanaa.service;

import java.util.List;

import org.sanaa.model.Reservation;

public interface IReservationService {
	public Reservation add(Reservation res);
	public Reservation update(Reservation res);
	public void delete(Reservation res);
	public Reservation getRes(int id);
	public List<Reservation> getAll();
}
