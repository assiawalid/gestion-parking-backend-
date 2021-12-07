package org.sanaa.model;

import java.util.Collection;

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
public class Parking {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int nombrePlace;
	private double distanceAer;
	private String photo;
	@OneToMany(mappedBy = "parking")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Collection<Offre> offres;
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNombrePlace() {
		return nombrePlace;
	}
	public void setNombrePlace(int nombrePlace) {
		this.nombrePlace = nombrePlace;
	}
	public double getDistanceAer() {
		return distanceAer;
	}
	public void setDistanceAer(double distanceAer) {
		this.distanceAer = distanceAer;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Collection<Offre> getOffres() {
		return offres;
	}
	public void setOffres(Collection<Offre> offres) {
		this.offres = offres;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	

}
