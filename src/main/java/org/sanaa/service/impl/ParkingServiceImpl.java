package org.sanaa.service.impl;

import java.util.List;

import org.sanaa.dao.ParkingRepoqitory;
import org.sanaa.model.Parking;
import org.sanaa.service.IParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class ParkingServiceImpl  implements IParkingService{
     @Autowired
     ParkingRepoqitory parkingRepoqitory;
	@Override
	public Parking ajouterParking(Parking parking) {
		
		return parkingRepoqitory.save(parking);
	}

	@Override
	public Parking modifierParking(Parking parking) {
		
		return parkingRepoqitory.save(parking);
		}

	@Override
	public void supprimerParking(Parking parking) {
		parkingRepoqitory.delete(parking);
	}

	@Override
	public Parking findById(int id) {
		return parkingRepoqitory.findById(id).get();
	}

	@Override
	public List<Parking> findAll() {
		return parkingRepoqitory.findAll();
	}

}
