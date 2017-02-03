package fr.imie.tp.myrh.ui.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean(name="employeForm")
public class EmployeForm {
	private String nom;
	private String prenom;
	private String datenaiss;
	private String securiteSoc;
	private double Salaire;
	private String dateEmbauche;
	private String dateFinEmbauche;
	
	
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
	public String getDatenaiss() {
		return datenaiss;
	}
	public void setDatenaiss(String datenaiss) {
		this.datenaiss = datenaiss;
	}
	public String getSecuriteSoc() {
		return securiteSoc;
	}
	public void setSecuriteSoc(String securiteSoc) {
		this.securiteSoc = securiteSoc;
	}
	public double getSalaire() {
		return Salaire;
	}
	public void setSalaire(double salaire) {
		Salaire = salaire;
	}
	public String getDateEmbauche() {
		return dateEmbauche;
	}
	public void setDateEmbauche(String dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}
	public String getDateFinEmbauche() {
		return dateFinEmbauche;
	}
	public void setDateFinEmbauche(String dateFinEmbauche) {
		this.dateFinEmbauche = dateFinEmbauche;
	}
	


}
