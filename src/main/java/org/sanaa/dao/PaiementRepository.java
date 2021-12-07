package org.sanaa.dao;

import org.sanaa.model.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PaiementRepository extends JpaRepository<Paiement, Integer> {

}
