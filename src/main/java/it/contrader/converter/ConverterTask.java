package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.ProjectDTO;
import it.contrader.model.Project;
import it.contrader.dto.TaskDTO;
import it.contrader.model.Task;

public class ConverterTask {
	public static TaskDTO toDTO(Task task) {
		TaskDTO taskDTO = null;
		if (task != null) {
			taskDTO = new TaskDTO();
			
			taskDTO.setIdTask(task.getIdTask());
			taskDTO.setTask(task.getTask());
			taskDTO.setData_inizio(task.getData_inizio());
		 	taskDTO.setData_fine(task.getData_fine());
			taskDTO.setObjective(task.getObjective());
			taskDTO.setProjectDTO(ConverterProject.toDTO(task.getProject()));
			
			if (task.getProject() != null) {
				ProjectDTO projectDTO = new ProjectDTO();
				projectDTO.setIdProject(task.getProject().getIdProject());
				taskDTO.setProjectDTO(projectDTO);
			}
		}
		return taskDTO;
	}

	public static Task toEntity(TaskDTO taskDTO) {
		Task task = null;
		if (taskDTO != null) {
			task = new Task();
			
			task.setIdTask(taskDTO.getIdTask());
			task.setTask(taskDTO.getTask());;
			task.setData_inizio(taskDTO.getData_inizio());
			task.setData_fine(taskDTO.getData_fine());
			task.setObjective(taskDTO.getObjective());
			task.setProject(ConverterProject.toEntity(taskDTO.getProjectDTO()));
			
			if (taskDTO.getProjectDTO() != null) {
				Project project = new Project();
				project.setIdProject(taskDTO.getProjectDTO().getIdProject());
				task.setProject(project);
			}
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
