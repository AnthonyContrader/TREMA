package it.contrader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.TaskDTO;
import it.contrader.converter.ConverterTask;
import it.contrader.services.TaskService;

import it.contrader.dto.ProjectDTO;
import it.contrader.converter.ConverterProject;
import it.contrader.services.ProjectService;


import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/Task")
public class TaskController {
	private final TaskService taskService;
	//private final ProjectService projectService;
	
	@Autowired
	public TaskController(TaskService taskService, ResourceService resourceService) {
		this.taskService = taskService;
	}

	@RequestMapping(value = "/taskManagement", method = RequestMethod.GET)
	public List<TaskDTO> taskManagement(@RequestParam(value = "idProject") int idProject) {
		ProjectDTO projectDTOTaskList = new ProjectDTO();
		projectDTOTaskList.setIdProject(idProject);
		return this.taskService.findTaskDTOByProject(projectDTOTaskList);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public void delete(@RequestParam(value = "idTask") int idTask) {
		this.taskService.deleteTaskByIdTask(idTask);
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public void insert(@RequestBody TaskDTO taskDTO) {
		taskService.insertTask(taskDTO);
	}

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public TaskDTO read(@RequestParam(value = "idTask") int idTask) {
		TaskDTO taskDTOUpdate = new TaskDTO();
		taskDTOUpdate = this.taskService.getTaskDTOByIdTask(idTask);
		return taskDTOUpdate;

	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public void update(@RequestBody TaskDTO taskDTO) {
		taskService.updateTask(taskDTO);
	}
}
