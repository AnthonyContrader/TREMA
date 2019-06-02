package it.contrader.dto;

import it.contrader.dto.*;

public class HumanResourceDTO {
	
	private int Id;
	private UsersDTO userDTO;
	private String name;
	private String surname;
	
	public HumanResourceDTO (String name, String surname, UsersDTO userDTO) {
		super();
		this.userDTO=userDTO; 
		this.name=name;
		this.surname=surname;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public UsersDTO getUserDTO() {
		return userDTO;
	}

	public void setUserDTO(UsersDTO userDTO) {
		this.userDTO = userDTO;
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


	public boolean equals(HumanResourceDTO hrCompare) {

		if (userDTO.getId()!=hrCompare.getUserDTO().getId()) {
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

