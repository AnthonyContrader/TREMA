package it.contrader.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.ProjectDTO;
import it.contrader.dto.TaskDTO;
import it.contrader.services.TaskService;

@CrossOrigin
@RestController
@RequestMapping("/Task")
public class TaskController extends AbstractController<TaskDTO> {
	@Autowired
	private TaskService taskService;

	// POST Angular a TaskDTO
	@PostMapping("/taskManagement")
	public List<TaskDTO> taskManagement(@RequestBody ProjectDTO projectDTO) {
		return taskService.findAllByProject(projectDTO);
	}
}
