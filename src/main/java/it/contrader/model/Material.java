package it.contrader.model;

import java.util.*;

public class Material {
	
	private int idmaterial;
	private String descrizione;
	private List<Item> items;
	private int buildingid;

	public Material() {}
	
	public Material(String descrizione, int buildingid) {
		super ();
		this.descrizione = descrizione;
		this.buildingid = buildingid;
	}
	
	public int getIdMaterial() {
		return idmaterial;
	}

	public void setId(int idmaterial) {
		this.idmaterial = idmaterial;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public List <Item> getItems() {
		return items;
	}

	public void setItems(List <Item> items) {
		this.items = items;
	}
	
	@Override
	public String toString() {
		return   idmaterial + "\t\t" + descrizione + "\t\t\t" + buildingid ;
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
		
		if (descrizione == null) {
			if (other.descrizione != null)
				return false;
		} else if (!descrizione.equals(other.descrizione))
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

	public int getBuildingid() {
		return buildingid;
	}

	public void setBuildingid(int buildingid) {
		this.buildingid = buildingid;
	}
	
}