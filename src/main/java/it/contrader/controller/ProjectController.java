package it.contrader.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.ProjectDTO;
import it.contrader.dto.UserDTO;
import it.contrader.services.ProjectService;

@CrossOrigin
@RestController
@RequestMapping("/Project")
public class ProjectController extends AbstractController<ProjectDTO> {
	@Autowired
	private ProjectService projectService;

	// POST Angular a ProjectDTO
	@PostMapping("/projectManagement")
	public List<ProjectDTO> projectManagement(@RequestBody UserDTO userDTO) {
		return projectService.findAllByUser(userDTO);
	}
}
