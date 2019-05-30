package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import it.contrader.main.*;
import it.contrader.model.HumanResource;

public class HumanResourceDAO implements DAO<HumanResource>{

	private final String QUERY_ALL = "SELECT * FROM humanresource";
	private final String QUERY_INSERT = "INSERT INTO humanresource (name, surname, iduser) VALUES (?,?,?)";
	private final String QUERY_READ = "SELECT * FROM humanresource WHERE idHR=?";
	private final String QUERY_UPDATE = "UPDATE humanresource SET name=?, surname=?, iduser=? WHERE idHR=?";
	private final String QUERY_DELETE = "DELETE FROM humanresource WHERE idHR=?";

	public HumanResourceDAO() {}
	
@Override
	public List<HumanResource> getAll() {
		List<HumanResource> hrlist = new ArrayList<HumanResource>();
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
				hr = new HumanResource(idhr, name, surname, iduser);
				hrlist.add(hr);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return hrlist;
	}

@Override
	public boolean insert(HumanResource hr) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
			preparedStatement.setString(1, hr.getName());
			preparedStatement.setString(2, hr.getSurname());
			preparedStatement.setInt(3, hr.getIduser());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}

	}

@Override
	public HumanResource read(int idhr) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, idhr);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			
			int userid = resultSet.getInt("iduser");
			String name = resultSet.getString("name");
			String surname = resultSet.getString("surname");
			HumanResource hr = new HumanResource(idhr, name, surname, userid);
			return hr;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return null;
		}
	}

@Override
	public boolean update(HumanResource hrToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (hrToUpdate.getIdHR() == 0)
			return false;
	
			try {
				// Update the user
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setInt(1, hrToUpdate.getIdHR());
				preparedStatement.setString(2, hrToUpdate.getName());
				preparedStatement.setString(3, hrToUpdate.getSurname());
				preparedStatement.setInt(4, hrToUpdate.getIduser());
				int a = preparedStatement.executeUpdate();
				if (a > 0)
					return true;
				else
					return false;

			} catch (SQLException e) {
				return false;
			}
	}

@Override
	public boolean delete(HumanResource hr) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, hr.getIdHR());
			int n = preparedStatement.executeUpdate();
			
			if (n != 0)
				return true;
		} catch (SQLException e) {
		}
		return false;
	}

@Override
public List<HumanResource> getAllBy(Object o) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public List<HumanResource> getAllBy(Integer id, String Descrizione) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public HumanResource read(String param1, String param2) {
	// TODO Auto-generated method stub
	return null;
}
}


