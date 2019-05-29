package it.contrader.model;

public class Material {


	int idmaterial;
	String tipo;
	int quantita;
	int idHR;

	public Material() {

	}

	public Material(int idmaterial, String tipo, int quantita, int idHR) {
		this.idmaterial = idmaterial;
		this.tipo = tipo;
		this.quantita = quantita;
		this.idHR = idHR;
	}
	
	public Material(String tipo, int quantita, int idHR) {
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

	public void setquantita(int quantita) {
		this.quantita = quantita;
	}

	public int getIdHR() {
		return idHR;
	}

	public void setIdHR(int idHR) {
		this.idHR = idHR;
	}
	
	@Override
	public String toString() {
		return "Material [idmaterial=" + idmaterial + ", tipo=" + tipo + ", quantita=" + quantita + ", idHR=" + idHR
				+ "]";
	}
}

