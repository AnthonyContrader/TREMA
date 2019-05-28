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

	/**
	 * Come vediamo la lista recuperata è di tipo Esempio ma noi la convertiamo in EsempioDTO
	 * Invito chi fa i converter a fare un metodo per convertire direttamente la lista senza farli uno ad uno perchè è sporco e poco efficiente
	 */
	public List<TaskDTO> getAllUsers() {

		List<Task> list = taskDAO.getAllUsers();
		List<TaskDTO> listDTO = new ArrayList<>();

		for (Task task : list) {
			listDTO.add(TaskConverter.toDTO(task));
		}

		return listDTO;
	}
	
	/*
	public TaskDTO getTaskByIdTask(Integer idtask) {
		return TaskConverter.toDTO(taskDAO.login(username, password));
	} */

	public boolean updateTask (TaskDTO taskDTO) {
		return this.taskDAO.updateTask(TaskConverter.toEntity(taskDTO));		
	}
	
	public boolean deleteTask (TaskDTO taskDTO) {
		return this.taskDAO.deleteTask(TaskConverter.toEntity(taskDTO));		
	}
	
	public boolean insertTask (TaskDTO taskDTO) {
		return this.taskDAO.insertTask(TaskConverter.toEntity(taskDTO));	
	}
}
