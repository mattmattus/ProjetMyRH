package fr.imie.tp.myrh.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.imie.tp.myrh.dao.model.Employe;
import fr.imie.tp.myrh.dao.model.HistoriqueDemande;

public class HistoriqueDemandeJPATest {
	
	public static void main(String[] args){
		
		//Utilitaire Date
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		//Creation d'une unité de travail
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myRhPersistenceUnit");
		EntityManager em = emf.createEntityManager();
		
		//Requete1: Insetion d'un historique de demande
		System.out.println("\nRequete1: CREATION d'un historique de demande");
		EntityTransaction trx= em.getTransaction();
		trx.begin();
		
		HistoriqueDemande histEntity= new HistoriqueDemande();
		Employe E1 = em.find(Employe.class, 1);
		histEntity.setEmploye(E1);
		
		
		try {
			histEntity.setDate(sdf.parse("25/02/2017"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		histEntity.setCommentaire("Congé accepté");
		
		
		em.persist(histEntity);
		System.out.println("Le congé enregistré avec l'id "+histEntity.getId());
		trx.commit();		
		
	}

}
