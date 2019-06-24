package it.contrader.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.ProjectDTO;
import it.contrader.dto.TaskDTO;
import it.contrader.services.TaskService;

@CrossOrigin("*")
@RestController
@RequestMapping("/task")
public class TaskController extends AbstractController<TaskDTO> {
	@Autowired
	private TaskService taskService;

	// POST Angular a TaskDTO
	@GetMapping("/getallby")
	public List<TaskDTO> taskManagement(@RequestParam("id") Long id) {
		ProjectDTO projectDTO = new ProjectDTO();
		projectDTO.setId(id);
		return taskService.findAllByProject(projectDTO);
	}
}
