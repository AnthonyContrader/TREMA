package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;
import it.contrader.dto.*;

import it.contrader.model.*;

public class ConverterTeam {
	public static TeamDTO toDTO(Team team){
		TeamDTO teamDTO=null;
		
		if(team!=null) {
			teamDTO = new TeamDTO();
			teamDTO.setIdTeam(team.getIdTeam());
			teamDTO.setDipMaterialDTO(ConverterDipMaterial.toDTO(team.getDipMaterial()));
			teamDTO.setSubTaskDTO(ConverterSubTask.toDTO(team.getSubTask()));
		}
		return teamDTO;
	}
	
	public static Team toEntity(TeamDTO teamDto) {
		Team team = null;
		
		if (teamDto != null) {
			team = new Team();
			team.setIdTeam(team.getIdTeam());
			team.setDipMaterial(ConverterDipMaterial.toEntity(teamDto.getDipMaterialDTO()));
			team.setSubTask(ConverterSubTask.toEntity(teamDto.getSubTaskDTO()));	
		}
		return team;
	}

	public static List<TeamDTO> toListDTO(List<Team> list){
		List<TeamDTO> listDTO=new ArrayList<>();
		if(!list.isEmpty()) {
			for(Team team : list) {
				listDTO.add(ConverterTeam.toDTO(team));
			}
		}
		return listDTO;
	}
	
	public static List<Team> toListEntity(List<TeamDTO> list){
		List<Team> lista=new ArrayList<>();
		if(!list.isEmpty()) {
			for(TeamDTO team : list) {
				lista.add(ConverterTeam.toEntity(team));
			}
		}
		return lista;
	}
}