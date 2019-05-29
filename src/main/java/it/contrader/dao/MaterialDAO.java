package it.contrader.dao;

import java.sql.*;


import java.util.ArrayList;
import java.util.List;
import it.contrader.model.Material;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.utils.GestoreEccezioni;

public class MaterialDAO implements DAO<Material> {

	public MaterialDAO() {

	}

	private final String QUERY_ALL = "SELECT * FROM item";
	private final String QUERY_BY_IDHR = "SELECT * FROM material WHERE idHR=?";
	private final String QUERY_READ = "SELECT * FROM material WHERE idmaterial=?";
	private final String QUERY_UPDATE = "UPDATE material SET quantita=?, tipo=? WHERE idmaterial=?";
	private final String QUERY_INSERT = "INSERT INTO material (quantita, tipo,idHR) VALUES (?,?,?)";
	private final String QUERY_DELETE = "DELETE FROM material WHERE idmaterial=?";

	@Override
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
				int idHR = resultSet.getInt("idHR");
				material = new Material(idmaterial, tipo, quantita, idHR);
				materialList.add(material);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return materialList;
	}
	
	@Override
	public List<Material> getAllBy(Object o) {
		List<Material> materials = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_BY_IDHR);
			int idHR = (Integer)o;
			preparedStatement.setInt(1, idHR);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				int idmaterial = resultSet.getInt("idmatrial");
				int quantita = resultSet.getInt("quantita");
				String tipo = resultSet.getString("tipo");
				int idhR = resultSet.getInt("idHR");
				Material material = new Material(idmaterial, tipo, quantita, idhR);
				materials.add(material);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return materials;
	}

	@Override
	public Material read(int idmaterial) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, idmaterial);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			int quantita = resultSet.getInt("quantita");
			String tipo = resultSet.getString("tipo");
			int idHR = resultSet.getInt("idHR");
			Material material = new Material(idmaterial, tipo, quantita, idHR);
			return material;
			
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return null;
		}
	}

	@Override
	public boolean insert(Material material) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
			preparedStatement.setInt(1, material.getQuantita());
			preparedStatement.setString(2, material.getTipo());
			preparedStatement.setInt(3, material.getIdHR());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}
	}

	@Override
	public boolean update(Material material) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
			preparedStatement.setInt(1, material.getQuantita());
			preparedStatement.setString(2, material.getTipo());
			preparedStatement.setInt(3, material.getIdmaterial());
			preparedStatement.executeUpdate();
		} 
		catch (SQLException e) {
			return false;
		}
		return true;
	}
		

	@Override
	public boolean delete(Material material) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			int idmaterial = material.getIdmaterial();
			preparedStatement.setInt(1, idmaterial);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;
			return false;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}


	}

	@Override
	public Material read(String param1, String param2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Material> getAllBy(Integer id, String Descrizione) {
		// TODO Auto-generated method stub
		return null;
	}
}
