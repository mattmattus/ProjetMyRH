package fr.imie.tp.myrh.dao;

import java.text.SimpleDateFormat;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.imie.tp.myrh.dao.model.Departement;

public class DepartementJPATest {
	
	public static void main(String[] args){
		
		//Utilitaire Date
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		//Creation d'une unité de travail
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myRhPersistenceUnit");
		EntityManager em = emf.createEntityManager();
		
		//Requete1: Insetion d'un departement
		System.out.println("\nRequete1: CREATION D'UN departement");
		EntityTransaction trx= em.getTransaction();
		trx.begin();
		
		Departement empEntity= new Departement();
		empEntity.setCode("49");
		empEntity.setName("MAINE ET LOIRE");
		empEntity.setDescription("C'est cool ici");
		
		em.persist(empEntity);
		System.out.println("Le departement enregistré avec l'id "+empEntity.getId());
		trx.commit();		
		
	}

}
