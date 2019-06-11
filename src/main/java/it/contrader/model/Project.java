package it.contrader.model;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.mapping.Set;
import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data   //genera get e set
@AllArgsConstructor	//genera il construct[lib lombok]
@NoArgsConstructor
@Entity
@Table(name="project")

public class Project implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idProject")
	private int idProject;

	@Column(name="project")
	private String project;

	@Column(name="tipologie")
	private String tipologie;
	
	@ManyToOne
	@JoinColumn(name="user")
	private User user;
	
	//bi-directional many-to-one association to Project
	@OneToMany(mappedBy = "project")
	private List<Task> tasks;
		
		
}
