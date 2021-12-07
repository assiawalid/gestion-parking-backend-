package org.sanaa.service;

import java.util.List;

import org.sanaa.model.Offre;

public interface IOfrreService {
	public Offre ajouterOffre(Offre offre) ;
	public Offre modifierOffre(Offre offre);
	public void supprimerOffre(Offre offre);
	public Offre findById(int id);
	public List<Offre> findAll();
}
