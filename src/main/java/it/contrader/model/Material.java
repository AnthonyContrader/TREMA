package it.contrader.model;

public class Material {
	private int idmaterial;
	private String tipo;
	private int quantita;
	private HumanResource hr;

	public Material() {

	}

	public Material(String tipo, int quantita, HumanResource hr) {
		this.idmaterial = idmaterial;
		this.tipo = tipo;
		this.quantita = quantita;
		this.hr = hr;
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

	public HumanResource getHR() {
		return hr;
	}

	public void setHR(HumanResource hr) {
		this.hr = hr;
	}
	
	public boolean equals(Material materialCompare) {
		if (!this.getTipo().equals(getTipo())) {
			return false;
		}
		
		if (hr.getId() != materialCompare.getHR().getId()) {
			return false;
		}
		
		return true;
	}
	
	public String toString() {
		return this.getIdmaterial() + "\t\t" + this.getTipo() + "\t\t" 
				+ this.getQuantita() + "\t\t" + this.getHR().getId();
	}
}

