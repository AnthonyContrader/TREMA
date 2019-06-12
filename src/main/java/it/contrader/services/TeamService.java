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

	public List<TeamDTO> findTeamDTOBySubTask(SubTaskDTO subTaskDTOTeamList) {
		// TODO Auto-generated method stub
		return null;
	}

	public void insertTeam(TeamDTO teamDTO) {
		// TODO Auto-generated method stub
		
	}

	public TeamDTO getTeamDTOById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateTeam(TeamDTO team) {
		// TODO Auto-generated method stub
		
	}

	public List<TeamDTO> getListTeamDTO() {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteTeamById(int id) {
		// TODO Auto-generated method stub
		
	}
	
}
