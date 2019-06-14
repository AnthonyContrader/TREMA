package it.contrader.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.contrader.dto.*;
import it.contrader.model.*;

@Component
public class ConverterTeam extends AbstractConverter<Team, TeamDTO> {
	@Autowired
	private ConverterSubTask converterST;
	
	@Autowired
	private ConverterDipMaterial converterDM;
	
	public TeamDTO toDTO(Team team){
		TeamDTO teamDTO=null;
		
		if(team!=null) {
			teamDTO = new TeamDTO();
			teamDTO.setId(team.getId());
			teamDTO.setDipMaterialDTO(converterDM.toDTO(team.getDipMaterial()));
			teamDTO.setSubTaskDTO(converterST.toDTO(team.getSubTask()));
			
		}
		return teamDTO;
	}
	
	public Team toEntity(TeamDTO teamDto) {
		Team team = null;
		
		if (teamDto != null) {
			team = new Team();
			team.setId(team.getId());
			team.setDipMaterial(converterDM.toEntity(teamDto.getDipMaterialDTO()));
			team.setSubTask(converterST.toEntity(teamDto.getSubTaskDTO()));	
		}
		return team;
	}
}