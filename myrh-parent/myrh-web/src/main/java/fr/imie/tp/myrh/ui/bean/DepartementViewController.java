package fr.imie.tp.myrh.ui.bean;

import java.io.Serializable;
import java.text.ParseException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import fr.imie.tp.myrh.dao.ifc.IDepartementDAO;
import fr.imie.tp.myrh.dao.imp.DepartementDAOImpl;
import fr.imie.tp.myrh.dao.model.Departement;
import fr.imie.tp.myrh.dao.model.Employe;

@ManagedBean(name="departementViewController")
public class DepartementViewController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<Departement> departementItems;

	private final IDepartementDAO _departementDaoService= new DepartementDAOImpl();
	
	
	@ManagedProperty("#{departementForm}")
	private DepartementForm createDepData;
	
	public DepartementForm getCreateDepData() {
		return createDepData;
	}

	public void setCreateDepData(DepartementForm createDepData) {
		this.createDepData = createDepData;
	}

	@PostConstruct
	public void init() {
		departementItems = (List<Departement>) _departementDaoService.getAllDepartement();
	}
	
	public void setDepartementItems(List<Departement> departementItems){
		this.departementItems = departementItems;
	}
	
	public List<Departement> getDepartementItems(){
		return  departementItems;
	}
	
	public void addDepartement(){
		Departement model=new Departement();
		model.setCode(createDepData.getCode());
		model.setDescription(createDepData.getDescription());
		model.setName(createDepData.getName());
		_departementDaoService.addDepartement(model);
	}
	
}