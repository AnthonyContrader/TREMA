package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import it.contrader.main.ConnectionSingleton;
import it.contrader.main.GestoreEccezioni;
import it.contrader.model.Project;

public class ProjectDAO implements DAO<Project> {

	private final String QUERY_ALL = "SELECT * FROM project WHERE idproject=?";
	private final String QUERY_INSERT = "INSERT INTO project (name,descrizione,tipo, iduser) VALUES (?,?,?,?)";
	private final String QUERY_READ = "SELECT * FROM project WHERE idproject=?";
	private final String QUERY_UPDATE = "UPDATE project SET name=?, descrizione=?, tipo=?, iduser=? WHERE idproject=?";
	private final String QUERY_DELETE = "DELETE FROM project WHERE idproject=?";

	public ProjectDAO() {

	}

	@Override
	public List<Project> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Project> getAllBy(Object o) {
		List<Project> progetti = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_ALL);
			int iduser = (Integer)o;
			preparedStatement.setInt(1, iduser);
			ResultSet resultSet = preparedStatement.executeQuery();
			Project project;
			while (resultSet.next()) {
				int Idproject = resultSet.getInt("idproject");
				String name = resultSet.getString("name");
				String descrizione = resultSet.getString("descrizione");
				String tipo = resultSet.getString("tipo");
				int Iduser = resultSet.getInt("iduser");
				project = new Project(Idproject,name, descrizione, tipo, Iduser);
				project.setIdproject(Idproject);
				project.setName(name);
				project.setDescrizione(descrizione);
				project.setTipo(tipo);
				project.setIduser(iduser);
				progetti.add(project);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return progetti;
	}

	@Override
	public Project read(int idproject) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1,idproject);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String name= resultSet.getString("name");
			String descrizione= resultSet.getString("descrizione");
			String tipo= resultSet.getString("tipo");
			int iduser = resultSet.getInt("iduser");
			Project project = new Project (name,descrizione,tipo ,iduser);
			project.setIdproject(resultSet.getInt("idproject"));
			return project;
		} 
		catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			
			return null;
		}
	}

	@Override
	public boolean insert (Project project) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
			preparedStatement.setString(1, project.getName());
			preparedStatement.setString(2, project.getDescrizione());
			preparedStatement.setString(3, project.getTipo());
			preparedStatement.setInt(4, project.getIduser());
			preparedStatement.execute();

			return true;

		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}
	}

	@Override
	public boolean update(Project project) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
			preparedStatement.setString(1, project.getName());
			preparedStatement.setString(2, project.getDescrizione());
			preparedStatement.setString(3, project.getTipo());
			preparedStatement.setInt(4, project.getIduser());
			preparedStatement.setInt(5, project.getIdproject());
			preparedStatement.executeUpdate();
		} 
		catch (SQLException e) {
			System.out.println("qualcosa è andato storto...\n");
			return false;
		}
		return true;
	}

	@Override
	public boolean delete(Project project) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			int idproject = project.getIdproject();
			preparedStatement.setInt(1, idproject);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;
		} catch (SQLException e) {
		}
		return false;
	}

	@Override
	public Project read(String param1, String param2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Project> getAllBy(Integer id, String Descrizione) {
		// TODO Auto-generated method stub
		return null;
	}


}
