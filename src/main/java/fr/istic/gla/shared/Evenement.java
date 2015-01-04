package fr.istic.gla.shared;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="EVENEMENT")
public class Evenement {

	private int id;
	public String lieu;
	public Date date;
	public Collection<Voiture> voiture;
	
	@Id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@ManyToMany
	@JoinTable(
			name="EVE_VOIT",
			joinColumns=@JoinColumn(name="idEvent"),
			inverseJoinColumns=
			@JoinColumn(name="idVoit")
		)
	public Collection<Voiture> getVoiture() {
		return voiture;
	}
	public void setVoiture(Collection<Voiture> voiture) {
		this.voiture = voiture;
	}
}
