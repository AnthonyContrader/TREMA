package it.contrader.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;



/**
 * The persistent class for the clients database table.
 * 
 */
@Data   //genera get e set
@AllArgsConstructor	//genera il construct[lib lombok]
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
	@JoinColumn(name="task")
	private Task task;

	public Material() {
	}

}