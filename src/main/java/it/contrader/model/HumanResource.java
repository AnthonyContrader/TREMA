package it.contrader.model;

import java.util.List;

public class HumanResource {

	private int idHR;
	private String name;
	private String surname;
	private List<Material> material;
	private String user;
	private int iduser;

	public HumanResource() {}

	public HumanResource(String name, String surname, int iduser) {
		this.name = name;
		this.surname = surname;
		this.iduser = iduser;
	}

	public int getIdHR() {
		return idHR;
	}

	public void setIdHR(int IdHR) {
		this.idHR = IdHR;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<Material> getMaterial() {
		return material;
	}

	public void setMaterial(List<Material> material) {
		this.material = material;
	}
	
	@Override
	public String toString() {
		return  idHR + "\t\t" + name + "\t\t" + surname + "\t\t" + iduser;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;
		
		if (getClass() != obj.getClass())
			return false;
		
		HumanResource other = (HumanResource) obj;
		
		if (material == null) {
			if (other.material != null)
				return false;
		} else if (!material.equals(other.material))
			return false;
		
		if (idHR != other.idHR)
			return false;
		
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
				
		return false;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public int getUserid() {
		return iduser;
	}

	public void setUserid(int iduser) {
		this.iduser = iduser;
	}
	
}
