package it.contrader.model;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data // genera get e set
@AllArgsConstructor // genera il construct[lib lombok]
@NoArgsConstructor
@Entity
@Table(name = "Task")
public class Task implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IdTask")
	private int IdTask;

	@Column(name = "Task")
	private String Task;

	@Column(name = "DataInizio")
	private String DataInizio;

	@Column(name = "DataFine")
	private String DataFine;

	// bi-directional many-to-one association to Project
	@ManyToOne
	@JoinColumn(name = "IdProject")
	private Project Project;

	// bi-directional many-to-one association to SubTask
	@OneToMany(mappedBy = "Task")
	private List<SubTask> subTasks;

	/*
	 * // Tree implementation
	 * 
	 * @Nullable
	 * 
	 * @ManyToOne(cascade= {CascadeType.ALL})
	 * 
	 * @JoinColumn(name="father_id") private Task taskFather;
	 * 
	 * @JoinTable(name = "projects_wbs", joinColumns = @JoinColumn(name =
	 * "task_id_father"), inverseJoinColumns = @JoinColumn(name = "task_id_child"))
	 * 
	 * @OnDelete(action = OnDeleteAction.CASCADE)
	 * 
	 * @OneToMany(mappedBy = "taskFather") private List<Task> childsList;
	 */
}
