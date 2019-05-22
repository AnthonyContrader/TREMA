package it.contrader.model;


public class Project {

	private int idProject;
	private String category;
	private String dataInizio;
	private String name;
	
	public Project(int idProject, String name,String category,String dataInizio) {
		
		this.idProject=idProject;
		this.name=name;
		this.category=category;
		this.dataInizio=dataInizio;
	}
	
	public void setNome(String name) {
		this.name=name;
	}
	
	public String getName() {
		return this.name;
	}
	public int getIDProject() {
		return idProject;
	}
	public String getCategory() {
		return category;
	}
	
	public void dataInizio(String dataInizio) {
		this.dataInizio=dataInizio;
	}
	
	public String getdataInizio() {
		return dataInizio;
	}
	
	public void setCategory(String category) {
		this.category=category;
	}

	@Override
	public String toString() {
		return "Categoria: "+category+"\n Nome: "+name+ "\n Data: "+dataInizio +"\n Id: "+idProject;
	}
}
