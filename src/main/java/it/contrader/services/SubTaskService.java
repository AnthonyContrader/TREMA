package it.contrader.services;

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
	@Autowired
	private SubTaskRepository subTaskRepository;
	
	@Autowired
	private ConverterSubTask converterSubTask;
	
	@Autowired
	private ConverterTask converterTask;
	
	public List<SubTaskDTO> findAllByTask(TaskDTO taskDTO) {
		return converterSubTask.toDTOList(subTaskRepository.findAllByTask(converterTask.toEntity(taskDTO)));
	}
}
