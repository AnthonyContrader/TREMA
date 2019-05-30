package it.contrader.model;

import it.contrader.model.Project;
import it.contrader.model.Users;

public class Project {

	private int projectId;
	private Users user;
	private String projectName;
	private String descrizione;
	private String tipo;

	public Project() {}
	
	public Project(String projectName,String descrizione, String tipo, Users user) {
		this.user=user; 
		this.projectName=projectName;
		this.descrizione=descrizione;
		this.tipo=tipo;
	}


	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String toString() {
		return this.getProjectId() + " " + this.getProjectName() + " " + this.getDescrizione() +  " " + this.getTipo() + " " + this.getUser().getIduser() ;

	}

	public boolean equals(Project projectCompare) {

		if (user.getIduser()!=projectCompare.getUser().getIduser()) {
			return false;
		}

		if (!this.getProjectName().equals(getProjectName())) {
			return false;

		}
		
		return true;
	}

}
