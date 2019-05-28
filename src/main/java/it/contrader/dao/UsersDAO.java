package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import it.contrader.model.*;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.utils.GestoreEccezioni;

public class UsersDAO {
<<<<<<< HEAD
	/**
	 * Qui possiamo se vogliamo dichiarare delle stringhe rappresentanti le query
	 * che verranno utilizzate dai service, Non è obbligatorio ma è consigliato
	 * usare un ordine e dei nomi significativi per tutte le query. Con GET_ALL
	 * intendiamo recuperare tutte le tuple dal db. Se volessimo creare una query
	 * per l'inserimento, un nome identificativo potrebbe essere INSERT_ESEMPIO
	 */
	private final String GET_ALL = "select * from users";
	private final String QUERY_INSERT = "INSERT INTO users (id, username, password, ruolo) values (?,?,?,?)";
	private final String QUERY_DELETE = "DELETE FROM users WHERE id = (?)";
	private final String QUERY_UPDATE = "UPDATE users SET username, password, ruolo =(?,?,?) WHERE id = (?)";
	private final String QUERY_LOGIN = "select * from users where username=(?) and password=(?)";

	/**
	 * Il suddetto metodo si occupa interagire con il database e restituire tutte le
	 * tuple al servizio che ha chiamato questo metodo
	 */

	public Users login(String username, String password) {
=======

	private final String QUERY_ALL = "SELECT * FROM user";
	private final String QUERY_INSERT = "INSERT INTO user (username, password, usertype) VALUES (?,?,?)";
	private final String QUERY_READ = "SELECT * FROM user WHERE iduser=?";
	private final String QUERY_UPDATE = "UPDATE user SET username=?, password=?, usertype=? WHERE iduser=?";
	private final String QUERY_DELETE = "DELETE FROM user WHERE iduser=?";
	private final String QUERY_LOGIN = "select * from user where username=? and password=?";

	public UsersDAO() {}

	public List<Users> getAllUser() {
		List<Users> usersList = new ArrayList<>();
>>>>>>> a55be6440364c682e5d9000e8e115f516e6d832b
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

<<<<<<< HEAD
	public List<Users> getAllUsers() {
		final List<Users> users = new ArrayList<>();
		final Connection connection = ConnectionSingleton.getInstance();

		try {
			final Statement statement = connection.createStatement();
			final ResultSet resultSet = statement.executeQuery(GET_ALL);
			while (resultSet.next()) {
				final Integer id = resultSet.getInt("id");
				final String username = resultSet.getString("username");
				final String password = resultSet.getString("password");
				final String ruolo = resultSet.getString("ruolo");

				users.add(new Users(id, username, password, ruolo));
			}
		} catch (final SQLException e) {
			e.printStackTrace();
=======
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
>>>>>>> a55be6440364c682e5d9000e8e115f516e6d832b
		}

	}

	public Users readUser(int userId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String username, password, usertype;

			username = resultSet.getString("username");
			password = resultSet.getString("password");
			usertype = resultSet.getString("usertype");
			Users user = new Users(username, password, usertype);
			user.setIduser(resultSet.getInt("iduser"));

			return user;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return null;
		}

	}

	public boolean updateUser(Users userToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if iduser exists...
		if (userToUpdate.getIduser() == 0)
			return false;

		Users userRead = readUser(userToUpdate.getIduser());
		if (!userRead.equals(userToUpdate)) {
			try {
				// Fill the userToUpdate object
				if (userToUpdate.getUsername() == null || userToUpdate.getUsername().equals("")) {
					userToUpdate.setUsername(userRead.getUsername());
				}

				if (userToUpdate.getPassword() == null || userToUpdate.getPassword().equals("")) {
					userToUpdate.setPassword(userRead.getPassword());
				}

				if (userToUpdate.getUsertype() == null || userToUpdate.getUsertype().equals("")) {
					userToUpdate.setUsertype(userRead.getUsertype());
				}

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

		return false;
	}

	public boolean deleteUser (Users userToDelete) {
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

<<<<<<< HEAD
	// Modifica Chat
	public boolean updateUsers(Users users) {
=======
	public Users login(String username, String password) {

>>>>>>> a55be6440364c682e5d9000e8e115f516e6d832b
		Connection connection = ConnectionSingleton.getInstance();
		Users utente = null;
		try {
<<<<<<< HEAD
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_UPDATE);
			preparedStatement.setString(1, users.getUsername());
			preparedStatement.setString(2, users.getPassword());
			preparedStatement.setString(3, users.getRuolo());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}
=======
			PreparedStatement statement = connection.prepareStatement(QUERY_LOGIN);
			statement.setString(1, username);
			statement.setString(2, password);
			statement.execute();
			ResultSet resultSet = statement.getResultSet();

			while (resultSet.next()) {
				String Username = resultSet.getString("username");
				String pass = resultSet.getString("password");
				Integer userId = resultSet.getInt("iduser");
				String usertype = resultSet.getString("usertype");
				utente = new Users(Username, pass, usertype);
				utente.setIduser(userId);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return utente;
>>>>>>> a55be6440364c682e5d9000e8e115f516e6d832b
	}
	
}
