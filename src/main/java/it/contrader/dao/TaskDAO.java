package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import it.contrader.utils.ConnectionSingleton;
import it.contrader.utils.GestoreEccezioni;
import it.contrader.model.Ambiente;
import it.contrader.model.Task;

public class TaskDAO {
	private String strSQL = "SELECT t.idtask, t.descrizione_task as task, p.name as project, hr.name as hr "
						  + "FROM task t"
						  	+ "INNER JOIN project p on p.idproject = t.idproject "
						  	+ "INNER JOIN humanresource hr on hr.idHR = t.idHR";
	
	private final String QUERY_ALL = strSQL;
	private final String QUERY_ReadByIdProject = strSQL + " where idproject=?";
	private final String QUERY_ReadByIdHR = strSQL + " where idhr=?";
	private final String QUERY_INSERT = "INSERT INTO task (descrizione_task, idproject, idHR) values (?,?,?)";
	private final String QUERY_DELETE = "DELETE FROM task WHERE idtask = (?)";
	private final String QUERY_UPDATE = "UPDATE task SET descrizione_task, idproject, idHR =(?,?,?) WHERE idtask = (?)";
	private final String QUERY_READ = "select * from task where idtask=(?)";
	
	public TaskDAO() {

	}
	
	public List<Task> getAll() {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			
			Integer idtask = resultSet.getInt("idtask");
			String descrizione_task = resultSet.getString("descrizione_task");
			Integer idproject = resultSet.getInt("idproject");
			Integer idhr = resultSet.getInt("idHR");
			String project = resultSet.getString("project");
			String hr = resultSet.getString("hr");
			
			Task task = new Task(idtask, descrizione_task, idproject, project, idhr, hr);
			
			//task.setIdtask(idtask);
			task.add(task);
			
			return task;
		} 
		catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			
			return null;
		}
	}
	
	public List<Task> getAllBy(Integer id, String Descrizione) {
		List<Task> tasks = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		
		try {
			//int id = (Integer) o;
			PreparedStatement preparedStatement = null;
			
			switch (Descrizione) {
			case "project":
				preparedStatement = connection.prepareStatement(QUERY_ReadByIdProject);
				break;
			case "hr":
				preparedStatement = connection.prepareStatement(QUERY_ReadByIdHR);
				break;
			default:
				return null;
			}
			
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				Integer idtask = resultSet.getInt("idtask");
				String descrizione_task = resultSet.getString("descrizione_task");
				Integer idproject = resultSet.getInt("idproject");
				Integer idhr = resultSet.getInt("idHR");
				String project = resultSet.getString("project");
				String hr = resultSet.getString("hr");
				
				Task task = new Task(idtask, descrizione_task, idproject, project, idhr, hr);
				
				//task.setIdtask(idtask);
				tasks.add(task);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return tasks;
	}
	
	public List<Task> getAllBy(Object o) {
		return null;
	}
	
	public Task ReadTask(Integer idtask) {
		Connection connection = ConnectionSingleton.getInstance();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1,idtask);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			
			String descrizione_task = resultSet.getString("descrizione_task");
			Integer idproject = resultSet.getInt("idproject");
			Integer idHR = resultSet.getInt("idHR");
						
			Task task = new Task (descrizione_task, idproject, idHR);
			task.setIdtask(resultSet.getInt("idtask"));
			
			return task;
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
			preparedStatement.setInt(2, task.getIdproject());
			preparedStatement.setInt(3, task.getIdHR());
			return true;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}
	}
	
	public boolean updateTask(Task task) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_UPDATE);
			preparedStatement.setString(1, task.getDescrizione_task());
			preparedStatement.setInt(2, task.getIdproject());
			preparedStatement.setInt(3, task.getIdHR());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}
	}
	
	public boolean deleteTask(Task task) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, task.getIdtask());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}
	}
}
