package it.contrader.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

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
	@Column(name="IdDipendente")
	private int IdDipendente;

	@Column(name="NomeDip")
	private String NomeDip;
	
	@Column(name="CognomeDip")
	private String CognomeDip;

	// bi-directional one-to-many association to DipMaterial
	@OneToMany
	@JoinColumn(name="IdDipendenti")
	private List<DipMaterial> DipMaterial;
}