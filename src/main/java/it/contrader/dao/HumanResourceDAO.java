package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import it.contrader.controller.GestoreEccezioni;
import it.contrader.main.ConnectionSingleton;
import it.contrader.model.HumanResource;

public class HumanResourceDAO {

	private final String QUERY_ALL = "SELECT * FROM humanresource";
	private final String QUERY_INSERT = "INSERT INTO humanresource (name, surname, iduser) VALUES (?,?,?)";
	private final String QUERY_READ = "SELECT * FROM humanresource WHERE idHR=?";
	private final String QUERY_UPDATE = "UPDATE humanresource SET name=?, surname=?, user=? WHERE idHR=?";
	private final String QUERY_DELETE = "DELETE FROM humanresource WHERE id=?";

	public HumanResourceDAO() {}

	public List<HumanResource> getAllHR() {
		List<HumanResource> hrs = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			HumanResource hr;
			
			while (resultSet.next()) {
				int idhr = resultSet.getInt("idHR");
				String name = resultSet.getString("name");
				String surname = resultSet.getString("surname");
				int iduser = resultSet.getInt("iduser");
				hr = new HumanResource(idhr, iduser, name, surname);
				hr.setidHR(idhr);
				
				hrs.add(hr);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return hrs;
	}

	public boolean insertHR(HumanResource hr) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
			preparedStatement.setString(1, hr.getName());
			preparedStatement.setString(2, hr.getSurname());
			preparedStatement.setInt(3, hr.getidUser());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}

	}

	public HumanResource readHR(int idhr) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, idhr);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			
			int userid = resultSet.getInt("user");
			String name = resultSet.getString("name");
			String surname = resultSet.getString("surname");

			HumanResource hr = new HumanResource(idhr, userid, name, surname);
			hr.setidHR(resultSet.getInt("idHR"));

			return hr;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return null;
		}
	}

	public boolean updateHR(HumanResource hrToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (hrToUpdate.getidHR() == 0)
			return false;

		HumanResource userRead = readHR(hrToUpdate.getidHR());
		if (!userRead.equals(hrToUpdate)) {
			try {
				// Fill the userToUpdate object
				if (hrToUpdate.getName() == null || hrToUpdate.getName().equals("")) {
					hrToUpdate.setName(userRead.getName());
				}
				
				if (hrToUpdate.getSurname() == null || hrToUpdate.getSurname().equals("")) {
					hrToUpdate.setName(userRead.getSurname());
				}
				
				if (hrToUpdate.getidUser() == 0 ) {
					hrToUpdate.setidUser(userRead.getidUser());
				}

				// Update the user
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, hrToUpdate.getName());
				preparedStatement.setString(2, hrToUpdate.getSurname());
				preparedStatement.setInt(3, hrToUpdate.getidUser());
				preparedStatement.setInt(4, hrToUpdate.getidHR());
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

	public boolean deleteHR(int idhr) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, idhr);
			int n = preparedStatement.executeUpdate();
			
			if (n != 0)
				return true;
		} catch (SQLException e) {
		}
		return false;
	}

}