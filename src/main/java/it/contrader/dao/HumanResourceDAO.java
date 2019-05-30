package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import it.contrader.main.*;
import it.contrader.model.HumanResource;
import it.contrader.model.Users;

public class HumanResourceDAO{

	private final String QUERY_ALL = "SELECT * FROM humanresource";
	private final String QUERY_INSERT = "INSERT INTO humanresource (name, surname, iduser) VALUES (?,?,?)";
	private final String QUERY_READ = "SELECT * FROM humanresource WHERE idHR=?";
	private final String QUERY_UPDATE = "UPDATE humanresource SET name=?, surname=?, iduser=? WHERE idHR=?";
	private final String QUERY_DELETE = "DELETE FROM humanresource WHERE idHR=?";

	public HumanResourceDAO() {
	}

	public List<HumanResource> getAllHr() {
		List<HumanResource> hrlist = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			HumanResource hr;
			while (resultSet.next()) {
				int userId = resultSet.getInt("iduser");
				Users user = new Users(null, null, null);
				user.setIduser(userId);

				String name = resultSet.getString("name");
				String surname = resultSet.getString("surname");

				hr = new HumanResource(user, name, surname);
				hr.setId(resultSet.getInt("idHR"));
				hrlist.add(hr);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return hrlist;
	}

	public boolean insertHr(HumanResource hr) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
			preparedStatement.setInt(1, hr.getUser().getIduser());
			preparedStatement.setString(2, hr.getName());
			preparedStatement.setString(3, hr.getSurname());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}

	}

	public HumanResource readHr(HumanResource hr) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			int idhr = hr.getId();
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, idhr);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String user, name, surname;

			name = resultSet.getString("name");
			surname = resultSet.getString("surname");
			int userId = resultSet.getInt("iduser");
			Users User = new Users(null, null, null);
			User.setIduser(userId);

			hr = new HumanResource(User, name);

			hr.setId(resultSet.getInt("idHR"));

			return hr;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return null;
		}

	}

	public boolean updateHr(HumanResource hrToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (hrToUpdate.getId() == 0)
			return false;

		// Client clientRead = readClient(clientToUpdate);
		// if (!clientRead.equals(clientToUpdate)) {

		try {
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
			preparedStatement.setInt(1, hrToUpdate.getUser().getIduser());
			preparedStatement.setString(2, hrToUpdate.getName());
			preparedStatement.setString(3, hrToUpdate.getSurname());
			preparedStatement.setInt(4, hrToUpdate.getId());
			int a = preparedStatement.executeUpdate();

			if (a > 0)
				return true;
			else
				return false;
		} catch (SQLException e) {
			return false;
		}

	}

	public boolean deleteHr(HumanResource hr) {
		Connection connection = ConnectionSingleton.getInstance();

		try {
			int id = hr.getId();
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, id);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;
		} catch (SQLException e) {
		}
		return false;

	}
}