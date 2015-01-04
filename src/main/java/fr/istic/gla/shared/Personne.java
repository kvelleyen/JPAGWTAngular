package fr.istic.gla.shared;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="PERSONNE")
public class Personne {

	private int id;
	public Collection<Voiture> driverOf;
	public Collection<Voiture> passengerOf;
	public String name;
	
	public Personne(String name) {
		this.name = name;
	}
	
	@Id
	@GeneratedValue()
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	@OneToMany(mappedBy="chauffeur")
	public Collection<Voiture> getDriverOf() {
		return driverOf;
	}

	public void setDriverOf(Collection<Voiture> driverOf) {
		this.driverOf = driverOf;
	}

	@ManyToMany
	@JoinTable(
			name="PASSENGER_VOITURE",
			joinColumns=@JoinColumn(name="idPassenger"),
			inverseJoinColumns=
			@JoinColumn(name="idVoiture")
		)
	public Collection<Voiture> getPassengerOf() {
		return passengerOf;
	}

	public void setPassengerOf(Collection<Voiture> passengerOf) {
		this.passengerOf = passengerOf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}