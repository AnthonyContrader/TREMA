package it.contrader.dto;

public class MaterialDTO {

	private int idmaterial;
	private String tipo;
	private int quantita;
	private int idHR;
	
	public MaterialDTO() {}
	
	public MaterialDTO(int idmaterial, String tipo, int quantita, int idHR) {
		super();
		this.idmaterial = idmaterial;
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

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	public int getIdHR() {
		return idHR;
	}

	public void setIdHR(int idHR) {
		this.idHR = idHR;
	}
}

