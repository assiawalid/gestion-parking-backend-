package org.sanaa.dao;

import org.sanaa.model.Parking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ParkingRepoqitory extends JpaRepository<Parking, Integer> {

}
