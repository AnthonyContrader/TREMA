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
import it.contrader.model.Material;
import it.contrader.model.HumanResource;

public class MaterialDAO {

	private final String QUERY_ALL = "SELECT * FROM material";
	private final String QUERY_INSERT = "INSERT INTO material (tipo, quantita, idHR) VALUES (?,?,?)";
	private final String QUERY_READ = "SELECT * FROM material WHERE idmaterial=?";
	private final String QUERY_UPDATE = "UPDATE material SET tipo=?, quantita=?, idHR=? WHERE idmaterial=?";
	private final String QUERY_DELETE = "DELETE FROM material WHERE idmaterial=?";
	
	public MaterialDAO() {

	}
	
	public List<Material> getAll() {
		List<Material> materialList = new ArrayList<Material>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Material material;
			while (resultSet.next()) {
				int idmaterial = resultSet.getInt("idmaterial");
				int quantita = resultSet.getInt("quantita");
				String tipo = resultSet.getString("tipo");
				int idhr = resultSet.getInt("idhr");
				
				HumanResource hrClient = new HumanResource(null, null, idhr);
				
				material = new Material(tipo, quantita, hrClient);
				material.setIdmaterial(idmaterial);
				materialList.add(material);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return materialList;
	}
	
	public boolean insert(Material material) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
			preparedStatement.setString(1, material.getTipo());
			preparedStatement.setInt(2, material.getQuantita());
			preparedStatement.setInt(3, material.getHR().getIdHR());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}
	}
	
	public Material read(Material material) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			int idmaterial = material.getIdmaterial();
			
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, idmaterial);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			
			String tipo = resultSet.getString("quantita");
			int quantita = resultSet.getInt("tipo");
			int idhr = resultSet.getInt("idhr");
			
			HumanResource hrClient = new HumanResource(null, null, idhr);
				
			material = new Material(tipo, quantita, hrClient);
			material.setIdmaterial(idmaterial);
			
			return material;
			
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return null;
		}
	}

	public boolean update(Material materialToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();
		
		if (materialToUpdate.getIdmaterial() == 0)
			return false;
		
		try {
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
			preparedStatement.setString(1, materialToUpdate.getTipo());
			preparedStatement.setInt(2, materialToUpdate.getQuantita());
			preparedStatement.setInt(3, materialToUpdate.getHR().getIdHR());
			int result = preparedStatement.executeUpdate();
			
			if (result > 0)
				return true;
			else
				return false;
		} 
		catch (SQLException e) {
			return false;
		}
	}
	
	public boolean delete(Material material) {
		Connection connection = ConnectionSingleton.getInstance();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			int idmaterial = material.getIdmaterial();
			preparedStatement.setInt(1, idmaterial);
			int result = preparedStatement.executeUpdate();
			
			if (result != 0)
				return true;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}
		
		return false;
	}
}
