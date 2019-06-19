package it.contrader.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.ProjectDTO;
import it.contrader.dto.UserDTO;
import it.contrader.services.ProjectService;

@CrossOrigin("*")
@RestController
@RequestMapping("/project")
public class ProjectController extends AbstractController<ProjectDTO> {
	@Autowired
	private ProjectService projectService;

	// POST Angular a ProjectDTO
	@GetMapping("/getallby")
	public List<ProjectDTO> projectManagement(@RequestParam("id") Long userId) {
		UserDTO userDTO = new UserDTO();
		userDTO.setId(userId);
		return projectService.findAllByUser(userDTO);
	}
}
