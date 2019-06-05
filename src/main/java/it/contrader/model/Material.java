package it.contrader.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.*;;



/**
 * The persistent class for the clients database table.
 * 
 */
@Entity
@Table(name="material")
@NamedQuery(name="Material.findAll", query="SELECT c FROM Material c")
public class Material implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idMaterial")
	private int idMaterial;

	@Column(name="material")
	private String material;
	
	@Column(name="quantita")
	private int quantita;

	//bi-directional many-to-one association to Task
	@ManyToOne
	@JoinColumn(name="idTask")
	private List<Task> task;

	public Material() {
	}

	public int getIdmaterial() {
		return this.idMaterial;
	}

	public void setIdMaterial(int Idmaterial) {
		this.idMaterial = Idmaterial;
	}

	public String getMaterial() {
		return this.material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}
	
	public int getQuantita() {
		return this.quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	public List<Task> getTask() {
		return this.task;
	}

	public void setTask(Task task) {
		this.task = (List<Task>) task;
	}


}