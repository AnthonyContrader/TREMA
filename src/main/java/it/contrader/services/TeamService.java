package it.contrader.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.dto.TeamDTO;
import it.contrader.converter.ConverterTeam;
import it.contrader.dao.TeamRepository;
import it.contrader.model.Team;

import it.contrader.converter.ConverterSubTask;
import it.contrader.dto.SubTaskDTO;


@Service
public class TeamService {

	private final TeamRepository teamRepository;		//DA FAREE!!
	//@Autowired
	//private TaskService taskService;

	@Autowired
	public TeamService(TeamRepository teamRepository) {
		this.teamRepository = teamRepository;
	}

	public List<TeamDTO> getListTeamDTO() {
		return ConverterTeam.toListDTO((List<Team>) teamRepository.findAll());
	}

	public TeamDTO getTeamDTOById(Integer id) {
		return ConverterTeam.toDTO(TeamRepository.findById(id).get());
	}

	public boolean insertTeam(TeamDTO TeamDTO) {
		return TeamRepository.save(ConverterTeam.toEntity(TeamDTO)) != null;
	}

	public boolean updateTeam(TeamDTO TeamDTO) {
		return TeamRepository.save(ConverterTeam.toEntity(TeamDTO)) != null;
	}

	public void deleteTeamById(Integer id) {
		TeamRepository.deleteById(id);
	}

	public List<TeamDTO> findTeamDTOBySubTask(SubTaskDTO subTaskDTO) {
		final List<Team> listTeam = TeamRepository.findAllBySubTask(ConverterSubTask.toEntity(subTaskDTO));
		final List<TeamDTO> listTeamDTO = new ArrayList<>();
		listTeam.forEach(i -> listTeamDTO.add(ConverterTeam.toDTO(i)));
		return listTeamDTO;
	}
}