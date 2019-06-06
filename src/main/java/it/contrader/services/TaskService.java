package it.contrader.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.ConverterTask;
import it.contrader.dao.TaskRepository;
import it.contrader.dto.TaskDTO;
import it.contrader.model.Task;

import it.contrader.converter.ConverterProject;
import it.contrader.dao.ProjectRepository;
import it.contrader.dto.ProjectDTO;
import it.contrader.model.Project;

public class TaskService {
	private final TaskRepository taskRepository;

	@Autowired
	public TaskService(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}

	public List<TaskDTO> getListaTaskDTO() {
		return ConverterTask.toListDTO((List<Task>) taskRepository.findAll());
	}
	
	public TaskDTO getTaskDTOByIdTask(Integer idTask) {
		return ConverterTask.toDTO(taskRepository.findById(idTask).get());
	}
	
	public List<TaskDTO> getListaTaskDTOByProject(ProjectDTO project) {
		return ConverterTask.toListDTO((List<Task>) taskRepository.findAllByProject(ConverterProject.toEntity(project)));
	}
	
	public boolean insertTask(TaskDTO taskDTO) {
		return taskRepository.save(ConverterTask.toEntity(taskDTO)) != null;
	}

	public boolean updateTask(TaskDTO taskDTO) {
		return taskRepository.save(ConverterTask.toEntity(taskDTO)) != null;
	}
	
	public void deleteTaskByIdTask(Integer idtask) {
		taskRepository.deleteByIdTask(idtask);
	}
	
	public List<TaskDTO> findTaskDTOByProject(ProjectDTO projectDTO) {
		final List<Task> list = taskRepository.findAllByProject(ConverterProject.toEntity(projectDTO));
		final List<TaskDTO> taskDTOs = new ArrayList<>();
		list.forEach(i -> taskDTOs.add(ConverterTask.toDTO(i)));
		return taskDTOs;
	}
}
