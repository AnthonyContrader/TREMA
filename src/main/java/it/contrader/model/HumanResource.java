package it.contrader.model;

import it.contrader.model.*;

public class HumanResource {

	private int idhr;
	private Users user;
	private String name;
	private String surname;

	public HumanResource() {}
	
	/*public HumanResource(Users user, String name) {
		this.user=user; 
		this.name=name;
	}*/
	
	public HumanResource(Users user, String name, String surname) {
		this.user=user; 
		this.name=name;
		this.surname=surname;
	}


	public int getId() {
		return idhr;
	}

	public void setId(int id) {
		this.idhr = id;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String toString() {
		return this.getId() + " " + this.getUser().getIduser() + " " + this.getName() + " " + this.getSurname();

	}

	public boolean equals(HumanResource hr) {

		if (user.getIduser()!=hr.getUser().getIduser()) {
			return false;
		}

		if (!this.getName().equals(getName())) {
			return false;

		}
		
		return true;
	}
}
