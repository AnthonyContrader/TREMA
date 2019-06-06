package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
}
