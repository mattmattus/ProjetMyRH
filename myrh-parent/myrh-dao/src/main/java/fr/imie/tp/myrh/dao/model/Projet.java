package fr.imie.tp.myrh.dao.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_PROJET")

public class Projet implements Serializable {

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	
	@Column(name="CODE")
	private String code;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DATEDEBUT")
	private Date dateDebut;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DATEFIN")
	private Date dateFin;

	
	@OneToMany(mappedBy="projet")
	private List<Journee> journees;



	public List<Journee> getJournees() {
		return journees;
	}

	public void setJournees(List<Journee> journees) {
		this.journees = journees;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
	
	
	
}
