package it.contrader.model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data   //genera get e set
@AllArgsConstructor	//genera il construct[lib lombok]
@NoArgsConstructor
@Entity	
@Table(name="Material")
public class Material implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdMaterial")
	private int IdMaterial;

	@Column(name="Material")
	private String Material;
	
	//bi-directional many-to-one association to Task
	@ManyToOne
	@JoinColumn(name="IdMaterial", insertable = false, updatable = false)
	private DipMaterial DipMaterial;
}