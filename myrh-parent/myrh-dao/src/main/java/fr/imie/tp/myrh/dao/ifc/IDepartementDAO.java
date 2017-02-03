package fr.imie.tp.myrh.dao.ifc;

import java.util.Collection;

import fr.imie.tp.myrh.dao.model.Departement;
import fr.imie.tp.myrh.dao.model.Employe;

public interface IDepartementDAO {

	public Collection<Departement> getAllDepartement();
	public void addDepartement(Departement departement);
}