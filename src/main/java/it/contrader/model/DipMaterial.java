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
@Table(name="DipMaterial")
public class DipMaterial implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdDipMaterial")
    private int IdDipMaterial;
    
    @Column(name="Quantita")
	private int Quantita;
    
    // bi-directional one-to-many association to Team
	@OneToMany
	@JoinColumn(name="IdDipMaterial")
	private List<Team> Team;
	
	// bi-directional many-to-one association to Material
	@ManyToOne
	@JoinColumn(name="IdMaterial")
	private Material Material;
	
	// bi-directional many-to-one association to Dipendenti
	@ManyToOne
	@JoinColumn(name="IdDipendenti")
	private Dipendenti Dipendenti;
}
