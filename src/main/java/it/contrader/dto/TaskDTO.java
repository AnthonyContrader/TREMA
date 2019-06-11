package it.contrader.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDTO {
	private int idTask;

	private String task;

	private String dataInizio;

	private String dataFine;

	private ProjectDTO projectDTO;
	
	private List<SubTaskDTO> subTasksDTO;
}
