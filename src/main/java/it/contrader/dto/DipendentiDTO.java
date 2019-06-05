package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import it.contrader.model.Material;
import it.contrader.dto.UserDTO;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DipendentiDTO {

	private int idDipendente;

	private String name;
	
	private String surname;

	private UserDTO userDTO;

	private List<MaterialDTO> materialsDTO;
	
	public DipendentiDTO() {
	}

	public int getIdDipendenti() {
		return this.idDipendente;
	}

	public void setIdDipendenti(int idDipendenti) {
		this.idDipendente = idDipendenti;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public UserDTO getUserDTO() {
		return this.userDTO;
	}

	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}

	public List<MaterialDTO> getMaterialsDTO() {
		return this.materialsDTO;
	}

	public void setMaterialsDTO(List<MaterialDTO> materialsDTO) {
		this.materialsDTO = materialsDTO;
	}

	

}