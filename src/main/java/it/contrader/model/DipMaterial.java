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
@NamedQuery(name="DipMaterial.findAll", query="SELECT u FROM DipMaterial u")  //preleva tutto da DipMaterial
public class DipMaterial implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdDipMaterial")
    private int IdDipMaterial;
    
    @Column(name="Quantita")
	private int Quantita;

	//bi-directional many-to-one association to Project
	@OneToMany
	@JoinColumn(name="Material")
    private List<Material> Material;
    
    @ManyToOne
	@JoinColumn(name="Dipendenti")
	private Dipendenti Dipendenti;
	
	//bi-directional one-to-many association to Dipendenti
	@OneToMany
	@JoinColumn(name="Team")
	private List<Team> team;	
}
