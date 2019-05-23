package it.contrader.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.contrader.controller.GestoreEccezioni;
import it.contrader.main.ConnectionSingleton;
import it.contrader.model.User;

public class LoginDAO {

	private final String QUERY_LOGIN = "select * from users where Username = ? and Password = ?";

	public User login(String username, String password) {

		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement statement = connection.prepareStatement(QUERY_LOGIN);
			statement.setString(1, username);
			statement.setString(2, password);

			ResultSet rs = statement.executeQuery();

			if (rs.next()) {
				return new User(rs.getInt("idUser"), rs.getString("Username"), rs.getString("Password"));
			} else {
				return null;
			}

		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return null;
		}
	}
}
