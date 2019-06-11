package it.contrader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.TaskDTO;
import it.contrader.services.TaskService;
import it.contrader.dto.ProjectDTO;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/Task")
public class TaskController {
	private final TaskService taskService;
	
	@Autowired
	public TaskController(TaskService taskService) {
		this.taskService = taskService;
	}
	
	@RequestMapping(value = "/taskManagement", method = RequestMethod.GET)
	public List<TaskDTO> taskManagement(@RequestParam(value = "IdProject") Integer IdProject) {
		ProjectDTO projectDTOTaskList = new ProjectDTO();
		projectDTOTaskList.setIdProject(IdProject);
		return this.taskService.findTaskDTOByProject(projectDTOTaskList);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public void delete(@RequestParam(value = "IdTask") int taskId) {
		this.taskService.deleteTaskById(taskId);
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public void insert(@RequestBody TaskDTO task) {
		taskService.insertTask(task);
	}

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public TaskDTO read(@RequestParam(value = "IdTask") Integer idtask) {
		TaskDTO taskUpdate = new TaskDTO();
		taskUpdate = this.taskService.getTaskDTOById(idtask);
		return taskUpdate;
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public void update(@RequestBody TaskDTO task) {
		taskService.updateTask(task);
	}
}
