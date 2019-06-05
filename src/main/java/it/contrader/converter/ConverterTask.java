package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.TaskDTO;
import it.contrader.model.Task;
import it.contrader.converter.ConverterTask;
import it.contrader.converter.ConverterProject;

public class ConverterTask {
	public static TaskDTO toDTO(Task task) {
		TaskDTO taskDTO = null;
		if (task != null) {
			taskDTO = new TaskDTO();
			
			taskDTO.setTaskId(task.getIdtask());
			taskDTO.setTaskTask(task.getTask());
			taskDTO.setTaskDataInizio(task.getData_inizio());
		 	taskDTO.setTaskDataFine(task.getData_fine());
			taskDTO.setTaskObjective(task.getObjective());
			taskDTO.setProjectDTO(ConverterProject.toDTO(task.getProject()));
		}
		return taskDTO;
	}

	public static Task toEntity(TaskDTO taskDTO) {
		Task task = null;
		if (taskDTO != null) {
			task = new Task();
			
			task.setTaskId(taskDTO.getIdtask());
			task.setTaskTask(taskDTO);
			task.setTaskDataInizio(taskDTO.getData_inizio());
			task.setTaskDataFine(taskDTO.getData_fine());
			task.setTaskObjective(taskDTO.getObjective());
			task.setProjectDTO(ConverterProject.toDTO(taskDTO.getProject()));
		}
		return task;
	}

	public static List<TaskDTO> toListDTO(List<Task> list) {
		List<TaskDTO> listTaskDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (Task task : list) {
				listTaskDTO.add(ConverterTask.toDTO(task));
			}
		}
		return listTaskDTO;
	}

	public static List<Task> toListEntity(List<TaskDTO> listTaskDTO) {
		List<Task> list = new ArrayList<>();
		if (!listTaskDTO.isEmpty()) {
			for (TaskDTO taskDTO : listTaskDTO) {
				list.add(ConverterTask.toEntity(taskDTO));
			}
		}
		return list;
	}
}
