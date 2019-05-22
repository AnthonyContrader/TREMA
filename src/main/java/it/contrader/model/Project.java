package it.contrader.model;

import java.sql.Timestamp;

public class Project {

	private int id;
	private String category;
	private Timestamp dataInizio;
	
	public Project(int id, String category,Timestamp dataInizio) {
		
		this.id=id;
		this.category=category;
		this.dataInizio=dataInizio;
	}
	public int getID() {
		return id;
	}
	public String getCategory() {
		return category;
	}
	
	public void dataInizio(Timestamp dataInizio) {
		this.dataInizio=dataInizio;
	}
	
	public Timestamp getdataInizio() {
		return dataInizio;
	}
	
	public void setCategory(String category) {
		this.category=category;
	}

	@Override
	public String toString() {
		return "Categoria: "+category+ "\n Data: "+dataInizio +"\n Id: "+id;
	}
}
