package it.contrader.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.ConverterProject;

import it.contrader.model.*;
import it.contrader.dao.*;
import it.contrader.dto.*;
import it.contrader.converter.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamService {

	@Autowired
	private TeamRepository teamRepository;		

	public List<TeamDTO> getListTeamDTO() {
		return ConverterTeam.toListDTO((List<Team>) teamRepository.findAll());
	}

	public TeamDTO getTeamDTOById(Integer id) {
		return ConverterTeam.toDTO(teamRepository.findById(id).get());
	}

	public boolean insertTeam(TeamDTO TeamDTO) {
		return teamRepository.save(ConverterTeam.toEntity(TeamDTO)) != null;
	}

	public boolean updateTeam(TeamDTO TeamDTO) {
		return teamRepository.save(ConverterTeam.toEntity(TeamDTO)) != null;
	}

	public void deleteTeamById(Integer id) {
		teamRepository.deleteById(id);
	}

	public List<TeamDTO> findTeamDTOBySubTask(SubTaskDTO subTaskDTO) {
		final List<Team> listTeam = teamRepository.findAllBySubTask(ConverterSubTask.toEntity(subTaskDTO));
		final List<TeamDTO> listTeamDTO = new ArrayList<>();
		listTeam.forEach(i -> listTeamDTO.add(ConverterTeam.toDTO(i)));
		return listTeamDTO;
	}
}
