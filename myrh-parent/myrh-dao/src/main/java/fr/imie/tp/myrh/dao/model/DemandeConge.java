package fr.imie.tp.myrh.dao.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_DEMANDECONGE")
public class DemandeConge implements Serializable{
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private long id;
	
	@Temporal(TemporalType.DATE)
	@Column(name="CODE")
	private Date dateDemande;
	
	@Temporal(TemporalType.DATE)
	@Column(name="NAME")
	private Date datedebut;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DATEFIN")
	private Date dateFin;
	
	@Column(name="MOTIF")
	private String motif;
	
	@Column(name="STATUT")
	private String statut;
	
	@Column(name="NBJOURS")
	private int NbJours;

	
	@OneToOne
	private Employe employe;

	
	
	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDateDemande() {
		return dateDemande;
	}

	public void setDateDemande(Date dateDemande) {
		this.dateDemande = dateDemande;
	}

	public Date getDatedebut() {
		return datedebut;
	}

	public void setDatedebut(Date datedebut) {
		this.datedebut = datedebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public int getNbJours() {
		return NbJours;
	}

	public void setNbJours(int nbJours) {
		NbJours = nbJours;
	}
	
	
	
	
}