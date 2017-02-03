package fr.imie.tp.myrh.dao.imp;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.imie.tp.myrh.dao.ifc.IDepartementDAO;
import fr.imie.tp.myrh.dao.model.Departement;
import fr.imie.tp.myrh.dao.model.Employe;

public class DepartementDAOImpl implements IDepartementDAO{

	EntityManager em;
	
	public DepartementDAOImpl(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myRhPersistenceUnit");
		em = emf.createEntityManager();
	}
	

	public Collection<Departement> getAllDepartement(){
		TypedQuery<Departement> query = em.createNamedQuery("Departement.findAll", Departement.class);
		Collection<Departement> emps = query.getResultList();
		return emps;
	}
	
	public void addDepartement(Departement model){
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(model);
		transaction.commit();
	}
	
	public EntityManager getEm(){
		return em;
	}
}