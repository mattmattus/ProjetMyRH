package fr.imie.tp.myrh.dao.ifc;

import java.util.Collection;

import fr.imie.tp.myrh.dao.model.Employe;
public interface IEmployeDAO{
	
		public Collection<Employe> getAllEmploye();
		public void addEmploye(Employe employe);
		public Collection<Employe> getEmployeByDep();

}
