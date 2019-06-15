package it.contrader.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.ProjectDTO;

@CrossOrigin
@RestController
@RequestMapping("/Project")
public class ProjectController extends AbstractController<ProjectDTO> {
	/*
	 * @Autowired private ProjectService projectService;
	 * 
	 * //POST Angular a ProjectDTO
	 * 
	 * @RequestMapping(value = "/projectManagement", method = RequestMethod.GET)
	 * public List<ProjectDTO> projectManagement(@RequestParam(value = "IdUser") int
	 * id) { UserDTO userDTO = new UserDTO(); userDTO.setId(id); return
	 * this.projectService.findByUserLogin(userDTO); }
	 */
}
