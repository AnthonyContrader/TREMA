package it.contrader.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.contrader.dto.HumanResourceDTO;
import it.contrader.dto.ProjectDTO;
import it.contrader.dto.TaskDTO;

import it.contrader.service.TaskServiceDTO;
import it.contrader.service.ProjectServiceDTO;
import it.contrader.service.HumanResourceServiceDTO;

public class TaskServlet extends HttpServlet{
	private TaskServiceDTO taskServiceDTO = new TaskServiceDTO();
	private List<TaskDTO> allTasks = new ArrayList<TaskDTO>();
	private List<TaskDTO> filteredTasks = new ArrayList<TaskDTO>();
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String scelta = request.getParameter("richiesta");
		final HttpSession session = request.getSession(true);
		
		int idtask;
		String descrizione_task;
		Integer idproject;
		Integer idhr;
		HumanResourceDTO hrDTO;
		ProjectDTO projectDTO;
		TaskDTO taskDTO;
		
		switch (scelta) {
			case "project_manager":
				showAllTasks(request, response);
				break;
				
			case "insertRedirect":
				response.sendRedirect("task/insertTask.jsp");
				break;

		case "insert":
			descrizione_task = request.getParameter("descrizione_task");
			idproject = Integer.parseInt(request.getParameter("idproject"));
			idhr = Integer.parseInt(request.getParameter("idhr"));
			
			projectDTO = null;
			projectDTO = new ProjectDTO("", "", "", null);
			projectDTO.setId(idproject);
			
			hrDTO = null;
			hrDTO = new HumanResourceDTO(null, null, null);
			hrDTO.setId(idhr);
			
			taskDTO = null;
			taskDTO = new TaskDTO(descrizione_task, projectDTO, hrDTO);
			taskServiceDTO.insertTask(taskDTO);
			showAllTasks(request, response);
			break;

		case "updateRedirect":
			idtask = Integer.parseInt(request.getParameter("idtask"));
			
			taskDTO = null;
			taskDTO = new TaskDTO("", null, null);
			taskDTO.setIdtask(idtask);

			taskDTO = this.taskServiceDTO.readTask(taskDTO);
			request.setAttribute("taskUpdate", taskDTO);
			getServletContext().getRequestDispatcher("/task/updateTask.jsp").forward(request, response);

			break;

		case "update":
			idtask = Integer.parseInt(request.getParameter("idtask"));
			descrizione_task = request.getParameter("descrizione_task");
			idproject = Integer.parseInt(request.getParameter("idproject"));
			idhr = Integer.parseInt(request.getParameter("idhr"));
			
			projectDTO = null;
			projectDTO = new ProjectDTO("", "", "", null);
			projectDTO.setId(idproject);
			
			hrDTO = null;
			hrDTO = new HumanResourceDTO(null, null, null);
			hrDTO.setId(idhr);
			
			taskDTO = null;
			taskDTO = new TaskDTO(descrizione_task, projectDTO, hrDTO);
			taskServiceDTO.updateTask(taskDTO);
			showAllTasks(request, response);
			break;

		case "delete":
			idtask = Integer.parseInt(request.getParameter("idtask"));
			
			taskDTO = null;
			taskDTO = new TaskDTO("", null, null);
			taskDTO.setIdtask(idtask);
			taskServiceDTO.deleteTask(taskDTO);
			showAllTasks(request, response);
			break;

		case "indietro":
			response.sendRedirect("homeBO.jsp");
			break;

		case "logsMenu":
			response.sendRedirect("index.jsp");
			break;

		}
	}
	
	private void showAllTasks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		allTasks.clear();
		filteredTasks.clear();
		allTasks = this.taskServiceDTO.getAllTask();
		HttpSession session = request.getSession(true);
		
		ProjectDTO projectDTO = new ProjectDTO("", "", "", null);
		int idproject = Integer.parseInt(request.getParameter("idproject"));
		projectDTO.setId(idproject);
		
		HumanResourceDTO hrDTO = new HumanResourceDTO(null, null, null);
		int idhr = Integer.parseInt(request.getParameter("idHR"));
		hrDTO.setId(idhr);
		
		ProjectDTO idprojectDTO = (ProjectDTO) session.getAttribute("idproject");
		
		for (TaskDTO taskDTO : allTasks) {
			if (taskDTO.getProjectDTO().getId() == projectDTO.getId())
				filteredTasks.add(taskDTO);
			
			if (taskDTO.getHRDTO().getId() == hrDTO.getId())
				filteredTasks.add(taskDTO);
		}
				
		request.setAttribute("allTask", filteredTasks);
		getServletContext().getRequestDispatcher("/task/manageTask.jsp").forward(request, response);
	}
}
