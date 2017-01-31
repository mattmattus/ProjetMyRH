package fr.imie.tp.myrh.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.imie.tp.myrh.dao.model.Projet;

public class ProjetJPATest {
	
	public static void main(String[] args){
		
		//Utilitaire Date
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		//Creation d'une unité de travail
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myRhPersistenceUnit");
		EntityManager em = emf.createEntityManager();
		
		//Requete1: Insetion d'un projet
		System.out.println("\nRequete1: CREATION D'UN projet");
		EntityTransaction trx= em.getTransaction();
		trx.begin();
		
		Projet proEntity= new Projet();
		proEntity.setCode("PRJ000");
		proEntity.setDescription("Ceci est le premier projet");
		try {
			proEntity.setDateDebut(sdf.parse("31/01/2017"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			proEntity.setDateDebut(sdf.parse("25/02/2017"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		em.persist(proEntity);
		System.out.println("Le projet enregistré avec l'id "+proEntity.getId());
		trx.commit();		
		
	}

}
