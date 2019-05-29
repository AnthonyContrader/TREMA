package it.contrader.converter;

import it.contrader.dto.TaskDTO;
import it.contrader.model.Task;

public class TaskConverter implements Converter<Task, TaskDTO>{
	
	// Converte un NodesDTO in Nodes
	public Task toEntity(TaskDTO taskDTO) {
		Task task = null;
		
		if (taskDTO != null) {
			task = new Task(taskDTO.getDescrizione_task(), taskDTO.getIdproject(), taskDTO.getIdHR());
		}

		return task;
	}
	
	// Converte un Nodes in NodesDTO
	public TaskDTO toDTO(Task task) {
		TaskDTO taskDTO = null;
		
		if (task != null) {
			taskDTO = new TaskDTO(task.getIdtask(), task.getDescrizione_task(), task.getIdproject(), 
					task.getDescrizioneProject(), task.getIdHR(), task.getDescrizioneHR());
		}

		return taskDTO;
	}
}
