package it.contrader.model;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data   //genera get e set
@AllArgsConstructor	//genera il construct[lib lombok]
@NoArgsConstructor
@Entity	
@Table(name="task")
@NamedQuery(name="Task.findAll", query="SELECT u FROM Task u")  //preleva tutto da user
public class Task implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idTask")
	private int idTask;

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
	@JoinColumn(name="project")
	private Project project;
	
	//bi-directional one-to-many association to Dipendenti
	@OneToMany
	@JoinColumn(name="task")
	private List<Dipendenti> dipendentis;
	
	//bi-directional one-to-many association to Material
	@OneToMany
	@JoinColumn(name="task")
	private List<Material> materials;
	
}
