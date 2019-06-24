package it.contrader.model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data // genera get e set
@AllArgsConstructor // genera il construct[lib lombok]
@NoArgsConstructor
@Entity
public class Task implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String task;

	private Date dataInizio;

	private Date dataFine;

	@ManyToOne
	@JoinColumn(name = "project_id")
	private Project project;

}
