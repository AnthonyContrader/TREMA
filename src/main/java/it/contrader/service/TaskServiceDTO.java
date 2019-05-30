package it.contrader.service;

import java.util.ArrayList;
import java.util.List;

import it.contrader.converter.TaskConverter;
import it.contrader.converter.ProjectConverter;
import it.contrader.converter.HumanResourceConverter;
import it.contrader.converter.MaterialConverter;
import it.contrader.dao.MaterialDAO;
import it.contrader.dao.TaskDAO;
import it.contrader.dto.TaskDTO;
import it.contrader.dto.ProjectDTO;
import it.contrader.dto.HumanResourceDTO;
import it.contrader.dto.MaterialDTO;
import it.contrader.model.Material;
import it.contrader.model.Task;

public class TaskServiceDTO {
	private final TaskDAO taskDAO;
	
	public TaskServiceDTO() {
		this.taskDAO = new TaskDAO();
	}
	
	public List<TaskDTO> getAllTask() {

		List<Task> list = taskDAO.getAllTask();
		List<TaskDTO> listDTO = new ArrayList<>();

		for (Task task : list) {
			listDTO.add(TaskConverter.toDTO(task));
		}

		return listDTO;
	}
	
	public TaskDTO readTask(TaskDTO taskDTO) {
		return TaskConverter.toDTO(this.taskDAO.readTask(TaskConverter.toEntity(taskDTO)));
	}

	public boolean updateTask(TaskDTO taskDTO) {
		return this.taskDAO.updateTask(TaskConverter.toEntity(taskDTO));
	}
		
	public boolean deleteTask (TaskDTO taskDTO) {
		return this.taskDAO.deleteTask(TaskConverter.toEntity(taskDTO));
	}
		
	public boolean insertTask (TaskDTO taskDTO) {
		return this.taskDAO.insertTask(TaskConverter.toEntity(taskDTO));
	}
}
