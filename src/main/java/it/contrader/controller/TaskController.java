package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.dto.TaskDTO;
import it.contrader.services.TaskService;
import it.contrader.dto.ProjectDTO;
import it.contrader.services.ProjectService;

import java.util.List;

@Controller
@RequestMapping("/Task")
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
		ProjectDTO projectDTO = (ProjectDTO) session.getAttribute("idProject");
		List<TaskDTO> allTask = this.taskService.getListaTaskDTOByProject(projectDTO);
		request.setAttribute("allTaskDTO", allTask);
	}
	
	@RequestMapping(value = "/taskManagement", method = RequestMethod.GET)
	public String taskManagement(HttpServletRequest request) {
		visualTask(request);
		return "task/manageTask";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		int idTask = Integer.parseInt(request.getParameter("idTask"));
		request.setAttribute("idTask", idTask);
		this.taskService.deleteTaskByIdTask(idTask);
		visualTask(request);
		return "task/manageTask";
	}
	
	@RequestMapping(value = "/insertRedirect", method = RequestMethod.GET)
	public String insertRedirect(HttpServletRequest request, HttpSession session) {
		List<ProjectDTO> projectList = projectService.getListProjectDTO();
		request.setAttribute("projectList", projectList);
		// visualTask(request);
		// request.setAttribute("option", "insert");
		return "task/insertTask";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(HttpServletRequest request, HttpSession session) {
		ProjectDTO projectInsertDTO = new ProjectDTO();
		
		String taskInsert = request.getParameter("task").toString();
		String datainizioInsert = request.getParameter("data_inizio").toString();
		String datafineInsert = request.getParameter("data_fine").toString();
		String objectiveInsert = request.getParameter("objective").toString();
		int idprojectInsert = Integer.parseInt(request.getParameter("idProject"));
		projectInsertDTO.setIdProject(idprojectInsert);
				
		TaskDTO taskDTO = new TaskDTO();
		
		taskDTO.setTask(taskInsert);
		taskDTO.setData_inizio(datainizioInsert);
		taskDTO.setData_fine(datafineInsert);
		taskDTO.setObjective(objectiveInsert);
		taskDTO.setProjectDTO(projectInsertDTO);
		
		taskService.insertTask(taskDTO);

		visualTask(request);
		return "task/manageTask";
	}

	@RequestMapping(value = "/updateRedirect", method = RequestMethod.GET)
	public String updateRedirect(HttpServletRequest request, HttpSession session) {
		List<ProjectDTO> projectList = projectService.getListProjectDTO();
		TaskDTO taskUpdate = new TaskDTO();
		int idTask = Integer.parseInt(request.getParameter("idTask"));
		taskUpdate = this.taskService.getTaskDTOByIdTask(idTask);
		
		request.setAttribute("taskUpdate", taskUpdate);
		request.setAttribute("resourceList", projectList);
		
		return "task/updateTask";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(HttpServletRequest request, HttpSession session) {
		Integer idTaskUpdate = Integer.parseInt(request.getParameter("idTask"));
		String taskUpdate = request.getParameter("task");
		String datainizioUpdate = request.getParameter("data_fine");
		String datafineUpdate = request.getParameter("data_inizio");
		String objectiveUpdate = request.getParameter("objective");
		Integer idProjectUpdate = Integer.parseInt(request.getParameter("idProject"));
		
		ProjectDTO projectDTO = new ProjectDTO();
		projectDTO.setIdProject(idProjectUpdate);
		
		TaskDTO taskDTO = new TaskDTO();
		taskDTO.setIdTask(idTaskUpdate);
		taskDTO.setTask(taskUpdate);
		taskDTO.setData_inizio(datainizioUpdate);
		taskDTO.setData_fine(datafineUpdate);
		taskDTO.setObjective(objectiveUpdate);
		taskDTO.setProjectDTO(projectDTO);
		
		taskService.updateTask(taskDTO);
		visualTask(request);
		return "task/manageTask";
	}
}
