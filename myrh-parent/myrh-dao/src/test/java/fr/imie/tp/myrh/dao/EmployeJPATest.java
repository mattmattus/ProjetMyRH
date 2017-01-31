package fr.imie.tp.myrh.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import fr.imie.tp.myrh.dao.model.Employe;

public class EmployeJPATest {
	
	public static void main(String[] args){
		
		//Utilitaire Date
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		//Creation d'une unité de travail
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myRhPersistenceUnit");
		EntityManager em = emf.createEntityManager();
		
//		//Requete1: Insetion d'un employe
//		System.out.println("\nRequete1: CREATION D'UN EMPLOYE");
//		EntityTransaction trx= em.getTransaction();
//		trx.begin();
//		
//		Employe empEntity= new Employe();
//		empEntity.setPrenom("Antoine");
//		empEntity.setNom("Griezmann");
//		empEntity.setSecuriteSoc("1234567890");
//		try {
//			empEntity.setDatenaiss(sdf.parse("21/03/1991"));
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		em.persist(empEntity);
//		System.out.println("Utilisateur enregistré avec l'id "+empEntity.getId());
//		trx.commit();
		
		
		//Requete2: L'employe avec l'id 1
		System.out.println("\nRequete2: Employe avec l'id 1");
		
		//1 affiche le prenom
		Employe emp2= em.find(Employe.class, 1l);		
		System.out.println(emp2.getPrenom());
		
		
		//2 affiche le nom
		TypedQuery<Employe> query2 = em.createNamedQuery("Employe.findByID", Employe.class);
		query2.setParameter("idVar", 1l);
		Employe emp3 = query2.getSingleResult();
		System.out.println(emp3.getNom());
		
		
		
		//Requete3: Liste des employes
		System.out.println("\nRequete3: LISTE DES Employés");
		
		Query query3 = em.createNamedQuery("Employe.findAll", Employe.class);
		List<Employe> emp4 = query3.getResultList();
		for(Employe employe : emp4){
			System.out.println("id : "+ employe.getId() +"nom : "+ employe.getNom() +" prenom : "+employe.getPrenom());
		}
		
		
		
		//Requete4: Employe dont le nom est XXX
		System.out.println("\nRequete4: Employe dont le nom est XXX");
		
		TypedQuery<Employe> query4 = em.createNamedQuery("Employe.findByNom", Employe.class);
		query4.setParameter("nomVar", "Griezmann");
		Employe emp5 = query4.getSingleResult();
		System.out.println(emp5.getNom());
		
		
		
		
		//Requete5: Employe dont le salaire est sup a 40 0000€
				System.out.println("\nRequete5: Employe dont le salaire est sup a 40 000€");
				
				Query query5 = em.createNamedQuery("Employe.findBySal", Employe.class);
				query5.setParameter("salVar", 40000d);
				List<Employe> emp6 = query5.getResultList();
				for(Employe employe : emp6){
					System.out.println("id : "+ employe.getId() +"nom : "+ employe.getNom() +" prenom : "+employe.getPrenom());
				}
				
				
//				//2 affiche la date de depart
//				TypedQuery<Employe> query6 = em.createNamedQuery("Employe.UpdateDFE", Employe.class);
//				query6.setParameter("dateFinEmb", 31/01/2017, "idVar", 1l);
//				Employe emp7 = query6.getSingleResult();
//				System.out.println(emp7.getNom());
//				
		
	}

}
