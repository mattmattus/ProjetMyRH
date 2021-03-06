package fr.imie.tp.myrh.ui.bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.imie.tp.myrh.dao.ifc.IDepartementDAO;
import fr.imie.tp.myrh.dao.ifc.IEmployeDAO;
import fr.imie.tp.myrh.dao.imp.DepartementDAOImpl;
import fr.imie.tp.myrh.dao.imp.EmployeDAOImpl;
import fr.imie.tp.myrh.dao.model.Departement;
import fr.imie.tp.myrh.dao.model.Employe;

@SessionScoped
@ManagedBean(name="employeViewController")
public class EmployeViewController {

	private static final long serialVersionUID = 1 ;
	private List<Employe> employeItems;
	private final IEmployeDAO _employeDaoService = new EmployeDAOImpl();

	private List<Departement> departementItems;
	private List<Employe> employeByDep;
	
	private final IDepartementDAO _departementDaoService= new DepartementDAOImpl();
	
	@ManagedProperty("#{employeForm}")
	private EmployeForm createEmployeData;
	
	public List<Employe> getEmployeByDep() {
		return employeByDep;
	}
	
	public void setEmployeByDep(List<Employe> employeByDep){
		this.employeByDep = employeByDep;
	}
	
	public List<Departement> getDepartementItems(){
		return  departementItems;
	}
	
	@PostConstruct
	public void init(){
		employeItems =(List<Employe>) _employeDaoService.getAllEmploye();
		departementItems = (List<Departement>) _departementDaoService.getAllDepartement();
		employeByDep = (List<Employe>) _employeDaoService.getEmployeByDep();
	}
	
	
	
	
	//Utilitaire Date
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	public EmployeForm getCreateEmployeData() {
		return createEmployeData;
	}

	public void setCreateEmployeData(EmployeForm createEmployeData) {
		this.createEmployeData = createEmployeData;
	}

	public List<Employe> getEmployeItems() {
		return employeItems;
	}
	
	public void setEmployeItems(List<Employe> employeItems){
		this.employeItems = employeItems;
	}
	
	public void addEmploye(){
		Employe model=new Employe();
		model.setNom(createEmployeData.getNom());
		model.setPrenom(createEmployeData.getPrenom());
		try {
			model.setDatenaiss(sdf.parse(createEmployeData.getDatenaiss()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.setSecuriteSoc(createEmployeData.getSecuriteSoc());
		model.setSalaire(createEmployeData.getSalaire());
		try {
			model.setDateEmbauche(sdf.parse(createEmployeData.getDateEmbauche()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			model.setDateFinEmbauche(sdf.parse(createEmployeData.getDateFinEmbauche()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		_employeDaoService.addEmploye(model);
	}
	
	public void muterEmploye() {
		
	}
	
}
