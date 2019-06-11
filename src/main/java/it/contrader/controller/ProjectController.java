package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.ProjectDTO;
import it.contrader.services.ProjectService;
import it.contrader.dto.UserDTO;
import it.contrader.model.Task;
import it.contrader.dto.TaskDTO;
import it.contrader.services.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/Project")
public class ProjectController {
	
	@Autowired
	private UserService userService;

	@Autowired
	private TaskService taskService;
	
	private final ProjectService projectService;
	
	@Autowired
	public ProjectController(ProjectService projectService) {
		this.projectService = projectService;
	}

	@RequestMapping(value = "/projectManagement", method = RequestMethod.GET)
	public List<ProjectDTO> projectManagement(@RequestParam(value = "IdUser") int userId) {
		UserDTO userDTOProjectList = new UserDTO();
		userDTOProjectList.setIdUser(userId);
		return this.projectService.findProjectDTOByUserLogin(userDTOProjectList);
	}

	// Delete
		@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
		public void delete(@RequestParam(value = "IdProject") int projectId) {
			this.projectService.deleteProjectById(projectId);
		}
		
		@RequestMapping(value = "/read", method = RequestMethod.GET)
		public ProjectDTO read(@RequestParam(value = "IdProject") int id) {
			ProjectDTO projectUpdate = new ProjectDTO();
			projectUpdate = this.projectService.getProjectDTOById(id);
			return projectUpdate;
		}

		@RequestMapping(value = "/update", method = RequestMethod.PUT)
		public void update(@RequestBody ProjectDTO project) {
			projectService.updateProject(project);
		}

		@RequestMapping(value = "/insert", method = RequestMethod.POST)
		public void insert(@RequestBody ProjectDTO project) {
			projectService.insertProject(project);
		}
		
		// Tree management methods
		@RequestMapping(value = "/insertTaskNode", method = RequestMethod.POST)  // errori(causa non c'è taskmodeldto), e lavoro con i model... (non funzionerà)
		public void insertTaskNode(@RequestParam(value = "IdUser") String userId,
				@RequestParam(value = "IdProject") String projectId,
				@RequestParam(value = "TaskModelId") String TaskModelId, 
				@RequestParam(value = "TaskFatherId") String TaskFatherId) {

			UserDTO userDTO = new UserDTO();
			userDTO = userService.getUserDTOById(Integer.parseInt(userId));

			TaskDTO taskDTO = taskService.getTaskDTOById(Integer.parseInt(TaskModelId));

			ProjectDTO projectDTO = projectService.getProjectDTOById(Integer.parseInt(projectId));
			
			// Create a task from taskModel
			TaskDTO taskNode = new TaskDTO();			//Non può 
			// taskRootDTO.setTaskId(task.getTaskId());
			taskNode.setTask(taskDTO.getTask());
			taskNode.setDataInizio(taskDTO.getDataInizio());
			taskNode.setDataFine(taskDTO.getDataFine());
			taskNode.setProjectDTO(projectDTO);
			
			List<TaskDTO> listTaskChild = new ArrayList<TaskDTO>();
			taskNode.setChildsListDTO(listTaskChild);
			
			if (Integer.parseInt(taskFatherId) != 0) {
				TaskDTO taskFather = new TaskDTO();
				taskFather = taskService.getTaskDTOById(Integer.parseInt(taskFatherId));
				//taskFather.setTaskId(Integer.parseInt(taskFatherId));
				taskNodeDTO.setTaskFather(taskFather);
			}
			
			// taskRootDTO.setTaskFather(ConverterTask.toDTO(task.getTaskFather()));
			taskService.insertTask(taskNodeDTO);
		}
		
		@RequestMapping(value = "/findRootNode", method = RequestMethod.GET)
		public TaskDTO findRootNode(@RequestParam(value = "projectId") String projectId) {
			ProjectDTO projectDTO = new ProjectDTO();
			projectDTO.setIdProject(Integer.parseInt(projectId));
			return taskService.findProjectTaskRoot(projectDTO);
		}
}
