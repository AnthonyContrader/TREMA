package it.contrader.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.TeamDTO;

@CrossOrigin
@RestController
@RequestMapping("/Team")
public class TeamController extends AbstractController<TeamDTO> {
	
}