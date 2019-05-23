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
	
	public boolean updateUser(User user) {
		return this.userDAO.updateUser(user);
	}
	
	public boolean deleteUser(int userId) {
		return this.userDAO.deleteUser(userId);
	}
	
	
}