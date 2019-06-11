package it.contrader.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.dto.ProjectDTO;
import it.contrader.converter.ConverterProject;

import it.contrader.model.Task;
import it.contrader.dao.TaskRepository;
import it.contrader.dto.TaskDTO;
import it.contrader.converter.ConverterTask;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {
	private final TaskRepository taskRepository;
	
	@Autowired
	public TaskService(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}

	public List<TaskDTO> getListaTaskDTO() {
		return ConverterTask.toListDTO((List<Task>) taskRepository.findAll());
	}
	
	public TaskDTO getTaskDTOById(Integer idTask) {
		return ConverterTask.toDTO(taskRepository.findById(idTask).get());
	}
		
	public boolean insertTask(TaskDTO taskDTO) {
		return taskRepository.save(ConverterTask.toEntity(taskDTO)) != null;
	}

	public boolean updateTask(TaskDTO taskDTO) {
		return taskRepository.save(ConverterTask.toEntity(taskDTO)) != null;
	}
	
	public void deleteTaskById(Integer idTask) {
		taskRepository.deleteById(idTask);
	}
	
	public List<TaskDTO> findTaskDTOByProject(ProjectDTO projectDTO) {
		final List<Task> listTask = taskRepository.findAllByProject(ConverterProject.toEntity(projectDTO));
		final List<TaskDTO> listTaskDTO = new ArrayList<>();
		listTask.forEach(i -> listTaskDTO.add(ConverterTask.toDTO(i)));
		return listTaskDTO;
	}
}
