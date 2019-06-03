package it.contrader.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.contrader.main.ConnectionSingleton;
import it.contrader.main.GestoreEccezioni;
import it.contrader.model.HumanResource;
import it.contrader.model.Users;

public class HumanResourceDAO{

	private final String QUERY_ALL = "SELECT * FROM humanresource";
	private final String QUERY_INSERT = "INSERT INTO humanresource (name, surname, iduser) VALUES (?,?,?)";
	private final String QUERY_READ = "SELECT * FROM humanresource WHERE idHR=?";
	private final String QUERY_UPDATE = "UPDATE humanresource SET name=?, surname=?, iduser=? WHERE idHR=?";
	private final String QUERY_DELETE = "DELETE FROM humanresource WHERE idHR=?";
	private final String QUERY_NS = "SELECT name,surname FROM humanresource WHERE idHR=?";

	public HumanResourceDAO() {
	}

	public List<HumanResource> getAllHr() {
		List<HumanResource> hrList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			HumanResource hr;
			while (resultSet.next()) {
				int userId = resultSet.getInt("iduser");
				Users userhr = new Users(null, null, null);
				userhr.setIduser(userId);

				String name = resultSet.getString("name");
				String surname = resultSet.getString("surname");

				hr = new HumanResource(name,surname, userhr);
				hr.setId(resultSet.getInt("idHR"));
				hrList.add(hr);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return hrList;
	}

	public boolean insertHr(HumanResource hr) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
			preparedStatement.setString(1, hr.getName());
			preparedStatement.setString(2, hr.getSurname());
			preparedStatement.setInt(3, hr.getUser().getIduser());
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
			String name, surname;

			name = resultSet.getString("name");
			surname = resultSet.getString("surname");
			int userId = resultSet.getInt("iduser");
			Users User = new Users(null, null, null);
			User.setIduser(userId);

			hr = new HumanResource(name, surname, User);

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
			preparedStatement.setString(1, hrToUpdate.getName());
			preparedStatement.setString(2, hrToUpdate.getSurname());
			preparedStatement.setInt(3, hrToUpdate.getUser().getIduser());
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

	public HumanResource login(String name, String surname) {

		Connection connection = ConnectionSingleton.getInstance();
		HumanResource hr = null;
		try {
			PreparedStatement statement = connection.prepareStatement(QUERY_ALL);
			
			statement.setString(1, name);
			statement.setString(2, surname);
			statement.execute();
			ResultSet resultSet = statement.getResultSet();

			while (resultSet.next()) {
				String names = resultSet.getString("name");
				String sur = resultSet.getString("surname");
				hr = new HumanResource(names, sur);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return hr;
	}

	public HumanResource nameSurHr(HumanResource hr) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			int idhr = hr.getId();
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_NS);
			preparedStatement.setInt(1, idhr);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			
			String name, surname;

			name = resultSet.getString("name");
			surname = resultSet.getString("surname");

			hr = new HumanResource(name, surname);

			hr.setId(resultSet.getInt("idHR"));

			return hr;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return null;
		}
	}
}