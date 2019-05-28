package it.contrader.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.fabric.xmlrpc.base.Array;

import it.contrader.model.Project;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.utils.GestoreEccezioni;

public class ProjectDAO {

	/**
	 * Qui possiamo se vogliamo dichiarare delle stringhe rappresentanti le query
	 * che verranno utilizzate dai service, Non è obbligatorio ma è consigliato
	 * usare un ordine e dei nomi significativi per tutte le query. Con GET_ALL
	 * intendiamo recuperare tutte le tuple dal db. Se volessimo creare una query
	 * per l'inserimento, un nome identificativo potrebbe essere INSERT_ESEMPIO
	 */
	private final String QUERY_ALL = "select * from project";
	private final String QUERY_INSERT = "INSERT INTO project (name, descrizione, tipo, iduser) values (?,?,?,?)";
	private final String QUERY_DELETE = "DELETE FROM project WHERE idproject = (?)";
	private final String QUERY_UPDATE = "UPDATE project SET name, descrizione, tipo, iduser =(?,?,?,?) WHERE idproject = (?)";

	/**
	 * Il suddetto metodo si occupa interagire con il database e restituire tutte le
	 * tuple al servizio che ha chiamato questo metodo
	 */


	public List<Project> getAllProject() {

		final List<Project> project = new ArrayList<>();
		final Connection connection = ConnectionSingleton.getInstance();

		try {
			final Statement statement = connection.createStatement();
			final ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			while (resultSet.next()) {
				final Integer idproject = resultSet.getInt("idproject");
				final String name = resultSet.getString("name");
				final String descrizione = resultSet.getString("descrizione");
				final String tipo = resultSet.getString("tipo");
				final Integer iduser = resultSet.getInt("iduser");

				project.add(new Project(idproject, name, descrizione, tipo, iduser));
			}
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return project;
	}
	// Inserimento

	public boolean insertProject(Project project) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
			preparedStatement.setString(1, project.getName());
			preparedStatement.setString(2, project.getDescrizione());
			preparedStatement.setString(3, project.getTipo());
			preparedStatement.setInt(4, project.getIduser());
			return true;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}
	}

	// cancella una chat
	public boolean deleteProject(Project project) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, project.getIdproject());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}
	}

	// Modifica Chat

	public boolean updateProject(Project project) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_UPDATE);
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
}
