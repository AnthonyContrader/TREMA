package it.contrader.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.fabric.xmlrpc.base.Array;

import it.contrader.model.Material;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.utils.GestoreEccezioni;

public class MaterialDAO {


	private final String GET_ALL = "select * from material";
	private final String QUERY_READ   = "READ FROM material (idmaterial, tipo, quantita, idHR) values (?,?,?,?)";
	private final String QUERY_INSERT = "INSERT INTO material (idmaterial, tipo, quantita, idHR) values (?,?,?,?)";
	private final String QUERY_DELETE = "DELETE FROM material WHERE idmaterial = (?)";
	private final String QUERY_UPDATE = "UPDATE material SET tipo, quantita, idHR =(?,?,?) WHERE idmaterial = (?)";
	

	

	public List<Material> getAllMaterial() {

		final List<Material> material = new ArrayList<>();
		final Connection connection = ConnectionSingleton.getInstance();

		try {
			final Statement statement = connection.createStatement();
			final ResultSet resultSet = statement.executeQuery(GET_ALL);
			while (resultSet.next()) {
				final int idmaterial = resultSet.getInt("idmaterial");
				final String tipo = resultSet.getString("tipo");
				final int quantita = resultSet.getInt("quantita");
				final int idHR = resultSet.getInt("idHR");

				material.add(new Material(idmaterial, tipo, quantita, idHR));
			}
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return material;
	}
	
	public Material readMaterial(int idmaterial) {                  //maybe exist errors
		Connection connection = ConnectionSingleton.getInstance();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, idmaterial);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
		
			String tipo= resultSet.getString("tipo");
			int quantita=resultSet.getInt("quantita");
			int idhr = resultSet.getInt("idHR");
			Material material = new Material(idmaterial, tipo, quantita, idhr);;
			material.setIdmaterial (resultSet.getInt("idmaterial"));
			return material;
		} 
		catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return null;
		}
	}
	// Inserimento materiale

	public boolean insertMaterial(Material material) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
			preparedStatement.setInt(1, material.getIdmaterial());
			preparedStatement.setString(2, material.getTipo());
			preparedStatement.setInt(3, material.getQuantita());
			preparedStatement.setInt(4, material.getIdHR());
			return true;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}
	}

	// cancella materiale
	public boolean deleteMaterial(Material material) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, material.getIdmaterial());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}
	}

	// Modifica materiale

	public boolean updateMaterial(Material material) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_UPDATE);
			preparedStatement.setString(1, material.getTipo());
			preparedStatement.setInt(2, material.getQuantita());
			preparedStatement.setInt(3, material.getIdHR());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {

			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}

	}
}
