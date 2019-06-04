package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import it.contrader.wmesspring.dto.ProjectDTO;
import it.contrader.wmesspring.dto.ProjectTemplateDTO;
import it.contrader.wmesspring.dto.ResourceDTO;
import it.contrader.wmesspring.dto.UserDTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDTO {
	private int idtask;

	private String task;

	private String data_inizio;

	private String data_fine;

	private String objective;

	private ProjectDTO projectDTO;
}
