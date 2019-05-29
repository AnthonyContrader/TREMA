package it.contrader.converter;

import it.contrader.dto.*;
import it.contrader.model.*;

public class UsersConverter implements Converter<Users,UsersDTO> {

	@Override
	public Users toEntity(UsersDTO userDTO) {
		Users user = null;
		if (userDTO != null) {
			user = new Users( userDTO.getUsername(), userDTO.getPassword(), userDTO.getUsertype());
			Integer id = userDTO.getId();
			if(id != null) {
				user.setIduser(id);
			}

			
		}
		
		return user;
	}

	@Override
	public UsersDTO toDTO(Users user) {
		UsersDTO userDTO = null;
		if (user != null) {
			userDTO = new UsersDTO( user.getIduser(),user.getUsername(), user.getPassword(), user.getUsertype());
		}
		return userDTO;
	}
}
