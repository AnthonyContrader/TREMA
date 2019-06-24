package it.contrader.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.contrader.model.Task;
import it.contrader.dto.TaskDTO;

@Component
public class ConverterTask extends AbstractConverter<Task, TaskDTO> {
	@Autowired
	private ConverterProject converter;
	
	public TaskDTO toDTO(Task task) {
		TaskDTO taskDTO = null;

		if (task != null) {
			taskDTO = new TaskDTO();
			taskDTO.setId(task.getId());
			taskDTO.setTask(task.getTask());
			taskDTO.setDataInizio(task.getDataInizio());
			taskDTO.setDataFine(task.getDataFine());
			taskDTO.setProjectDTO(converter.toDTO(task.getProject()));
		}

		return taskDTO;
	}

	public Task toEntity(TaskDTO taskDTO) {
		Task task = null;

		if (taskDTO != null) {
			task = new Task();
			task.setId(taskDTO.getId());
			task.setTask(taskDTO.getTask());
			task.setDataInizio(taskDTO.getDataInizio());
			task.setDataFine(taskDTO.getDataFine());
			task.setProject(converter.toEntity(taskDTO.getProjectDTO()));
		}

		return task;
	}

}
