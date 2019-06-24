package it.contrader.model;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data   //genera get e set
@AllArgsConstructor	//genera il construct[lib lombok]
@NoArgsConstructor
@Entity
public class SubTask implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String subTask;
	
	private Date dataInizio;

	private Date dataFine;
	
	@ManyToOne
	@JoinColumn(name = "task_id")
	private Task task;
	
	@OneToMany(mappedBy = "subTask")
	private List<Team> team;
}
