package it.contrader.model;

import it.contrader.model.Material;
import it.contrader.model.Users;

public class Material {
	
	private int idmaterial;
	private String tipo;
	private int quantita;
	private Users user;

	public Material() {

	}

	public Material(String tipo, int quantita, Users user) {
		this.tipo = tipo;
		this.quantita = quantita;
		this.user=user; 
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

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
	
	public boolean equals(Material materialCompare) {
		if (!this.getTipo().equals(getTipo())) {
			return false;
		}
		
		if (user.getIduser()!=materialCompare.getUser().getIduser()) {
			return false;
		}
		
		return true;
	}
	
	public String toString() {
		return this.getIdmaterial() + "\t\t" + this.getTipo() + "\t\t" 
				+ this.getQuantita() + "\t\t" + this.getUser().getIduser();
	}
}

