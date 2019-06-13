package it.contrader.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.DipMaterialDTO;
import it.contrader.dto.SubTaskDTO;
import it.contrader.dto.TeamDTO;
import it.contrader.services.TeamService;

@CrossOrigin
@RestController
@RequestMapping("/Team")
public class TeamController {
	@Autowired
	private TeamService teamService;
	
	@RequestMapping(value = "teamManagement", method = RequestMethod.GET)
	public List<TeamDTO> teamManagement(@RequestParam(value = "Entity") String entity,
										@RequestParam(value = "Id") Integer id) {
		
		switch (entity) {
			case "SubTask":
				SubTaskDTO subTaskDTOTeamList = new SubTaskDTO();
				subTaskDTOTeamList.setIdSubTask(id);
				return this.teamService.findTeamDTOBySubTask(subTaskDTOTeamList);
			case "DipMaterial":
				DipMaterialDTO dipMaterialDTOTeamList = new DipMaterialDTO();
				dipMaterialDTOTeamList.setIdDipMaterial(id);
				return this.teamService.findTeamDTOByDipMaterial(dipMaterialDTOTeamList);
			default:
				return null;
		}
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public void delete(@RequestParam(value = "IdTeam") int id) {
		this.teamService.deleteTeamById(id);
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public void insert(@RequestBody TeamDTO teamDTO) {
		this.teamService.insertTeam(teamDTO);
	}

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public TeamDTO read(@RequestParam(value = "IdTeam") int id) {
		TeamDTO teamUpdate = new TeamDTO();
		teamUpdate = this.teamService.getTeamDTOById(id);
		return teamUpdate;

	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public List<TeamDTO> update(@RequestParam(value = "IdTeam") int idUpdate,
			@RequestParam(value = "IdSubTask") SubTaskDTO IdSubTask,
			@RequestParam(value = "IdDipMaterial") DipMaterialDTO DipMaterial) {

		TeamDTO team = new TeamDTO();
		team.setIdTeam(idUpdate);
		team.setSubTaskDTO(IdSubTask);
		team.setDipMaterialDTO(DipMaterial);
		teamService.updateTeam(team);
		return this.teamService.getListTeamDTO();
	}

}