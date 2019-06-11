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
			userDTO.setUserLogin(user.getUserLogin());
			userDTO.setPassword(user.getPassword());
			userDTO.setNameUser(user.getNameUser());
			userDTO.setSurnameUser(user.getSurnameUser());
			userDTO.setAzienda(user.getAzienda());
			userDTO.setUserType(user.getUserType());
		}
		return userDTO;
	}

	public static User toEntity(UserDTO userDTO) {
		User user = null;
		if (userDTO != null) {
			user = new User();
			user.setIdUser(userDTO.getIdUser());
			user.setUserLogin(userDTO.getUserLogin());
			user.setPassword(userDTO.getPassword());
			user.setNameUser(userDTO.getNameUser());
			user.setSurnameUser(userDTO.getSurnameUser());
			user.setAzienda(userDTO.getAzienda());
			user.setUserType(userDTO.getUserType());
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
