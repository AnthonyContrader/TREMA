package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import it.contrader.main.ConnectionSingleton;
import it.contrader.main.GestoreEccezioni;
import it.contrader.model.*;

public class UsersDAO{

	private final String QUERY_ALL = "SELECT * FROM user";
	private final String QUERY_INSERT = "INSERT INTO user (username, password, usertype) VALUES (?,?,?)";
	private final String QUERY_READ = "SELECT * FROM user WHERE iduser=?";
	
	private final String QUERY_UPDATE = "UPDATE user SET username=?, password=?, usertype=? WHERE iduser=?";
	private final String QUERY_DELETE = "DELETE FROM user WHERE iduser=?";
	private final String QUERY_LOGIN = "SELECT * FROM user WHERE username=? AND password=?";

	public UsersDAO() {}

	
	public List<Users> getAllUser() {
		List<Users> usersList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Users user;
			while (resultSet.next()) {
				int userId = resultSet.getInt("iduser");
				String username = resultSet.getString("username");
				String password = resultSet.getString("password");
				String usertype = resultSet.getString("usertype");
				user = new Users(username, password, usertype);
				user.setIduser(userId);
				usersList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usersList;
	}


	public boolean insertUser(Users userToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
			preparedStatement.setString(1, userToInsert.getUsername());
			preparedStatement.setString(2, userToInsert.getPassword());
			preparedStatement.setString(3, userToInsert.getUsertype());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}

	}


	public Users readUser(Users user) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			int userId=user.getIduser();
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String username, password, usertype;

			username = resultSet.getString("username");
			password = resultSet.getString("password");
			usertype = resultSet.getString("usertype");
			user = new Users(username, password, usertype);
			user.setIduser(resultSet.getInt("iduser"));

			return user;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return null;
		}

	}

//delete e user non controllate(per ora)
	public boolean updateUser(Users userToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if iduser exists...
		if (userToUpdate.getIduser() == 0)
			return false;

		//Users userRead = readUser(userToUpdate.getIduser());
		//if (!userRead.equals(userToUpdate)) {
			try {
				// Fill the userToUpdate object
			/*	if (userToUpdate.getUsername() == null || userToUpdate.getUsername().equals("")) {
					userToUpdate.setUsername(userRead.getUsername());
				}

				if (userToUpdate.getPassword() == null || userToUpdate.getPassword().equals("")) {
					userToUpdate.setPassword(userRead.getPassword());
				}

				if (userToUpdate.getUsertype() == null || userToUpdate.getUsertype().equals("")) {
					userToUpdate.setUsertype(userRead.getUsertype());
				}*/

				// Update the user
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, userToUpdate.getUsername());
				preparedStatement.setString(2, userToUpdate.getPassword());
				preparedStatement.setString(3, userToUpdate.getUsertype());
				preparedStatement.setInt(4, userToUpdate.getIduser());
				int a = preparedStatement.executeUpdate();
				if (a > 0)
					return true;
				else
					return false;

			} catch (SQLException e) {
				return false;
			}
}

		
	

	public boolean deleteUser(Users userToDelete) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, userToDelete.getIduser());
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;

		} catch (SQLException e) {
		}
		return false;
	}

	public Users login(String username, String password) {

		Connection connection = ConnectionSingleton.getInstance();
		Users utente = null;
		try {
			PreparedStatement statement = connection.prepareStatement(QUERY_LOGIN);
			
			statement.setString(1, username);
			statement.setString(2, password);
			statement.execute();
			ResultSet resultSet = statement.getResultSet();

			while (resultSet.next()) {
				String name = resultSet.getString("username");
				String pass = resultSet.getString("password");
				Integer userId = resultSet.getInt("iduser");
				String usertype = resultSet.getString("usertype");
				utente = new Users(name, pass, usertype);
				utente.setIduser(userId);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return utente;
	}
	
}
