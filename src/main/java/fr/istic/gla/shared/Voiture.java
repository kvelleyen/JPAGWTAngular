package fr.istic.gla.shared;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="VOITURE")
public class Voiture {
	
	public int id;
	public int nb_places;
	public Collection<Evenement> evenement;
	public Personne chauffeur;
	public Collection<Personne> passagers;
	
	public Voiture(int nb){
		nb_places = nb;
	}
	
	@Id
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNb_places() {
		return nb_places;
	}

	public void setNb_places(int nb_places) {
		this.nb_places = nb_places;
	}
	
	@ManyToMany(mappedBy="voiture")
	public Collection<Evenement> getEvenement() {
		return evenement;
	}

	public void setEvenement(Collection<Evenement> evenement) {
		this.evenement = evenement;
	}

	@ManyToOne
	public Personne getChauffeur() {
		return chauffeur;
	}

	public void setChauffeur(Personne chauffeur) {
		this.chauffeur = chauffeur;
	}
	
	@ManyToMany(mappedBy="passengerOf")
	public Collection<Personne> getPassagers() {
		return passagers;
	}

	public void setPassagers(Collection<Personne> passagers) {
		this.passagers = passagers;
	}
	
	
}
