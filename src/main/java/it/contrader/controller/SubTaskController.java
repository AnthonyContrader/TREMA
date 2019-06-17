package it.contrader.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.SubTaskDTO;
import it.contrader.dto.TaskDTO;
import it.contrader.services.SubTaskService;

@CrossOrigin
@RestController
@RequestMapping("/SubTask")
public class SubTaskController extends AbstractController<SubTaskDTO> {
	@Autowired
	private SubTaskService subTaskService;

	// POST Angular a SubTaskDTO
	@PostMapping("/subTaskManagement")
	public List<SubTaskDTO> subTaskManagement(@RequestBody TaskDTO taskDTO) {
		return subTaskService.findAllByTask(taskDTO);
	}
}
