package it.contrader.converter;

import it.contrader.model.Task;
import it.contrader.dto.TaskDTO;

import it.contrader.model.SubTask;
import it.contrader.dto.SubTaskDTO;

import it.contrader.model.Team;
import it.contrader.dto.TeamDTO;

import java.util.ArrayList;
import java.util.List;

public class ConverterSubTask {
	public static SubTaskDTO toDTO(SubTask subTask) {
		SubTaskDTO subTaskDTO = null;

		if (subTask != null) {
			subTaskDTO = new SubTaskDTO();
			subTaskDTO.setIdSubTask(subTask.getIdSubTask());
			subTaskDTO.setSubTask(subTask.getSubTask());
			subTaskDTO.setTaskDTO(ConverterTask.toDTO(subTask.getTask()));

			List<Team> teamList = subTask.getTeams();
			List<TeamDTO> teamListDTO = new ArrayList<TeamDTO>();
		}

		return subTaskDTO;
	}

	public static SubTask toEntity(SubTaskDTO subTaskDTO) {
		SubTask subTask = null;

		if (subTaskDTO != null) {
			subTask = new SubTask();
			subTask.setIdSubTask(subTaskDTO.getIdSubTask());
			subTask.setSubTask(subTaskDTO.getSubTask());
			subTask.setTask(ConverterTask.toEntity(subTaskDTO.getTaskDTO()));
			
			List<TeamDTO> teamListDTO = subTaskDTO.getTeamsDTO();
			List<Team> teamList = new ArrayList<Team>();
		}
		return subTask;
	}
	
	public static List<SubTaskDTO> toListDTO(List<SubTask> list) {
		List<SubTaskDTO> listSubTaskDTO = new ArrayList<>();
		
		if (!list.isEmpty()) {
			for (SubTask subTask : list) {
				listSubTaskDTO.add(ConverterSubTask.toDTO(subTask));
			}
		}
		
		return listSubTaskDTO;
	}

	public static List<SubTask> toListEntity(List<SubTaskDTO> listSubTaskDTO) {
		List<SubTask> list = new ArrayList<>();
		
		if (!listSubTaskDTO.isEmpty()) {
			for (SubTaskDTO subTaskDTO : listSubTaskDTO) {
				list.add(ConverterSubTask.toEntity(subTaskDTO));
			}
		}
		
		return list;
	}
}
