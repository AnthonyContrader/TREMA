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
public class Team implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
    
	@ManyToOne
	@JoinColumn(name = "dip_material_id")
	private DipMaterial dipMaterial;
	
	@ManyToOne
	@JoinColumn(name = "sub_task_id")
    private SubTask subTask;
}
    