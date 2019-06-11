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
@Table(name="Project")

public class Project implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdProject")
	private int IdProject;

	@Column(name="Project")
	private String Project;

	@Column(name="Tipologie")
	private String Tipologie;
	
	@ManyToOne
	@JoinColumn(name="User")
	private User User;
	
	//bi-directional many-to-one association to Project
	@OneToMany(mappedBy = "Project")
	private List<Task> Tasks;
		
		
}
