package it.contrader.model;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data   //genera get e set
@AllArgsConstructor	//genera il construct[lib lombok]
@NoArgsConstructor
@Entity	
@Table(name="SubTask")
public class SubTask implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdSubTask")
	private int IdSubTask;

	@Column(name="SubTask")
	private String SubTask;

	//bi-directional many-to-one association to Task
	@ManyToOne
	@JoinColumn(name="IdTask")
	private Task Task;
	
	//bi-directional many-to-one association to Team
	@OneToMany(mappedBy="SubTask")
	private List<Team> Teams;
}
