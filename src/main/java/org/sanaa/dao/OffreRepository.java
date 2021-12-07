package org.sanaa.dao;

import org.sanaa.model.Offre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface OffreRepository extends JpaRepository<Offre, Integer> {

}
