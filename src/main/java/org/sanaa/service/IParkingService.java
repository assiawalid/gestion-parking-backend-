package org.sanaa.service;

import java.util.List;

import org.sanaa.model.Parking;

public interface IParkingService {
	public Parking ajouterParking(Parking parking);
	public Parking modifierParking(Parking parking);
	public void supprimerParking(Parking parking);
	public Parking findById(int id);
	public List<Parking> findAll();

}
