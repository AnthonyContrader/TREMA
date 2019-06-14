package it.contrader.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.SubTaskDTO;

@CrossOrigin
@RestController
@RequestMapping("/SubTask")
public class SubTaskController extends AbstractController<SubTaskDTO> {
	
}
