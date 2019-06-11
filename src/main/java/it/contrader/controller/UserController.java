package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.UserDTO;
import it.contrader.services.UserService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/User")
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/userManagement", method = RequestMethod.GET)
	public List<UserDTO> userManagement() {
		return this.userService.findAllUserDTO();
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public UserDTO read(@RequestParam(value = "IdUser") int id) {
		UserDTO readUser = new UserDTO();
		readUser = this.userService.getUserDTOById(id);
		return readUser;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public void delete(@RequestParam(value = "IdUser") int id) {
		this.userService.deleteUserById(id);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public void update(@RequestBody UserDTO user) {
		userService.updateUser(user);
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public void insert(@RequestBody UserDTO user) {
		userService.insertUser(user);
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public UserDTO loginControl(@RequestParam(value = "username") String username,@RequestParam(value = "password") String password) {
		final UserDTO userDTO = userService.getUserByUserLoginAndPassword(username, password);
		final String userType = userDTO.getUserType();
		if (!StringUtils.isEmpty(userType)) {
				return userDTO;
		}
				return null;
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public void logOut() {}
}
