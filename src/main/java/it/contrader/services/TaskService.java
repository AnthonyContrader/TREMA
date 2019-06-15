package it.contrader.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.ConverterProject;
import it.contrader.converter.ConverterTask;
import it.contrader.dao.TaskRepository;
import it.contrader.dto.ProjectDTO;
import it.contrader.dto.TaskDTO;
import it.contrader.model.Task;

@Service
public class TaskService extends AbstractService<Task, TaskDTO> {
	private final TaskRepository taskRepository;
	
	@Autowired
	private ConverterTask converterTask;
	
	@Autowired
	private ConverterProject converterProject;
	
	@Autowired
	public TaskService(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}
	
	public List<TaskDTO> findByProject(ProjectDTO projectDTO) {
		final List<Task> list = taskRepository.findByProject(converterProject.toEntity(projectDTO));
		final List<TaskDTO> listDTOs = new ArrayList<>();
		list.forEach(i -> listDTOs.add(converterTask.toDTO(i)));
		return listDTOs;
	}
}
