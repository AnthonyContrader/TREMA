package it.contrader.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import it.contrader.converter.ConverterProject;
import it.contrader.dto.ProjectDTO;

import it.contrader.converter.ConverterTask;
import it.contrader.dao.TaskRepository;
import it.contrader.dto.TaskDTO;
import it.contrader.model.Task;

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
		//return taskRepository.save(ConverterTask.toEntity(taskDTO)) != null;
		int taskFatherId = 0;

		if (taskDTO.getTaskFather() != null && taskDTO.getTaskFather().getIdTask() != 0) {
			taskFatherId = taskDTO.getTaskFather().getIdTask();
			taskRepository.insertTask(taskDTO.getTask(), taskDTO.getData_inizio(), taskDTO.getData_fine(), 
					taskDTO.getObjective(), taskDTO.getProjectDTO().getIdProject());
		} else {
			taskRepository.insertTask(taskDTO.getTask(), taskDTO.getData_inizio(), taskDTO.getData_fine(), 
					taskDTO.getObjective(), taskDTO.getProjectDTO().getIdProject());
		}
		return true;
		// return taskRepository.saveAndFlush(ConverterTask.toEntity(taskDTO)) != null;
	}

	public boolean updateTask(TaskDTO taskDTO) {
		return taskRepository.save(ConverterTask.toEntity(taskDTO)) != null;
	}
	
	public void deleteTaskByIdTask(Integer idtask) {
		taskRepository.deleteById(idtask);
	}
	
	public List<TaskDTO> findTaskDTOByProject(ProjectDTO projectDTO) {
		final List<Task> list = taskRepository.findAllByProject(ConverterProject.toEntity(projectDTO));
		final List<TaskDTO> taskDTOs = new ArrayList<>();
		list.forEach(i -> taskDTOs.add(ConverterTask.toDTO(i)));
		return taskDTOs;
	}
	
	// Tree methods... (Creo que hace lo mismo que el metodo anterior...
	public TaskDTO findProjectTaskRoot(ProjectDTO projectDTO) {
		Task taskRoot = taskRepository.findAllByProjectAndTaskFatherIsNull(ConverterProject.toEntity(projectDTO));
		return ConverterTask.toDTO(taskRoot);
	}
}
