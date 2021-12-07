package org.sanaa.service;

import org.sanaa.model.Paiement;

public interface IPaiementService {
	public Paiement addPaiement(Paiement paiement);
	public Paiement getPaiement(int id);

}
