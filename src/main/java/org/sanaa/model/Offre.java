package org.sanaa.model;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Offre {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int id;
	private String libelle;
	private String Description;
	private Date dateDebut;
	private Date dateFin;
	private double tarif;
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="parking_id")
	private Parking parking;
	
	
	@OneToMany(mappedBy = "offre")
	private Collection<Service> services;
	
	
	@OneToMany(mappedBy = "offre")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Collection<Reservation> reservation;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getLibelle() {
		return libelle;
	}


	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


	public String getDescription() {
		return Description;
	}


	public void setDescription(String description) {
		Description = description;
	}


	public Date getDateDebut() {
		return dateDebut;
	}


	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}


	public Date getDateFin() {
		return dateFin;
	}


	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}


	public double getTarif() {
		return tarif;
	}


	public void setTarif(double tarif) {
		this.tarif = tarif;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Parking getParking() {
		return parking;
	}


	public void setParking(Parking parking) {
		this.parking = parking;
	}


	public Collection<Service> getServices() {
		return services;
	}


	public void setServices(Collection<Service> services) {
		this.services = services;
	}


	public Collection<Reservation> getReservation() {
		return reservation;
	}


	public void setReservation(Collection<Reservation> reservation) {
		this.reservation = reservation;
	}
	
	
	

}
