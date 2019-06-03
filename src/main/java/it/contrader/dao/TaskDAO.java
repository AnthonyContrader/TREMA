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
import it.contrader.model.Task;
import it.contrader.model.Project;
import it.contrader.model.HumanResource;

public class TaskDAO {
	/*
	private String strSQL = "SELECT t.idtask, t.descrizione_task as task, p.name as project, hr.name as hr "
						  + "FROM task t"
						  	+ "INNER JOIN project p on p.idproject = t.idproject "
						  	+ "INNER JOIN humanresource hr on hr.idHR = t.idHR";
	
	private final String QUERY_ALL = strSQL;
	private final String QUERY_ReadByIdProject = strSQL + " where idproject=?";
	private final String QUERY_ReadByIdHR = strSQL + " where idhr=?";
	*/
	
	private final String QUERY_ALL = "SELECT * FROM task";
	private final String QUERY_INSERT = "INSERT INTO task (descrizione_task, idproject, idHR) values (?,?,?)";
	private final String QUERY_READ = "SELECT * FROM task WHERE idtask=(?)";
	private final String QUERY_UPDATE = "UPDATE task SET descrizione_task=?, idproject=?, idHR=? WHERE idtask = (?)";
	private final String QUERY_DELETE = "DELETE FROM task WHERE idtask = (?)";
	
	public TaskDAO() {

	}
	
	public List<Task> getAllTask() {
		List<Task> taskList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		
		try {
			//Statement statement = connection.createStatement();
			//ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_ALL);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				Integer idtask = resultSet.getInt("idtask");
				String descrizione_task = resultSet.getString("descrizione_task");
				Integer idproject = resultSet.getInt("idproject");
				Integer idhr = resultSet.getInt("idHR");
				
				Project projectClient = new Project(null, null, null, null);
				projectClient.setProjectId(idproject);
				HumanResource hrClient = new HumanResource("", "", null);
				hrClient.setId(idhr);
				
				Task task = new Task(descrizione_task, projectClient, hrClient);
				task.setIdtask(idtask);
				taskList.add(task);
			}
			
			return taskList;
		} 
		catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return null;
		}
	}
	
	public boolean insertTask(Task task) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
			preparedStatement.setString(1, task.getDescrizione_task());
			preparedStatement.setInt(2, task.getProject().getProjectId());
			preparedStatement.setInt(3, task.getHR().getId());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}
	}
	
	public Task readTask(Task task) {
		Connection connection = ConnectionSingleton.getInstance();
		
		try {
			int idtask = task.getIdtask();
			
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, idtask);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			
			String descrizione_task = resultSet.getString("descrizione_task");
			Integer idproject = resultSet.getInt("idproject");
			Integer idhr = resultSet.getInt("idHR");
						
			Project projectClient = new Project(null, null, null, null);
			projectClient.setProjectId(idproject);
			HumanResource hrClient = new HumanResource("", "", null);
			hrClient.setId(idhr);
			
			task = new Task(descrizione_task, projectClient, hrClient);
			task.setIdtask(idtask);
						
			return task;
		} 

		catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return null;
		}
	}
	
	public boolean updateTask(Task taskToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_UPDATE);
			preparedStatement.setString(1, taskToUpdate.getDescrizione_task());
			preparedStatement.setInt(2, taskToUpdate.getProject().getProjectId());
			preparedStatement.setInt(3, taskToUpdate.getHR().getId());
			preparedStatement.setInt(4, taskToUpdate.getIdtask());
			int result = preparedStatement.executeUpdate();
			
			if (result > 0)
				return true;
			else
				return false;
		} 
		catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}
	}
	
	public boolean deleteTask(Task task) {
		Connection connection = ConnectionSingleton.getInstance();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, task.getIdtask());
			int result = preparedStatement.executeUpdate();
			
			if (result != 0)
				return true;
		} 
		catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}
		
		return false;
	}
}
