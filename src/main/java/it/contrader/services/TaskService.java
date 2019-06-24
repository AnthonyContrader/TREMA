package it.contrader.services;

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
	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	private ConverterTask converterTask;
	
	@Autowired
	private ConverterProject converterProject;
	
	public List<TaskDTO> findAllByProject(ProjectDTO projectDTO) {
		return converterTask.toDTOList(taskRepository.findAllByProject(converterProject.toEntity(projectDTO)));
	}
}
