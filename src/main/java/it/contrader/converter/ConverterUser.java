package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.*;
import it.contrader.model.*;

public class ConverterUser {

	public static UserDTO toDTO(User user) {
		UserDTO userDTO = null;
		if (user != null) {
			userDTO = new UserDTO();
			userDTO.setIdUser(user.getIdUser());
			userDTO.setUser(user.getUser());
			userDTO.setPassword(user.getPassword());
			userDTO.setName_user(user.getName_user());
			userDTO.setSurname_user(user.getSurname_user());
			userDTO.setUsertype(user.getUsertype());
		}
		return userDTO;
	}

	public static User toEntity(UserDTO userDTO) {
		User user = null;
		if (userDTO != null) {
			user = new User();
			user.setIdUser(userDTO.getIdUser());
			user.setUser(userDTO.getUser());
			user.setPassword(userDTO.getPassword());
			user.setName_user(userDTO.getName_user());
			user.setSurname_user(userDTO.getSurname_user());
			user.setUsertype(userDTO.getUsertype());
		}
		return user;
	}

	public static List<UserDTO> toListDTO(List<User> list) {
		List<UserDTO> listUserDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (User user : list) {
				listUserDTO.add(ConverterUser.toDTO(user));
			}
		}
		return listUserDTO;
	}

	public static List<User> toListEntity(List<UserDTO> listUserDTO) {
		List<User> list = new ArrayList<>();
		if (!listUserDTO.isEmpty()) {
			for (UserDTO userDTO : listUserDTO) {
				list.add(ConverterUser.toEntity(userDTO));
			}
		}
		return list;
	}
}