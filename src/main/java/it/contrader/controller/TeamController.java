package it.contrader.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.DipMaterialDTO;
import it.contrader.dto.SubTaskDTO;
import it.contrader.dto.TeamDTO;
import it.contrader.services.TeamService;

@CrossOrigin
@RestController
@RequestMapping("/Team")
public class TeamController extends AbstractController<TeamDTO> {
	@Autowired
	private TeamService teamService;

	// POST Angular a TeamDTO
	@PostMapping("/teamSubTaskManagement")
	public List<TeamDTO> teamSubTaskManagement(@RequestBody SubTaskDTO subTaskDTO) {
		return teamService.findAllBySubTask(subTaskDTO);
	}

	// POST Angular a TeamDTO
	@PostMapping("/teamDipMaterialManagement")
	public List<TeamDTO> teamDipMaterialManagement(@RequestBody DipMaterialDTO dipMaterialDTO) {
		return teamService.findAllByDipMaterial(dipMaterialDTO);
	}
}