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

import it.contrader.dto.DipMaterialDTO;
import it.contrader.dto.SubTaskDTO;
import it.contrader.dto.TeamDTO;
import it.contrader.services.TeamService;

@CrossOrigin("*")
@RestController
@RequestMapping("/team")
public class TeamController extends AbstractController<TeamDTO> {
	@Autowired
	private TeamService teamService;

	// POST Angular a TeamDTO
	@GetMapping("/getallbysubtask")
	public List<TeamDTO> teamSubTaskManagement(@RequestParam("id") Long id) {
		SubTaskDTO subTaskDTO = new SubTaskDTO();
		subTaskDTO.setId(id);
		return teamService.findAllBySubTask(subTaskDTO);
	}

	// POST Angular a TeamDTO
	@GetMapping("/getallbydipmaterial")
	public List<TeamDTO> teamDipMaterialManagement(@RequestParam("id") Long id) {
		DipMaterialDTO dipMaterialDTO = new DipMaterialDTO();
		dipMaterialDTO.setId(id);
		return teamService.findAllByDipMaterial(dipMaterialDTO);
	}
}