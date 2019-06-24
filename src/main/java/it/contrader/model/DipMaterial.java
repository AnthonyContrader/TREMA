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
public class DipMaterial implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
    
    private int quantita;
    
    @ManyToOne
	@JoinColumn
	private Material material;
	
	@ManyToOne
	@JoinColumn
	private Dipendenti dipendenti;
	
	@OneToMany
	@JoinColumn
	private List<Team> team;
}
