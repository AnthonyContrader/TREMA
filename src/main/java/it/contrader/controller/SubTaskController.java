package it.contrader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.TaskDTO;
import it.contrader.converter.ConverterTask;

import it.contrader.dto.SubTaskDTO;
import it.contrader.services.SubTaskService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/SubTask")
public class SubTaskController {
	private final SubTaskService subTaskService;
	
	@Autowired
	public SubTaskController(SubTaskService subTaskService) {
		this.subTaskService = subTaskService;
	}
	
	@RequestMapping(value = "/subTaskManagement", method = RequestMethod.GET)
	public List<SubTaskDTO> subTaskManagement(@RequestParam(value = "IdSubTask") Integer idTask) { 
		TaskDTO taskDTOSubTaskList = new TaskDTO();
		taskDTOSubTaskList.setIdTask(idTask);
		return this.subTaskService.findSubTaskDTOByTask(taskDTOSubTaskList);
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)	
	public void delete(@RequestParam(value ="IdSubTask") Integer idSubTask) {
		this.subTaskService.deleteSubTaskById(idSubTask);
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public void insert(@RequestBody SubTaskDTO subTaskDTO) {
		subTaskService.insertSubTask(subTaskDTO);

	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public SubTaskDTO read(@RequestParam(value = "IdSubTask") Integer idSubTask) {
		SubTaskDTO subTaskUpdate = new SubTaskDTO();
		subTaskUpdate = this.subTaskService.getSubTaskDTOById(idSubTask);
		return subTaskUpdate;
	}		
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public void update(@RequestBody SubTaskDTO subTaskDTO) {
		subTaskService.updateSubTask(subTaskDTO);
	}
}
