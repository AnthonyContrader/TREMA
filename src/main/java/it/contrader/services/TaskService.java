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

import it.contrader.converter.ConverterDipendenti;
import it.contrader.dao.DipendentiRepository;
import it.contrader.dto.DipendentiDTO;
import it.contrader.model.Dipendenti;

import it.contrader.converter.ConverterMaterial;
import it.contrader.dao.MaterialRepository;
import it.contrader.dto.MaterialDTO;
import it.contrader.model.Material;

public class TaskService {
	private final TaskRepository taskRepository;
	//
	//private final MaterialRepository materialRepository;
	
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
		taskRepository.deleteById(idtask);
	}
	
	public List<TaskDTO> findTaskDTOByProject(Project project) {
		final List<Task> listTask = taskRepository.findAllByProject(project);
		final List<TaskDTO> taskDTOs = new ArrayList<>();
		listTask.forEach(i -> taskDTOs.add(ConverterTask.toDTO(i)));
		return taskDTOs;
	}
	
	/*
	 * public List<DipendentiDTO> findDipendentiDTOByTask(Task task) { private final
	 * DipendentiRepository dipendentiRepository; final List<Dipendenti>
	 * listDipendenti = dipendentiRepository. final List<DipendentiDTO>
	 * DipendentiDTOs = new ArrayList<>(); listDipendenti.forEach(i ->
	 * DipendentiDTOs.add(ConverterDipendenti.toDTO(i))); return DipendentiDTOs; }
	 */
}
