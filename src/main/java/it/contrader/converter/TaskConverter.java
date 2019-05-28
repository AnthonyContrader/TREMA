package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.TaskDTO;
import it.contrader.model.Task;

public class TaskConverter {
	
	// Converte un NodesDTO in Nodes
	public static Task toEntity(TaskDTO taskDTO) {
		Task task = null;
		
		if (taskDTO != null) {
			task = new Task(taskDTO.getDescrizione_task(), taskDTO.getIdproject(), taskDTO.getIdHR());
		}

		return task;
	}
	
	// Converte un Nodes in NodesDTO
	public static TaskDTO toDTO(Task task) {
		TaskDTO taskDTO = null;
		
		if (task != null) {
			taskDTO = new TaskDTO(task.getDescrizione_task(), task.getIdproject(), task.getIdHR());
		}

		return taskDTO;
	}
}
