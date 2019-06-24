package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamDTO {
	
	private long id;
    
	private DipMaterialDTO dipMaterialDTO;
	
	private SubTaskDTO subTaskDTO;

}