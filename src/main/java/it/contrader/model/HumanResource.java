package it.contrader.model;

public class HumanResource {

	private int idHR;
	private int idUser;
	private String name;
	private String surname;

	public HumanResource(int idHR, int idUser, String name, String surname) {
		this.idHR = idHR;
		this.idUser = idUser;
		this.name = name;
		this.surname = surname;
	}

	public int getidHR() {
		return idHR;
	}

	public void setidHR(int idHR) {
		this.idHR = idHR;
	}

	public int getidUser() {
		return this.idUser;
	}

	public void setidUser(int idUser) {
		this.idUser = idUser;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	/*
	 * public boolean isAdmin() { return (getSpeciality() == 1 ? true : false); }
	 */
	@Override
	public String toString() {
		return "ID: " + idHR + "\nNome: " + name + "\nCognome: " + surname + "\nEmail: ";
	}
}
