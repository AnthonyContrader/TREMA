package it.contrader.service;

import java.util.ArrayList;
import java.util.List;

import it.contrader.converter.UsersConverter;
import it.contrader.dao.*;
import it.contrader.dto.UsersDTO;
import it.contrader.model.Users;

/**
 * Classe che si occupa di interfacciarsi con la persistenza e recuperare
 * attraverso i metodi del Data Access Object le tuple desiderate, Le converte
 * in un oggetto DTO e le restituisce al controller opportuno
 */
public class UsersServiceDTO {

	private final UsersDAO usersDAO;

	public UsersServiceDTO() {
		this.usersDAO = new UsersDAO();
	}

	/**
	 * Come vediamo la lista recuperata è di tipo Esempio ma noi la convertiamo in EsempioDTO
	 * Invito chi fa i converter a fare un metodo per convertire direttamente la lista senza farli uno ad uno perchè è sporco e poco efficiente
	 */
	public List<UsersDTO> getAllUsers() {

		List<Users> list = usersDAO.getAllUser();
		List<UsersDTO> listDTO = new ArrayList<>();

		for (Users users : list) {
			listDTO.add(UsersConverter.toDTO(users));
		}

		return listDTO;
	}
	
	public UsersDTO getUserByUsernameAndPasword(String username, String password) {
		return UsersConverter.toDTO(usersDAO.login(username, password));
	}

	public boolean updateUsers (UsersDTO usersDTO) {
		return this.usersDAO.updateUser(UsersConverter.toEntity(usersDTO));
		
}
	
	public boolean deleteUsers (UsersDTO usersDTO) {
		return this.usersDAO.deleteUser(UsersConverter.toEntity(usersDTO));
		
}
	
	public boolean insertUsers (UsersDTO usersDTO) {
		return this.usersDAO.insertUser(UsersConverter.toEntity(usersDTO));
	
}
		
	
	
}
