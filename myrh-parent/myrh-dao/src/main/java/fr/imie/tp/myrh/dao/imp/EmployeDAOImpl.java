package fr.imie.tp.myrh.dao.imp;

import java.util.Collection;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.imie.tp.myrh.dao.ifc.IEmployeDAO;
import fr.imie.tp.myrh.dao.model.Employe;

public class EmployeDAOImpl implements IEmployeDAO{

	EntityManager em;
	
	public EmployeDAOImpl(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myRhPersistenceUnit");
		em = emf.createEntityManager();
	}
	
	public Collection<Employe> getAllEmploye(){
		TypedQuery<Employe> query = em.createNamedQuery("Employe.findAll", Employe.class);
		Collection<Employe> emps = query.getResultList();
		return emps;
	}
	
	public void addEmploye(Employe model){
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(model);
		transaction.commit();
	}
	
	public Collection<Employe> getEmployeByDep(){
		TypedQuery<Employe> query = em.createNamedQuery("Employe.findByDep", Employe.class);
		query.setParameter("idDep", 1L);
		Collection<Employe> emps = query.getResultList();
		return emps;
	}
	
	public EntityManager getEm(){
		return em;
	}
}
