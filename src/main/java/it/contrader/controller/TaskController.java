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
		int idTask = Integer.parseInt(request.getParameter("idtask"));
		request.setAttribute("idTask", idTask);
		this.taskService.deleteTaskById(idTask);
		visualTask(request);
		return "task/manageTask";
	}
	
	@RequestMapping(value = "/insertRedirect", method = RequestMethod.GET)
	public String insertRedirect(HttpServletRequest request, HttpSession session) {
		List<ProjectDTO> projectList = projectService.getListProjectDTO();
		request.setAttribute("projectList", projectList);
		return "task/insertTask";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(HttpServletRequest request, HttpSession session) {
		ProjectDTO projectInsertDTO = new ProjectDTO();
		
		String taskInsert = request.getParameter("task").toString();
		String datainizioInsert = request.getParameter("data_inizio").toString();
		String datafineInsert = request.getParameter("data_fine").toString();
		String objectiveInsert = request.getParameter("objective").toString();
		int idProject = Integer.parseInt(request.getParameter("idProject"));
		projectInsertDTO.setIdProject(idProject);
		
		TaskDTO taskObj = new TaskDTO();
		
		taskObj.setTask(taskInsert);
		taskObj.setData_inizio(datainizioInsert);
		taskObj.setData_inizio(datafineInsert);
		taskObj.setData_fine(objectiveInsert);
		taskObj.setProjectDTO(projectInsertDTO);
		
		taskService.insertTask(taskObj);

		visualTask(request);
		return "task/manageTask";
	}
	
	@RequestMapping(value = "/updateRedirect", method = RequestMethod.GET)
	public String updateRedirect(HttpServletRequest request, HttpSession session) {
		List<ProjectDTO> projectList = projectService.getListProjectDTO();
		
		TaskDTO taskUpdate = new TaskDTO();
		
		int idtask = Integer.parseInt(request.getParameter("idTask"));
		taskUpdate = this.taskService.getTaskDTOByIdTask(idtask);
		
		request.setAttribute("taskUpdate", taskUpdate);
		request.setAttribute("projectList", projectList);
		
		return "task/updateTask";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(HttpServletRequest request, HttpSession session) {
		Integer idTaskUpdate = Integer.parseInt(request.getParameter("idTask"));
		String taskUpdate = request.getParameter("task");
		String datainizioUpdate = request.getParameter("data_inizio");
		String datafineUpdate = request.getParameter("data_fine");
		String objectiveUpdate = request.getParameter("objective");
		Integer projectUpdateId = Integer.parseInt(request.getParameter("idProject"));
		
		ProjectDTO projectUpdateDTO = new ProjectDTO();
		projectUpdateDTO.setIdProject(projectUpdateId);
		
		TaskDTO task = new TaskDTO();
		
		task.setIdTask(idTaskUpdate);
		task.setTask(taskUpdate);
		task.setData_inizio(datainizioUpdate);
		task.setData_fine(datafineUpdate);
		task.setObjective(objectiveUpdate);
		task.setProjectDTO(projectUpdateDTO);

		taskService.updateTask(task);
		visualTask(request);
		return "task/manageTask";
	}
}
