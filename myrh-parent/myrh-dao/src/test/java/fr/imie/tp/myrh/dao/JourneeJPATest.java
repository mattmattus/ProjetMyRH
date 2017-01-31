package fr.imie.tp.myrh.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.imie.tp.myrh.dao.model.Employe;
import fr.imie.tp.myrh.dao.model.Journee;
import fr.imie.tp.myrh.dao.model.Projet;

public class JourneeJPATest {
	
	public static void main(String[] args){
		
		//Utilitaire Date
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		//Creation d'une unité de travail
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myRhPersistenceUnit");
		EntityManager em = emf.createEntityManager();
		
		//Requete1: Insetion d'un journee
		System.out.println("\nRequete1: CREATION D'une journee");
		EntityTransaction trx= em.getTransaction();
		trx.begin();
		
		Journee jrnEntity= new Journee();
		Employe E1 = em.find(Employe.class, 1);
		jrnEntity.setEmploye(E1);
		
		Projet P1 = em.find(Projet.class, 1);
		jrnEntity.setProjet(P1);
		
		jrnEntity.setDurée(20);
		try {
			jrnEntity.setDate(sdf.parse("31/01/2017"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jrnEntity.setCommentaire("recapitutatif de la journée");
		
		em.persist(jrnEntity);
		System.out.println("La journee enregistré avec l'id "+jrnEntity.getId());
		trx.commit();		
		
	}

}
