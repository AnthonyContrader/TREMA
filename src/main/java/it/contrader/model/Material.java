package it.contrader.model;

public class Material {
	private int idmaterial;
	private String tipo;
	private int quantita;
	private Users hr;

	public Material() {

	}

	public Material(String tipo, int quantita, Users hr2) {
		this.idmaterial = idmaterial;
		this.tipo = tipo;
		this.quantita = quantita;
		this.hr = hr2;
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

	public Users getHR() {
		return hr;
	}

	public void setHR(Users hr) {
		this.hr = hr;
	}
	
	public boolean equals(Material materialCompare) {
		if (!this.getTipo().equals(getTipo())) {
			return false;
		}
		
		if (hr.getIduser() != materialCompare.getHR().getIduser()) {
			return false;
		}
		
		return true;
	}
	
	public String toString() {
		return this.getIdmaterial() + "\t\t" + this.getTipo() + "\t\t" 
				+ this.getQuantita() + "\t\t" + this.getHR().getIduser();
	}
}

