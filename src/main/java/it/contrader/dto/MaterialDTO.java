package it.contrader.dto;

public class MaterialDTO implements DTO {
	int idmaterial;
	String tipo;
	int quantita;
	int idHR;
	
	public MaterialDTO(){}
	
	public MaterialDTO(int idmaterial, String tipo, int quantita, int idHR) {
		this.idmaterial = idmaterial;
		this.tipo = tipo;
		this.quantita = quantita;
		this.idHR = idHR;
	}
	
	public MaterialDTO(String tipo, int quantita, int idHR) {
		this.tipo = tipo;
		this.quantita = quantita;
		this.idHR = idHR;
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

	public int getquantita() {
		return quantita;
	}

	public void setquantita(int quantita) {
		this.quantita = quantita;
	}

	public int getidHR() {
		return idHR;
	}

	public void setidHR(int idHR) {
		this.idHR = idHR;
	}
}
