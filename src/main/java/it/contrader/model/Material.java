package it.contrader.model;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data   //genera get e set
@AllArgsConstructor	//genera il construct[lib lombok]
@NoArgsConstructor
@Entity	
@Table(name="Material")
@NamedQuery(name="Material.findAll", query="SELECT u FROM Material u")
public class Material implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdMaterial")
	private int idmaterial;

	@Column(name="Material")
	private String material;
	
	@Column(name="Quantita")
	private int quantita;

	//bi-directional one-to-many association to DipMaterial
	@OneToMany
	@JoinColumn(name="DipMaterial")
	private List<DipMaterial> DipMaterial; // capital or small ?


}