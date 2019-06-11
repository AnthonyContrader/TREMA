package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubTaskDTO {
	private int idSubTask;

	private String subTask;

	private TaskDTO taskDTO;
	
	private List<TeamDTO> teamsDTO;
}

