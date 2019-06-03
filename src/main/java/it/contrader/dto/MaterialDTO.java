package it.contrader.dto;

import it.contrader.dto.*;

public class MaterialDTO {
	private int idmaterial;
	private String tipo;
	private int quantita;
	private UsersDTO hrDTO;
	
	public MaterialDTO(String tipo, int quantita, UsersDTO hrLogged){
		super();
		this.tipo = tipo;
		this.quantita = quantita;
		this.hrDTO = hrLogged; 
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

	public UsersDTO getHRDTO() {
		return hrDTO;
	}

	public void setHRDTO(UsersDTO hrDTO) {
		this.hrDTO = hrDTO;
	}
	
	public boolean equals(MaterialDTO materialCompare) {
		if (hrDTO.getId()!=materialCompare.getHRDTO().getId()) 
			return false;
		
		if (!this.getTipo().equals(getTipo()))
			return false;
		
		return true;
	}
}
