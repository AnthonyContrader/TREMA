package it.contrader.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.ProjectDTO;

@CrossOrigin
@RestController
@RequestMapping("/Project")
public class ProjectController extends AbstractController<ProjectDTO> {
	
}
