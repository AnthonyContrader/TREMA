package it.contrader.model;

public class Material {

	private int idMaterial;
	private int idHR;
	private String tipo;

	public Material(int idMaterial, int idHR, String tipo) {
		this.idMaterial = idMaterial;
		this.idHR = idHR;
		this.tipo = tipo;
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

	@Override
	public String toString() {
		return this.getidMaterial() + "\t" + this.getIdHR() + "\t" + this.getTipo();
	}

	public boolean equals(Material materialCompare) {
		if (!this.getTipo().equals(materialCompare.getTipo())) {
			return false;
		}

		return true;

	}

}