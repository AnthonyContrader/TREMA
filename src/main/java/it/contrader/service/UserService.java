package it.contrader.service;

import java.util.List;
import it.contrader.dao.UserDAO;
import it.contrader.model.User;

public class UserService {

	private UserDAO userDAO;

	public UserService() {
		this.userDAO = new UserDAO();
	}

	public List<User> getAllUser() {
		return this.userDAO.getAllUser();
	}

	public boolean insertUser(User usersDAO) {
		return this.userDAO.insertUser(usersDAO);
	}
	
	public User readUser(int userId) {
		return this.userDAO.readUser(userId);
	}
	
	public boolean deleteUser(int userId) {
		return userDAO.deleteUser(userId);
	}
	
	public boolean insertUser(int id, String username, String password, String usertype) {
		User newUser = new User(id, username, password, usertype);
		return userDAO.insertUser(newUser);
	}

	public boolean updateUser(int id, String username, String password, String usertype) {
		User newUser = new User(id, username, password, usertype);
		newUser.setIdUser(id);
		return userDAO.updateUser(newUser);
	}

	
	
}