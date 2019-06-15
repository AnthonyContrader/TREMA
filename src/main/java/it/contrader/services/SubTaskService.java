package it.contrader.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.ConverterSubTask;
import it.contrader.converter.ConverterTask;
import it.contrader.dao.SubTaskRepository;
import it.contrader.dto.SubTaskDTO;
import it.contrader.dto.TaskDTO;
import it.contrader.model.SubTask;

@Service
public class SubTaskService extends AbstractService<SubTask, SubTaskDTO> {
	private final SubTaskRepository subTaskRepository;
	
	@Autowired
	private ConverterSubTask converterSubTask;
	
	@Autowired
	private ConverterTask converterTask;
	
	@Autowired
	public SubTaskService(SubTaskRepository subTaskRepository) {
		this.subTaskRepository = subTaskRepository;
	}
	
	public List<SubTaskDTO> findByTask(TaskDTO taskDTO) {
		final List<SubTask> list = subTaskRepository.findByTask(converterTask.toEntity(taskDTO));
		final List<SubTaskDTO> listDTOs = new ArrayList<>();
		list.forEach(i -> listDTOs.add(converterSubTask.toDTO(i)));
		return listDTOs;
	}
}
