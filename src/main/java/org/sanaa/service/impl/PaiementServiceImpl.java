package org.sanaa.service.impl;

import org.sanaa.dao.PaiementRepository;
import org.sanaa.model.Paiement;
import org.sanaa.service.IPaiementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PaiementServiceImpl implements  IPaiementService {
	@Autowired
     PaiementRepository paiementRepository;
	@Override
	public Paiement addPaiement(Paiement paiement) {
		
		return paiementRepository.save(paiement);
	}
	@Override
	public Paiement getPaiement(int id) {
		
		return paiementRepository.findById(id).get();
	}

}
