package it.contrader.dto;

import it.contrader.dto.MaterialDTO;
import it.contrader.dto.UsersDTO;

public class MaterialDTO {
	private int idmaterial;
	private String tipo;
	private int quantita;
	private UsersDTO userDTO;
	
	public MaterialDTO(String tipo, int quantita, UsersDTO userDTO){
		super();
		this.tipo = tipo;
		this.quantita = quantita;
		this.userDTO=userDTO; 
	}

	public int getIdmaterial() {
		return idmaterial;
	}

	public void setIdmaterial(int idmaterial) {
		this.idmaterial = idmaterial;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	public UsersDTO getUserDTO() {
		return userDTO;
	}

	public void setUserDTO(UsersDTO userDTO) {
		this.userDTO = userDTO;
	}
	
	public boolean equals(MaterialDTO materialCompare) {
		
		if (userDTO.getId()!=materialCompare.getUserDTO().getId()) {
			return false;
		}

		if (!this.getTipo().equals(getTipo()))
			return false;
		
		return true;
	}
}
