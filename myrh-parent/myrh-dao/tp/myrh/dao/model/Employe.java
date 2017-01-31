package fr.imie.tp.myrh.dao.model;

import java.io.Serializable;
import java.sql.Date;
@entity
public class Employe implements Serializable{
	
	@id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String nom;
	private String prenom;
	private Date datenaiss;
	private String securiteSoc;
	private Double salaire;
	private Date dateEmbauche;
	private Date dateFinEmbauche;
	

}
