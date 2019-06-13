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
@Table(name="Team")
@NamedQuery(name="Team.findAll", query="SELECT u FROM Team u")  //preleva tutto da Team
public class Team implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdTeam")
    private int IdTeam;
    
	//bi-directional many-to-one association to Project
	@ManyToOne
	@JoinColumn(name="IdDipMaterial")
	private DipMaterial DipMaterial;
	
	@ManyToOne
	@JoinColumn(name="IdSubTask")
    private SubTask SubTask;
}
    