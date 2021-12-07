package org.sanaa.dao;

import org.sanaa.model.Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface FactureRepository extends JpaRepository<Facture, Integer> {

}
