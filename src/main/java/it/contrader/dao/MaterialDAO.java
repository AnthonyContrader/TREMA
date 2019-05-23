package it.contrader.dao;

import it.contrader.main.ConnectionSingleton;
import it.contrader.controller.GestoreEccezioni;
import it.contrader.model.Material;
import wmes.model.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MaterialDAO {
	
	private final String QUERY_SELECT_ALL = "select * from material";
	private final String QUERY_INSERT = "insert into material (Name, Model, Category, Inventory) values (?,?,?,?)";
	private final String QUERY_UPDATE = "UPDATE material SET Name=?, Model=?, Category=?, Inventory=? WHERE idMaterial=?";
	private final String QUERY_DELETE = "delete from material where idMaterial=?";
	//private final String QUERY_SELECT_ID = "select * from material where idMaterial=?";
	
	public MaterialDAO() {}
	
	public List<Material> getAllMaterials () {
        List<Material> materiales = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        
        try {
        	Statement statement = connection.createStatement();
        	ResultSet resultSet = statement.executeQuery(QUERY_SELECT_ALL);
        	
        	while (resultSet.next()) {
        		int idmaterial = resultSet.getInt("idMaterial");
	            String name = resultSet.getString("Name");
	            String model = resultSet.getString("Model");
	            String category = resultSet.getString("Category");
	            int inventory = resultSet.getInt("Inventory");
	            
	            materiales.add(new Material(idmaterial, name, model, inventory, category));
	        }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return materiales;
    }
	
	/*
	public List<Material> getAllOrder() {
		List<Material> materialList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_SELECT_ALL);
				
			Material material;
			while (resultSet.next()) {
				int idmaterial = resultSet.getInt("idMaterial");
				String name = resultSet.getString("Name");
				String model = resultSet.getString("Model");
				String category = resultSet.getString("Category");
				int inventory = resultSet.getInt("Inventory");
				
				material = new Material(idmaterial, name, model, inventory, category);
				materialList.add(material);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return materialList;
	} */
	
	public void insertMaterial (String name, String model, String category, int inventory) {
		 
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_INSERT);
            statement.setString(1, name);
            statement.setString(2, model);
            statement.setString(3, category);
            statement.setInt(3, inventory);
            
            statement.executeUpdate();
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
        }

	}
	
	public void updateMaterial (String name, String model, String category, int inventory) {
		 
        Connection connection = ConnectionSingleton.getInstance();
        
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_UPDATE);
            statement.setString(1, name);
            statement.setString(2, model);
            statement.setString(3, category);
            statement.setInt(3, inventory);
            
            statement.executeUpdate();
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
        }

	}
	
	public void deleteMaterial (int idMaterial) {
		 
        Connection connection = ConnectionSingleton.getInstance();
        
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_DELETE);
            statement.setInt(1, idMaterial);
            
            statement.executeUpdate();
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
        }

}

}

