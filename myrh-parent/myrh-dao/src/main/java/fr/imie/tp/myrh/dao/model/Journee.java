package fr.imie.tp.myrh.dao.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_JOURNEE")

public class Journee implements Serializable {

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@OneToOne
	private Employe employe;
	
	@OneToOne
	private Projet projet;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DATE")
	private Date date;
	

	@Column(name="DUREE")
	private int durée;
	
	@Column(name="COMMENTAIRE")
	private String Commentaire;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getDurée() {
		return durée;
	}

	public void setDurée(int durée) {
		this.durée = durée;
	}

	public String getCommentaire() {
		return Commentaire;
	}

	public void setCommentaire(String commentaire) {
		Commentaire = commentaire;
	}
	
	
}
