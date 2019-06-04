package it.contrader.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="projects")
@NamedQuery(name="Project.findAll", query="SELECT p FROM Project p")
public class Project implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idproject")
	private int idproject;

	@Column(name="project")
	private String project;

	@Column(name="tipologie")
	private String tipologie;
	
	//bi-directional many-to-one association to Project
	@ManyToOne
	@JoinColumn(name="iduser")
	private User user;
	
	public Project() {
	}

	public int getIdproject() {
		return idproject;
	}

	public void setIdproject(int idproject) {
		this.idproject = idproject;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getTipologie() {
		return tipologie;
	}

	public void setTipologie(String tipologie) {
		this.tipologie = tipologie;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
