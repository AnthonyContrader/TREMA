package it.contrader.converter;

import it.contrader.model.SubTask;
import it.contrader.dto.SubTaskDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConverterSubTask extends AbstractConverter<SubTask, SubTaskDTO> {
	@Autowired
	private ConverterTask converter;
	
	public SubTaskDTO toDTO(SubTask subTask) {
		SubTaskDTO subTaskDTO = null;

		if (subTask != null) {
			subTaskDTO = new SubTaskDTO();
			subTaskDTO.setId(subTask.getId());
			subTaskDTO.setSubTask(subTask.getSubTask());
			subTaskDTO.setTaskDTO(converter.toDTO(subTask.getTask()));
		}

		return subTaskDTO;
	}

	public SubTask toEntity(SubTaskDTO subTaskDTO) {
		SubTask subTask = null;

		if (subTaskDTO != null) {
			subTask = new SubTask();
			subTask.setId(subTaskDTO.getId());
			subTask.setSubTask(subTaskDTO.getSubTask());
			subTask.setTask(converter.toEntity(subTaskDTO.getTaskDTO()));
		}
		return subTask;
	}
}
