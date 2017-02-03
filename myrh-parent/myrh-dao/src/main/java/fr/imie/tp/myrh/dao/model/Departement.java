package fr.imie.tp.myrh.dao.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="T_DEPARTEMENT")
@NamedQueries({
@NamedQuery(name="Departement.findAll", query="SELECT d FROM Departement d")
})
public class Departement implements Serializable{
	
	
	@Override
	public String toString() {
		return Name;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private long id;
	
	@Column(name="CODE")
	private String Code;
	
	@Column(name="NAME")
	private String Name;
	
	@Column(name="DESCRIPTION")
	private String Description;
	
	@OneToMany(mappedBy="departement")
	private List<Employe> employes;

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCode() {
		return Code;
	}

	public void setCode(String code) {
		Code = code;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public List<Employe> getEmployes() {
		return employes;
	}

	public void setEmployes(List<Employe> employes) {
		this.employes = employes;
	}
	

}
