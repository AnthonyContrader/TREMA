package it.contrader.services;

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
	@Autowired
	private TeamRepository teamRepository;
	
	@Autowired
	private ConverterTeam converterTeam;
	
	@Autowired
	private ConverterSubTask converterST;
	
	@Autowired
	private ConverterDipMaterial converterDM;
	
	public List<TeamDTO> findAllBySubTask(SubTaskDTO subTaskDTO) {
		return converterTeam.toDTOList(teamRepository.findAllBySubTask(converterST.toEntity(subTaskDTO)));
	}
	
	public List<TeamDTO> findAllByDipMaterial(DipMaterialDTO dipMaterialDTO) {
		return converterTeam.toDTOList(teamRepository.findAllByDipMaterial(converterDM.toEntity(dipMaterialDTO)));
	}
}
