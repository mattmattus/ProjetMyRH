package fr.imie.tp.myrh.dao.impl;

import java.util.Collection;
import java.util.List;

import org.junit.Test;

import fr.imie.tp.myrh.dao.ifc.IEmployeDAO;
import fr.imie.tp.myrh.dao.imp.EmployeDAOImpl;
import fr.imie.tp.myrh.dao.model.Employe;
import junit.framework.TestCase;

public class EmployeDAOImpl2Test extends TestCase {

	IEmployeDAO _employeDaoService = new EmployeDAOImpl();

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void testfineall() {
		List<Employe> result = (List<Employe>) _employeDaoService.getAllEmploye();
		assertEquals(3, result.size());
	}
}