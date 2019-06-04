package it.contrader.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the clients database table.
 * 
 */
@Entity
@Table(name="materials")
@NamedQuery(name="Material.findAll", query="SELECT c FROM Material c")
public class Material implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idmaterial")
	private int Idmaterial;

	@Column(name="material")
	private String material;

	//bi-directional many-to-one association to Task
	@ManyToOne
	@JoinColumn(name="idtask")
	private Task task;


	public Material() {
	}

	public int getIdmaterial() {
		return this.Idmaterial;
	}

	public void setIdMaterial(int Idmaterial) {
		this.Idmaterial = Idmaterial;
	}

	public String getMaterial() {
		return this.material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public Task getTask() {
		return this.task;
	}

	public void setTask(Task task) {
		this.task = task;
	}


}