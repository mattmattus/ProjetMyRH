package fr.imie.tp.myrh.dao.imp;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.imie.tp.myrh.dao.ifc.IEmployeDAO;
import fr.imie.tp.myrh.dao.model.Employe;

public class EmployeDAOImpl implements IEmployeDAO{

	EntityManager em;
	
	public EmployeDAOImpl(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myRhPersistenceUnit");
		em = emf.createEntityManager();
	}
	
	@Override
	public Collection<Employe> getAllEmploye(){
		Collection<Employe> emps = em.createNamedQuery("Employe.findAll", Employe.class);
		return emps;
	}
	
	public EntityManager getEm(){
		return em;
	}
}
