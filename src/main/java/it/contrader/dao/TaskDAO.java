package it.contrader.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.fabric.xmlrpc.base.Array;

import it.contrader.model.Task;
import it.contrader.model.Users;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.utils.GestoreEccezioni;

public class TaskDAO {
	private final String GET_ALL = "select * from users";
	private final String QUERY_INSERT = "INSERT INTO task (descrizione_task, idproject, idHR) values (?,?,?)";
	private final String QUERY_DELETE = "DELETE FROM task WHERE idtask = (?)";
	private final String QUERY_UPDATE = "UPDATE task SET descrizione_task, idproject, idHR =(?,?,?) WHERE idtask = (?)";
	private final String QUERY_READ = "select * from task where idtask=(?)";
	
	public List<Task> getAllUsers() {
		final List<Task> tasks = new ArrayList<>();
		final Connection connection = ConnectionSingleton.getInstance();

		try {
			final Statement statement = connection.createStatement();
			final ResultSet resultSet = statement.executeQuery(GET_ALL);
			
			while (resultSet.next()) {
				final Integer idtask = resultSet.getInt("idtask");
				final String descrizione_task = resultSet.getString("descrizione_task");
				final Integer idproject = resultSet.getInt("idproject");
				final Integer idHR = resultSet.getInt("idHR");

				Task task = new Task(descrizione_task, idproject, idHR);
				task.setIdtask(idtask);
				tasks.add(task);
			}
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return tasks;
	}
	
	public Task readTask(Integer idtask) {
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
	
	public boolean insertTask(Task tasks) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
			preparedStatement.setString(1, tasks.getDescrizione_task());
			preparedStatement.setInt(2, tasks.getIdproject());
			preparedStatement.setInt(3, tasks.getIdHR());
			return true;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}
	}
	
	public boolean updateTask(Task tasks) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_UPDATE);
			preparedStatement.setString(1, tasks.getDescrizione_task());
			preparedStatement.setInt(2, tasks.getIdproject());
			preparedStatement.setInt(3, tasks.getIdHR());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}
	}
	
	public boolean deleteTask(Task tasks) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, tasks.getIdtask());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}
	}
}
