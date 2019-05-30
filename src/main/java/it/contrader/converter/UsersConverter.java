package it.contrader.converter;

import it.contrader.dto.*;
import it.contrader.model.*;

public class UsersConverter{

	public static Users toEntity(UsersDTO userDTO) {

		Users user = null;
		if (userDTO != null) {
			user = new Users(userDTO.getUsername(), userDTO.getPassword(), userDTO.getUsertype());

			if (userDTO.getId() != null)
				user.setIduser(userDTO.getId());
		}
		
		
		return user;
	}


	public static UsersDTO toDTO(Users user) {

		UsersDTO userDTO = null;
		if (user != null) {
			userDTO = new UsersDTO(user.getUsername(), user.getPassword(), user.getUsertype());
			userDTO.setId(user.getIduser());
		}

		return userDTO;
	}
}
