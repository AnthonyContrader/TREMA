package it.contrader.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data   //genera get e set
@AllArgsConstructor	//genera il construct[lib lombok]
@NoArgsConstructor
@Entity	
@Table(name="dipendenti")

public class Dipendenti implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idDipendente")
	private int idDipendente;

	@Column(name="name")
	private String name;
	
	@Column(name="surname")
	private String surname;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="task")
	private Task task;
}