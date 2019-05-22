package it.contrader.model;

public class Material {
	
	private String nome;
	private String modello;
	private String category;
	private int inventory;
	
	public Material(int id,String nome,String modello,int inventory, String category){
		this.id=id;
		this.nome=nome;
		this.modello=modello;
		this.inventory=inventory;
		this.category=category;
	}
	
	private int id;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
		return "Material [nome=" + nome + ", modello=" + modello + ", inventory=" + inventory + ", id=" + id + "categoria" +"]";
	}


}