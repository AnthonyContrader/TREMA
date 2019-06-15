package it.contrader.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.ConverterDipMaterial;
import it.contrader.converter.ConverterSubTask;
import it.contrader.converter.ConverterTeam;
import it.contrader.dao.TeamRepository;
import it.contrader.dto.DipMaterialDTO;
import it.contrader.dto.SubTaskDTO;
import it.contrader.dto.TeamDTO;
import it.contrader.model.Team;

@Service
public class TeamService extends AbstractService<Team, TeamDTO> {
	private final TeamRepository teamRepository;
	
	@Autowired
	private ConverterTeam converterTeam;
	
	@Autowired
	private ConverterSubTask converterST;
	
	@Autowired
	private ConverterDipMaterial converterDM;
	
	@Autowired
	public TeamService(TeamRepository teamRepository) {
		this.teamRepository = teamRepository;
	}
	
	public List<TeamDTO> findBySubTask(SubTaskDTO subTaskDTO) {
		final List<Team> list = teamRepository.findBySubTask(converterST.toEntity(subTaskDTO));
		final List<TeamDTO> listDTOs = new ArrayList<>();
		list.forEach(i -> listDTOs.add(converterTeam.toDTO(i)));
		return listDTOs;
	}
	
	public List<TeamDTO> findByDipMaterial(DipMaterialDTO dipMaterialDTO) {
		final List<Team> list = teamRepository.findByDipMaterial(converterDM.toEntity(dipMaterialDTO));
		final List<TeamDTO> listDTOs = new ArrayList<>();
		list.forEach(i -> listDTOs.add(converterTeam.toDTO(i)));
		return listDTOs;
	}
}
