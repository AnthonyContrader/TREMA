package it.contrader.dto;

import it.contrader.dto.ProjectDTO;
import it.contrader.dto.UsersDTO;

public class ProjectDTO {
	
	private int Id;
	private UsersDTO userDTO;
	private String projectName;
	private String descrizione;
	private String tipo;

	public ProjectDTO (String projectName, String descrizione, String tipo, UsersDTO userDTO) {
		super();
		//this.Id = Id;
		this.userDTO=userDTO; 
		this.projectName=projectName;
		this.descrizione=descrizione;
		this.tipo=tipo;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public UsersDTO getUserDTO() {
		return userDTO;
	}

	public void setUserDTO(UsersDTO userDTO) {
		this.userDTO = userDTO;
	}

	public String getprojectName() {
		return projectName;
	}

	public void setprojectName(String projectName) {
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

	public boolean equals(ProjectDTO projectCompare) {

		if (userDTO.getId()!=projectCompare.getUserDTO().getId()) {
			return false;
		}

		if (!this.getprojectName().equals(getprojectName())) {
			return false;

		}
		
		return true;
	}
	

	
}