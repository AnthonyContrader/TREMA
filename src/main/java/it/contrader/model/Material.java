package it.contrader.model;

import java.util.*;

public class Material {
	
	private int idmaterial;
	private String description;
	private List<Item> items;
	private int idhr;

	public Material() {}
	
	public Material(String description, int idhr) {
		super ();
		this.description = description;
		this.idhr = idhr;
	}
	
	public int getIdMaterial() {
		return idmaterial;
	}

	public void setIdMaterial(int idmaterial) {
		this.idmaterial = idmaterial;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List <Item> getItems() {
		return items;
	}

	public void setItems(List <Item> items) {
		this.items = items;
	}
	
	@Override
	public String toString() {
		return   idmaterial + "\t\t" + description + "\t\t\t" + idhr ;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;
		
		if (getClass() != obj.getClass())
			return false;
		
		Material other = (Material) obj;
		
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		
		if (idmaterial != other.idmaterial)
			return false;
		
		if (items == null) {
			if (other.items != null)
				return false;
		} else if (!items.equals(other.items))
			return false;
		
		return true;
	}

	public int getIdHR() {
		return idhr;
	}

	public void setIdHR(int idhr) {
		this.idhr = idhr;
	}
	
}