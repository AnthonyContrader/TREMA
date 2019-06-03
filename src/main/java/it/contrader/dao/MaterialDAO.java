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

public class MaterialDAO {

	private final String QUERY_ALL = "select * from material";
	private final String QUERY_INSERT = "insert into material (tipo, quantita,iduser) values (?,?,?)";
	private final String QUERY_READ = "select * from material where idmaterial=?";
	private final String QUERY_UPDATE = "UPDATE material SET tipo=?, quantita=?, iduser=? WHERE idmaterial=?";
	private final String QUERY_DELETE = "DELETE from material WHERE idmaterial=?";
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
				Users userMaterial = new Users(null, null, null);
				userMaterial.setIduser(userId);
				
				String tipo = resultSet.getString("tipo");
				int quantita = resultSet.getInt("quantita");
				
				material = new Material(tipo, quantita, userMaterial);
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
			preparedStatement.setInt(3, material.getUser().getIduser());
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
			
			tipo = resultSet.getString("tipo");
			int quantita = resultSet.getInt("quantita");
			int userId = resultSet.getInt("iduser");
			Users userClient = new Users(null, null, null);
			userClient.setIduser(userId);
			
			material = new Material(tipo, quantita, userClient);
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
			preparedStatement.setInt(3, materialToUpdate.getUser().getIduser());
			preparedStatement.setInt(4, materialToUpdate.getIdmaterial());
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
