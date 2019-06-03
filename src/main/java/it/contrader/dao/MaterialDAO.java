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
import it.contrader.model.Users;
import it.contrader.model.HumanResource;

public class MaterialDAO {

	private final String QUERY_ALL = "SELECT * FROM material";
	private final String QUERY_INSERT = "INSERT INTO material (tipo, quantita, idHR) VALUES (?,?,?)";
	private final String QUERY_READ = "SELECT * FROM material WHERE idmaterial=?";
	private final String QUERY_UPDATE = "UPDATE material SET tipo=?, quantita=?, idHR=? WHERE idmaterial=?";
	private final String QUERY_DELETE = "DELETE FROM material WHERE idmaterial=?";
	
	public MaterialDAO() {

	}
	
	public List<Material> getAllMaterial() {
		List<Material> materialList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Material material;
			while (resultSet.next()) {
				int userId = resultSet.getInt("iduser");
				Users HrMaterial = new Users(null, null, null);
				HrMaterial.setIduser(userId);
				
				String tipo = resultSet.getString("tipo");
				int quantita = resultSet.getInt("quantita");
				
				material = new Material(tipo, quantita, HrMaterial);
				material.setIdmaterial(resultSet.getInt("idmaterial"));
				materialList.add(material);
	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return materialList;
	}
	
	public boolean insertMaterial(Material material) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
			preparedStatement.setString(1, material.getTipo());
			preparedStatement.setInt(2, material.getQuantita());
			preparedStatement.setInt(3, material.getHR().getIduser());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}
	}
	
	public Material readMaterial(Material material) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			int idmaterial = material.getIdmaterial();
			
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, idmaterial);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			
			String tipo;
			int quantita, hr;
			
			tipo = resultSet.getString("tipo");
			quantita = resultSet.getInt("quantita");
			hr = resultSet.getInt("iduser");
			Users hrClient = new Users(null, null, null);
			hrClient.setIduser(hr);
			
			material = new Material(tipo, quantita, hrClient);
			material.setIdmaterial(resultSet.getInt("idmaterial"));
			
			return material;
			
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return null;
		}
	}

	public boolean updateMaterial(Material materialToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();
		
		if (materialToUpdate.getIdmaterial() == 0)
			return false;
		
		try {
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
			preparedStatement.setString(1, materialToUpdate.getTipo());
			preparedStatement.setInt(2, materialToUpdate.getQuantita());
			preparedStatement.setInt(3, materialToUpdate.getHR().getIduser());
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
	
	public boolean deleteMaterial(Material material) {
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
