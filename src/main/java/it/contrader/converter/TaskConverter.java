package it.contrader.converter;

import it.contrader.dto.TaskDTO;
import it.contrader.dto.ProjectDTO;
import it.contrader.dto.HumanResourceDTO;
import it.contrader.model.Task;
import it.contrader.model.Project;
import it.contrader.model.HumanResource;
import it.contrader.model.Material;

public class TaskConverter{
	
	// Converte un NodesDTO in Nodes
	public static Task toEntity(TaskDTO taskDTO) {
		Task task = null;
		
		if (taskDTO != null) {
			Project project = ProjectConverter.toEntity(taskDTO.getProjectDTO());
			HumanResource hr = HumanResourceConverter.toEntity(taskDTO.getHRDTO());
			task = new Task(taskDTO.getDescrizioneTask(), project, hr);
			task.setIdtask(taskDTO.getIdtask());
		}

		return task;
	}
	
	// Converte un Nodes in NodesDTO
	public static TaskDTO toDTO(Task task) {
		TaskDTO taskDTO = null;
		
		if (task != null) {
			Project projectDTO = ProjectConverter.toDTO(task.getProjectDTO());
			HumanResource hrDTO = HumanResourceConverter.toDTO(task.getHRDTO());
			taskDTO = new Task(task.getDescrizione_task(), project, hr);
			taskDTO.setIdtask(task.getIdtask());
		}

		return taskDTO;
	}
}
