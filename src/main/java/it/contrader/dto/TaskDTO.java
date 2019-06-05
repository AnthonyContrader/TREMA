package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import it.contrader.dto.TaskDTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDTO {
	private int idTask;

	private String task;

	private String data_inizio;

	private String data_fine;

	private String objective;

	private ProjectDTO projectDTO;
	
	private TaskDTO taskFather;

	private List<TaskDTO> childsListDTO;
}
