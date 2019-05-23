package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import it.contrader.controller.GestoreEccezioni;
import it.contrader.main.ConnectionSingleton;
import it.contrader.model.*;

public class MaterialDAO {
	
	private final String QUERY_ALL = "SELECT * FROM material WHERE idHR=?";
	private final String QUERY_INSERT = "INSERT INTO material (tipo, building) VALUES (?,?)";
	private final String QUERY_READ = "SELECT * FROM material WHERE idHR=? AND  idmaterial=?";
	private final String QUERY_UPDATE = "UPDATE material SET tipo=?, idHR=? WHERE idmaterial=?";
	private final String QUERY_DELETE = "DELETE FROM material WHERE idmaterial=?";
	
	public MaterialDAO() {}
	
	public List<Material> showAllMaterial(int idHR) {
		List<Material> materials = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_ALL);
			preparedStatement.setInt(1, idHR);
			ResultSet resultSet = preparedStatement.executeQuery();
			Material material;
			
			while (resultSet.next()) {
				int idmaterial = resultSet.getInt("idmaterial");
				String descrizione = resultSet.getString("tipo");
				int idhr = resultSet.getInt("idHR");
				
				material = new Material(idmaterial, idhr, descrizione);
				material.setidMaterial(idmaterial);
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
			preparedStatement.setString(1, material.getTipo());
			preparedStatement.setInt(2, material.getidMaterial());
			preparedStatement.execute();

			return true;

		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}

	}

	public Material readMaterial(int idhr, int idmaterial) {
		Connection connection = ConnectionSingleton.getInstance();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1,idhr);
			preparedStatement.setInt(2,idmaterial);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();

			String descrizione= resultSet.getString("tipo");
			idhr = resultSet.getInt("idHR");

			Material material = new Material(idmaterial, idhr, descrizione);
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
			preparedStatement.setString(1, materialToUpdate.getTipo());
			preparedStatement.setInt(2, materialToUpdate.getIdHR());
			preparedStatement.setInt(3, materialToUpdate.getidMaterial());
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
