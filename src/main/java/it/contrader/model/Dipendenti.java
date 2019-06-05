package it.contrader.model;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the clients database table.
 * 
 */
@Entity
@Table(name="dipendenti")
@NamedQuery(name="Dipendenti.findAll", query="SELECT c FROM Dipendenti c")
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
	@JoinColumn(name="idTask")
	private int task;

	public Dipendenti() {
	}

	public int getIdDipendenti() {
		return this.idDipendente;
	}

	public void setIdDipendenti(int idDipendenti) {
		this.idDipendente = idDipendenti;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getTask() {
		return this.task;
	}

	public void setTask(int task) {
		this.task = task;
	}

}