package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import it.contrader.controller.GestoreEccezioni;
import it.contrader.main.ConnectionSingleton;
import it.contrader.model.*;

public class MaterialDAO {
	
	private final String QUERY_ALL = "SELECT * FROM material";
	private final String QUERY_INSERT = "INSERT INTO material (idmaterial, tipo, quantita, idHR) VALUES (?,?,?,?)";
	private final String QUERY_READ = "SELECT * FROM material WHERE idmaterial=?";
	private final String QUERY_UPDATE = "UPDATE material SET tipo=?, quantita=?, idHR=? WHERE idmaterial=?";	
	private final String QUERY_DELETE = "DELETE FROM material WHERE idmaterial=?";
	
	public MaterialDAO() {}
	
	public List<Material> getAllMaterial() {
		List<Material> materials = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Material material;
			
			while (resultSet.next()) {
				int idmaterial = resultSet.getInt("idmaterial");
				String tipo = resultSet.getString("tipo");
				int quantita = resultSet.getInt("quantita");
				int idhr = resultSet.getInt("idHR");
				material = new Material(idmaterial, tipo, quantita, idhr);
				material.setidMaterial(idmaterial);
				material.setIdHR(idhr);
				material.setTipo(tipo);
				material.setQuantita(quantita);
				materials.add(material);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return materials;
	}

	public boolean insertMaterial(Material material) {
		Connection connection = ConnectionSingleton.getInstance();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
			preparedStatement.setInt(1, material.getidMaterial());
			preparedStatement.setString(2, material.getTipo());
			preparedStatement.setInt(3, material.getQuantita());
			preparedStatement.setInt(4, material.getIdHR());
			preparedStatement.execute();

			return true;

		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}

	}

	public Material readMaterial(int idmateriale) {
		Connection connection = ConnectionSingleton.getInstance();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, idmateriale);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
		
			String tipo= resultSet.getString("tipo");
			int quantita=resultSet.getInt("quantita");
			int idhr = resultSet.getInt("idHR");
			Material material = new Material(idmateriale, tipo, quantita, idhr);;
			material.setidMaterial(resultSet.getInt("idmaterial"));
			return material;
		} 
		catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return null;
		}
	}

	public boolean updateMaterial(Material materialToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
			preparedStatement.setString(2, materialToUpdate.getTipo());
			preparedStatement.setInt(3, materialToUpdate.getQuantita());
			preparedStatement.setInt(4, materialToUpdate.getIdHR());
			preparedStatement.setInt(1, materialToUpdate.getidMaterial());
			preparedStatement.executeUpdate();
		} 
		catch (SQLException e) {
			System.out.println("Error...\n");
			return false;
		}

		return true;
	}		
			
	
	public boolean deleteMaterial(int idmaterial) {
		Connection connection = ConnectionSingleton.getInstance();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, idmaterial);
			int n = preparedStatement.executeUpdate();
			
			if (n != 0)
				return true;
		} catch (SQLException e) {
		}
		return false;
	}

}