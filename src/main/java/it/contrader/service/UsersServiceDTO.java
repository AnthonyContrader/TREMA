package it.contrader.service;

import it.contrader.dto.*;
import it.contrader.model.Users;
import it.contrader.dao.*;

import java.util.ArrayList;
import java.util.List;

import it.contrader.converter.*;

/**
 * Classe che si occupa di interfacciarsi con la persistenza e recuperare
 * attraverso i metodi del Data Access Object le tuple desiderate, Le converte
 * in un oggetto DTO e le restituisce al controller opportuno
 */
public class UsersServiceDTO {

	private final UsersDAO userDAO;

	public UsersServiceDTO() {
		this.userDAO = new UsersDAO();
	}
	
	public List<UsersDTO> getAllUser() {

		List<Users> list = userDAO.getAllUser();
		List<UsersDTO> listDTO = new ArrayList<>();

		for (Users user : list) {
			listDTO.add(UsersConverter.toDTO(user));
		}

		return listDTO;
	}
	
	public UsersDTO getUserByUsernameAndPassword(String username, String password) {
		return UsersConverter.toDTO(userDAO.login(username, password));
	}

	public UsersDTO readUser(UsersDTO userDTO) {
		return UsersConverter.toDTO(this.userDAO.readUser(UsersConverter.toEntity(userDTO)));
	}
	
	public boolean updateUser(UsersDTO userDTO) {
		return this.userDAO.updateUser(UsersConverter.toEntity(userDTO));
		
}
	
	public boolean deleteUser (UsersDTO userDTO) {
		return this.userDAO.deleteUser(UsersConverter.toEntity(userDTO));
		
}
	
	public boolean insertUsers (UsersDTO usersDTO) {
		return this.userDAO.insertUser(UsersConverter.toEntity(usersDTO));
	
}
	}