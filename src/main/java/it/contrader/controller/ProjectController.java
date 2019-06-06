package it.contrader.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.dto.ProjectDTO;
import it.contrader.dto.TaskDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Project;
import it.contrader.services.ProjectService;

@Controller

@RequestMapping("/Project")
public class ProjectController {
	private final ProjectService projectService;
	@Autowired
	private HttpSession session;

	@Autowired
	public ProjectController(ProjectService projectService) {
		this.projectService = projectService;
	}

	private void visualProject(HttpServletRequest request) {
		UserDTO userDTO = (UserDTO) session.getAttribute("utente");
		List<ProjectDTO> allProject = this.projectService.findProjectDTOByUser(userDTO);
		request.setAttribute("allProjectDTO", allProject);
	}

	@RequestMapping(value = "/projectManagement", method = RequestMethod.GET)
	public String prjectManagement(HttpServletRequest request) {
		visualProject(request);
		return "project/manageProject";
	}

	// Delete
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("idProject"));
		request.setAttribute("idProject", id);
		this.projectService.deleteProjectById(id);
		visualProject(request);
		return "project/manageProject";

	}

	@RequestMapping(value = "/updateRedirect", method = RequestMethod.GET)
	public String updateRedirect(HttpServletRequest request, HttpSession session) {
		int id = Integer.parseInt(request.getParameter("idProject"));
		UserDTO userDTO = (UserDTO) session.getAttribute("utente");

		ProjectDTO projectUpdate = this.projectService.getProjectDTOById(id); // ProjectDTO projectUpdate = this.projectService.getProjectDTOById(id);
	//	List<TaskDTO> taskList = projectService.findTaskDTOByProject(projectUpdate);

	//	request.setAttribute("taskList", taskList);
		request.setAttribute("projectUpdate", projectUpdate);

		return "project/updateProject";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(HttpServletRequest request, HttpSession session) {
		UserDTO userLogged = (UserDTO) session.getAttribute("utente");
		Integer idUpdate = Integer.parseInt(request.getParameter("idProject"));
		String tipologia = request.getParameter("tipologia");
		String project = request.getParameter("project");

		List<TaskDTO> taskList = new ArrayList<TaskDTO>();
		String taskListString[] = (String[]) request.getParameterValues("taskList");
		for (String taskString : taskListString) {
			TaskDTO taskDTO = new TaskDTO();
			taskDTO.setIdTask(Integer.parseInt(taskString));
			taskList.add(taskDTO);
		}

		ProjectDTO project1 = new ProjectDTO();
		project1.setUserDTO(userLogged);
		project1.setIdProject(idUpdate);
		project1.setProject(project);
		project1.setTipologia(tipologia);
		project1.setTaskDTO(taskList);
		projectService.updateProject(project1);
		visualProject(request);
		return "project/manageProject";
	}

	@RequestMapping(value = "/insertRedirect", method = RequestMethod.GET)
	public String insert(HttpServletRequest request, HttpSession session) {
		UserDTO userDTO = (UserDTO) session.getAttribute("utente");
		List<ProjectDTO> projectlist=projectService.findProjectDTOByUser(userDTO);	//mi trovo i project in base ai user
		request.setAttribute("projectList", projectlist);
		return "project/insertProject";
	}	
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insertProject(HttpServletRequest request, HttpSession session) {
		UserDTO userLogged = (UserDTO) session.getAttribute("utente");
		String name = request.getParameter("project").toString();
		
		List<TaskDTO> taskList = new ArrayList<TaskDTO>();
		String taskListString[] =(String []) request.getParameterValues("taskList");
		
		for(String taskString : taskListString) {
			TaskDTO taskDTO=new TaskDTO();
			taskDTO.setIdTask(Integer.parseInt(taskString));
			taskList.add(taskDTO);
		}
		
		ProjectDTO projectObj = new ProjectDTO();
		projectObj.setProject(name);
		projectObj.setUserDTO(userLogged);
		projectObj.setTaskDTO(taskList);
		
		projectService.insertProject(projectObj);
		visualProject(request);
		return "project/manageProject";

	}
}
