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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_EMPLOYE")


@NamedQueries({
@NamedQuery(name="Employe.findAll", query="SELECT e FROM Employe e"),
@NamedQuery(name="Employe.findByID", query="SELECT e FROM Employe e WHERE e.id= :idVar"),
@NamedQuery(name="Employe.findByNom", query="SELECT e FROM Employe e WHERE e.nom= :nomVar"),
@NamedQuery(name="Employe.findBySal", query="SELECT e FROM Employe e WHERE e.salaire > :salVar"),
//@NamedQuery(name="Employe.add", query="INSERT INTO Employe(ARRIVAL_DATE, DEPARTURE_DATE, BIRTHDATE, FNAME, LNAME, SALARY, NSS) VALUES(:dateArrVar, :DateDepVar, :datenaissVar, :prenomVar, :nomVar, :salaireVar, :securitesocVar)")
//@NamedQuery(name="Employe.UpdateDFE", query="UPDATE e.dateFinEmbauche :dateFinEmb FROM Employe WHERE e.id= idVar")
})


public class Employe implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	

	@Override
	public String toString() {
		return nom + " " + prenom;
	}

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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
	
	@ManyToOne
	private DemandeConge demandeConge;
	
	public DemandeConge getDemandeConge() {
		return demandeConge;
	}

	public void setDemandeConge(DemandeConge demandeConge) {
		this.demandeConge = demandeConge;
	}
	
	@OneToOne
	private HistoriqueDemande historiqueDemande;

	@ManyToOne
	private Departement departement;

	public List<Journee> getJournees() {
		return journees;
	}

	public void setJournees(List<Journee> journees) {
		this.journees = journees;
	}

	@OneToMany(mappedBy="employe")
	private List<Journee> journees;
	
	
	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

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
