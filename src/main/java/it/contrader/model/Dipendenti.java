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
@Table(name="Dipendenti")
@NamedQuery(name="Dipendenti.findAll", query="SELECT u FROM Dipendenti u")
public class Dipendenti implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdDipendenti")
	private int iddipendente;

	@Column(name="NameDip")
	private String namedip;
	
	@Column(name="CognomeDip")
	private String cognomedip;

	//bi-directional one-to-many association to DipMateriale
	@OneToMany
	@JoinColumn(name="DipMaterial")
	private List<DipMaterial> DipMaterial;
}