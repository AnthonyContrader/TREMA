package it.contrader.model;

public class Material {
	
	private int idMaterial;
	private String name;
	private String modello;
	private String category;
	private int inventory;
		
	public Material(int idMaterial,String name,String modello,int inventory, String category){
		this.idMaterial=idMaterial;
		this.name=name;
		this.modello=modello;
		this.inventory=inventory;
		this.category=category;
	}
	
	public int getIdMaterial() {
		return idMaterial;
	}

	public void setIdMaterial(int idMaterial) {
		this.idMaterial = idMaterial;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public int getInventory() {
		return inventory;
	}

	public void setInventory(int inventory) {
		this.inventory = inventory;
	}
	
	public void setCategory(String category) {
		this.category=category;
	}
	
	public String getCategory() {
		return this.category;
	}

	@Override
	public String toString() {
		return "Material [nome=" + name + ", modello=" + modello + ", inventory=" + inventory + ", id=" + idMaterial + "categoria" +"]";
	}


}