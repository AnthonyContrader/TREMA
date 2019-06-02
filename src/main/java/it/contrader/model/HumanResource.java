package it.contrader.model;

import it.contrader.model.*;

public class HumanResource {
	private int id;
	private String name;
	private String surname;
	private Users user;
	
	public HumanResource() {}
	
	public HumanResource(String name, String surname, Users user) {
		this.name=name;
		this.surname=surname;
		this.user=user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "id=" + id + ", name=" + name + ", surname=" + surname + ", iduser=" +this.getUser().getIduser();
	}
	
	public boolean equals(HumanResource hr) {

		if (user.getIduser()!=hr.getUser().getIduser()) {
			return false;
		}

		if (!this.getName().equals(getName())) {
			return false;

		}
		
		if (!this.getSurname().equals(getSurname())) {
			return false;

		}
		
		return true;
	}
}
