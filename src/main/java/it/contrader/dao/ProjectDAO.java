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
import it.contrader.model.Project;
import it.contrader.model.Users;

public class ProjectDAO {

	private final String QUERY_ALL = "select * from project";
	private final String QUERY_INSERT = "insert into project (name, descrizione,tipo,iduser) values (?,?,?,?)";
	private final String QUERY_READ = "select * from project where idproject=?";

	private final String QUERY_UPDATE = "UPDATE project SET name=?, descrizione=?, tipo=?, iduser=? WHERE idproject=?";
	private final String QUERY_DELETE = "DELETE from project WHERE idproject=?";

	public ProjectDAO() {
	}

	public List<Project> getAllProject() {
		List<Project> projectList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Project project;
			while (resultSet.next()) {
				int userId = resultSet.getInt("iduser");
				Users userProject = new Users(null, null, null);
				userProject.setIduser(userId);

				String projectName = resultSet.getString("name");
				String descrizione = resultSet.getString("descrizione");
				String tipo = resultSet.getString("tipo");

				project = new Project(projectName,descrizione,tipo,userProject);
				project.setProjectId(resultSet.getInt("idproject"));
				projectList.add(project);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return projectList;
	}

	public boolean insertProject(Project project) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
			preparedStatement.setString(1, project.getProjectName());
			preparedStatement.setString(2, project.getTipo());
			preparedStatement.setString(3, project.getDescrizione());
			preparedStatement.setInt(4, project.getUser().getIduser());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}

	}

	public Project readProject(Project project) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			int projectId = project.getProjectId();
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, projectId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String projectName, descrizione, tipo, user;

			projectName = resultSet.getString("name");
			descrizione = resultSet.getString("descrizione");
			tipo = resultSet.getString("tipo");
			int userId = resultSet.getInt("iduser");
			Users userClient = new Users(null, null, null);
			userClient.setIduser(userId);

			project = new Project(projectName,descrizione,tipo,userClient);

			project.setProjectId(resultSet.getInt("idproject"));

			return project;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return null;
		}

	}

	public boolean updateProject(Project projectToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (projectToUpdate.getProjectId() == 0)
			return false;

		// Client clientRead = readClient(clientToUpdate);
		// if (!clientRead.equals(clientToUpdate)) {

		try {
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
			preparedStatement.setString(1, projectToUpdate.getProjectName());
			preparedStatement.setString(2, projectToUpdate.getDescrizione());
			preparedStatement.setString(3, projectToUpdate.getTipo());
			preparedStatement.setInt(4, projectToUpdate.getUser().getIduser());
			preparedStatement.setInt(5, projectToUpdate.getProjectId());
			int a = preparedStatement.executeUpdate();

			if (a > 0)
				return true;
			else
				return false;
		} catch (SQLException e) {
			return false;
		}

	}

	public boolean deleteProject(Project project) {
		Connection connection = ConnectionSingleton.getInstance();

		try {
			int projectId = project.getProjectId();
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, projectId);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;
		} catch (SQLException e) {
		}
		return false;

	}
}
