package it.contrader.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.dto.TaskDTO;
import it.contrader.converter.ConverterTask;

import it.contrader.model.SubTask;
import it.contrader.model.Task;
import it.contrader.dao.SubTaskRepository;
import it.contrader.dao.TaskRepository;
import it.contrader.dto.ProjectDTO;
import it.contrader.dto.SubTaskDTO;
import it.contrader.converter.ConverterProject;
import it.contrader.converter.ConverterSubTask;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubTaskService {
	private final SubTaskRepository subTaskRepository;
	
	@Autowired
	public SubTaskService(SubTaskRepository subTaskRepository) {
		this.subTaskRepository = subTaskRepository;
	}

	public List<SubTaskDTO> getListaSubTaskDTO() {
		return ConverterSubTask.toListDTO((List<SubTask>) subTaskRepository.findAll());
	}
	
	public SubTaskDTO getSubTaskDTOById(Integer idSubTask) {
		return ConverterSubTask.toDTO(subTaskRepository.findById(idSubTask).get());
	}
		
	public boolean insertSubTask(SubTaskDTO subTaskDTO) {
		return subTaskRepository.save(ConverterSubTask.toEntity(subTaskDTO)) != null;
	}

	public boolean updateSubTask(SubTaskDTO subTaskDTO) {
		return subTaskRepository.save(ConverterSubTask.toEntity(subTaskDTO)) != null;
	}
	
	public void deleteSubTaskByIdTask(Integer idTask) {
		subTaskRepository.deleteById(idTask);
	}
	
	public List<SubTaskDTO> findSubTaskDTOByTask(TaskDTO taskDTO) {
		final List<SubTask> listSubTask = subTaskRepository.findAllByTask(ConverterTask.toEntity(taskDTO));
		final List<SubTaskDTO> listSubTaskDTO = new ArrayList<>();
		listSubTask.forEach(i -> listSubTaskDTO.add(ConverterSubTask.toDTO(i)));
		return listSubTaskDTO;
	}
}
