package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.dto.TaskDTO;
import it.contrader.dto.ProjectDTO;
import it.contrader.service.ProjectService;
import it.contrader.service.TaskService;

import java.util.List;

public class TaskController {
	private final TaskService taskService;
	private final ProjectService projectService;
	
	@Autowired
	private HttpSession session;

	@Autowired
	public TaskController(TaskService taskService, ProjectService projectService) {
		this.taskService = taskService;
		this.projectService = projectService;
	}

	private void visualTask(HttpServletRequest request) {
		//UserDTO userDTO = (UserDTO) session.getAttribute("utente");
		//List<TaskDTO> allTask = this.taskService.getListaTaskDTOByUser(userDTO);
		request.setAttribute("allTaskDTO", allTask);
	}

	@RequestMapping(value = "/taskManagement", method = RequestMethod.GET)
	public String taskManagement(HttpServletRequest request) {
		visualTask(request);
		return "task/manageTask";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		int idtask = Integer.parseInt(request.getParameter("idtask"));
		request.setAttribute("idtask", idtask);
		this.taskService.deleteTaskById(idtask);
		visualTask(request);
		return "task/manageTask";
	}
	
	@RequestMapping(value = "/insertRedirect", method = RequestMethod.GET)
	public String insertRedirect(HttpServletRequest request, HttpSession session) {
		//UserDTO userLogged = (UserDTO) session.getAttribute("utente");
		int idproject = Integer.parseInt(request.getParameter("idproject"));
		List<ProjectDTO> projectList = projectService.findProjectDTOByProject(idproject);
		request.setAttribute("resourceList", projectList);
		// visualTask(request);
		// request.setAttribute("option", "insert");
		return "task/insertTask";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(HttpServletRequest request, HttpSession session) {

		
		//UserDTO userLogged = (UserDTO) session.getAttribute("utente");
		ProjectDTO projectInsertDTO = new ProjectDTO();
		
		String taskTask = request.getParameter("task").toString();
		String taskDataInizio = request.getParameter("data_inizio").toString();
		String taskDataFine = request.getParameter("data_fine").toString();
		String taskObjective = request.getParameter("objective").toString();
		int projectInsertId = Integer.parseInt(request.getParameter("idproject"));
		projectInsertDTO.setProjectId(projectInsertId);
		
		
		TaskDTO taskObj = new TaskDTO();
		taskObj.setTaskTask(taskTask);
		taskObj.setTaskDataInizio(taskDataInizio);
		taskObj.setTaskDataFine(taskDataFine);
		taskObj.setTaskObjective(taskObjective);
		taskObj.setProjectDTO(projectInsertId);
		taskService.insertTask(taskObj);

		visualTask(request);
		return "task/manageTask";
	}
	
	@RequestMapping(value = "/updateRedirect", method = RequestMethod.GET)
	public String updateRedirect(HttpServletRequest request, HttpSession session) {
		//UserDTO userLogged = (UserDTO) session.getAttribute("utente");
		ProjectDTO projectdto = (ProjectDTO) session.getAttribute("idproject");
		TaskDTO taskUpdate = new TaskDTO();
		
		//List<ResourceDTO> resourceList = resourceService.findResourceDTOByUser(userLogged);
		
		int idproject = Integer.parseInt(request.getParameter("idproject"));
		
		taskUpdate = this.taskService.getTaskDTOByProject(idproject);
		
		request.setAttribute("taskUpdate", taskUpdate);
		//request.setAttribute("resourceList", resourceList);
		
		return "task/updateTask";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(HttpServletRequest request, HttpSession session) {
		Integer idtaskUpdate = Integer.parseInt(request.getParameter("idtask"));
		String taskUpdate = request.getParameter("task");
		String datainizioUpdate = request.getParameter("data_inizio");
		String datafineUpdate = request.getParameter("data_fine");
		String objectiveUpdate = request.getParameter("objective");
		Integer projectUpdateId = Integer.parseInt(request.getParameter("idproject"));
		
		ProjectDTO projectUpdateDTO = new ProjectDTO();
		projectUpdateDTO.setProjectId(projectUpdateDTO);
		
		TaskDTO task = new TaskDTO();
		task.setTaskId(idtaskUpdate);
		task.setTaskTask(taskUpdate);
		task.setTaskDataInizio(datainizioUpdate);
		task.setTaskDataFine(datafineUpdate);
		task.setTaskObjective(objectiveUpdate);
		task.setProjectDTO(projectUpdateDTO);
		

		taskService.updateTask(task);
		visualTask(request);
		return "task/manageTask";
	
}
