package it.contrader.model;

import java.io.Serializable;
import javax.persistence.*;
import it.contrader.model.Project;

import java.util.List;

@Entity
@Table(name="tasks")
@NamedQuery(name="Task.findAll", query="SELECT t FROM Task t")

public class Task implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idtask")
	private int idtask;

	@Column(name="task")
	private String task;

	@Column(name="data_inizio")
	private String data_inizio;

	@Column(name="data_fine")
	private String data_fine;

	@Column(name="objective")
	private String objective;

	//bi-directional many-to-one association to Project
	@ManyToOne
	@JoinColumn(name="idproject")
	private Project project;
	
	public Task() {
	}

	public int getIdtask() {
		return idtask;
	}

	public void setIdtask(int idtask) {
		this.idtask = idtask;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public String getData_inizio() {
		return data_inizio;
	}

	public void setData_inizio(String data_inizio) {
		this.data_inizio = data_inizio;
	}

	public String getData_fine() {
		return data_fine;
	}

	public void setData_fine(String data_fine) {
		this.data_fine = data_fine;
	}

	public String getObjective() {
		return objective;
	}

	public void setObjective(String objective) {
		this.objective = objective;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
}
