package it.contrader.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.TaskDTO;

@CrossOrigin
@RestController
@RequestMapping("/Task")
public class TaskController extends AbstractController<TaskDTO> {
	
}
