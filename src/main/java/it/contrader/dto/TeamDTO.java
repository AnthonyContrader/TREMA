package it.contrader.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamDTO {
	private int IdTeam;

    private DipMaterialDTO DipMaterialDTO;
	
	private SubTaskDTO SubTaskDTO;
}