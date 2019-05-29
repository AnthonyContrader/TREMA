package it.contrader.service;

import java.util.ArrayList;
import java.util.List;

import it.contrader.converter.TaskConverter;
import it.contrader.dao.TaskDAO;
import it.contrader.dto.TaskDTO;
import it.contrader.model.Task;

public class TaskServiceDTO {
	private final TaskDAO taskDAO;

	public TaskServiceDTO() {
		this.taskDAO = new TaskDAO();
	}

	public List<TaskDTO> getAllUsers() {

		List<Task> list = taskDAO.ReadAllTasks();
		List<TaskDTO> listDTO = new ArrayList<>();

		for (Task task : list) {
			listDTO.add(TaskConverter.toDTO(task));
		}

		return listDTO;
	}
	
	public boolean updateTask (TaskDTO taskDTO) {
		return this.taskDAO.UpdateTask(TaskConverter.toEntity(taskDTO));		
	}
	
	public boolean deleteTask (TaskDTO taskDTO) {
		return this.taskDAO.DeleteTask(TaskConverter.toEntity(taskDTO));		
	}
	
	public boolean insertTask (TaskDTO taskDTO) {
		return this.taskDAO.InsertTask(TaskConverter.toEntity(taskDTO));	
	}
}
