package fr.imie.tp.myrh.dao.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_EMPLOYE")
public class Employe implements Serializable {

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="FNAME")
	private String nom;
	
	@Column(name="LNAME")
	private String prenom;
	
	@Temporal(TemporalType.DATE)
	@Column(name="BIRTHDATE")
	private Date datenaiss;
	
	@Column(name="NSS")
	private String securiteSoc;
	
	@Column(name="SALARY")
	private Double salaire;
	
	@Temporal(TemporalType.DATE)
	@Column(name="ARRIVAL_DATE")
	private Date dateEmbauche;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DEPARTURE_DATE")
	private Date dateFinEmbauche;
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDatenaiss() {
		return datenaiss;
	}

	public void setDatenaiss(Date datenaiss) {
		this.datenaiss = datenaiss;
	}

	public String getSecuriteSoc() {
		return securiteSoc;
	}

	public void setSecuriteSoc(String securiteSoc) {
		this.securiteSoc = securiteSoc;
	}

	public Double getSalaire() {
		return salaire;
	}

	public void setSalaire(Double salaire) {
		this.salaire = salaire;
	}

	public Date getDateEmbauche() {
		return dateEmbauche;
	}

	public void setDateEmbauche(Date dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}

	public Date getDateFinEmbauche() {
		return dateFinEmbauche;
	}

	public void setDateFinEmbauche(Date dateFinEmbauche) {
		this.dateFinEmbauche = dateFinEmbauche;
	}

	
}
