package org.sanaa.service.impl;

import java.util.List;

import org.sanaa.dao.OffreRepository;
import org.sanaa.model.Offre;
import org.sanaa.service.IOfrreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class OfrreServiceImp implements IOfrreService {
     @Autowired
     OffreRepository offreRepository;
	@Override
	public Offre ajouterOffre(Offre offre) {
		return offreRepository.save(offre);
	}

	@Override
	public Offre modifierOffre(Offre offre) {
		return offreRepository.save(offre);
	}

	@Override
	public void supprimerOffre(Offre offre) {
	offreRepository.delete(offre);
	}

	@Override
	public Offre findById(int id) {
		return offreRepository.findById(id).get();
	}

	@Override
	public List<Offre> findAll() {
		return offreRepository.findAll();
	}

}
