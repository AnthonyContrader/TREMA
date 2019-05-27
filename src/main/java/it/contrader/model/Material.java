package it.contrader.model;

public class Material {

	private int idMaterial;
	private int idHR;
	private String tipo;
	private int quantita;
	

	public Material(int idMaterial, String tipo, int quantita, int idHR) {
		this.idMaterial = idMaterial;
		this.idHR = idHR;
		this.tipo = tipo;
		this.quantita=quantita;
	}

	public int getidMaterial() {
		return idMaterial;
	}

	public void setidMaterial(int idMaterial) {
		this.idMaterial = idMaterial;
	}

	public int getIdHR() {
		return idHR;
	}

	public void setIdHR(int idHR) {
		this.idHR = idHR;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public void setQuantita(int quantita) {
		this.quantita=quantita;
	}
	
	public int getQuantita(){
		return quantita;
	}

	@Override
	public String toString() {
		return "idMaterial= " + idMaterial + ", idHR= " + idHR + ", tipo= " + tipo + ", quantita= " + quantita;
	}

	public boolean equals(Material materialCompare) {
		if (!this.getTipo().equals(materialCompare.getTipo())) {
			return false;
		}

		return true;

	}

}