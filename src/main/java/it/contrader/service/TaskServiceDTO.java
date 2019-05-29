package it.contrader.service;

import it.contrader.converter.TaskConverter;
import it.contrader.dao.TaskDAO;
import it.contrader.dto.TaskDTO;
import it.contrader.model.Task;

public class TaskServiceDTO extends AbstractServiceDTO<Task, TaskDTO> {
	public TaskServiceDTO() {
		dao = new TaskDAO();
		converter = new TaskConverter();
	}
}
