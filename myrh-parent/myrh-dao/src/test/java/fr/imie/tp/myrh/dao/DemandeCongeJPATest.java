package fr.imie.tp.myrh.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.imie.tp.myrh.dao.model.DemandeConge;
import fr.imie.tp.myrh.dao.model.Employe;

public class DemandeCongeJPATest {
	
	public static void main(String[] args){
		
		//Utilitaire Date
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		//Creation d'une unité de travail
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myRhPersistenceUnit");
		EntityManager em = emf.createEntityManager();
		
		//Requete1: Insetion d'une demande de congé
		System.out.println("\nRequete1: CREATION d'une demande de congé");
		EntityTransaction trx= em.getTransaction();
		trx.begin();
		
		DemandeConge demcongEntity= new DemandeConge();
		Employe E1 = em.find(Employe.class, 1);
		demcongEntity.setEmploye(E1);
		
		
		try {
			demcongEntity.setDateDemande(sdf.parse("31/01/2017"));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			demcongEntity.setDatedebut(sdf.parse("31/01/2017"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			demcongEntity.setDateFin(sdf.parse("25/02/2017"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		demcongEntity.setMotif("Vacances");
		demcongEntity.setMotif("Accepté");
		demcongEntity.setNbJours(5);
		
		em.persist(demcongEntity);
		System.out.println("Le congé enregistré avec l'id "+demcongEntity.getId());
		trx.commit();		
		
	}

}
