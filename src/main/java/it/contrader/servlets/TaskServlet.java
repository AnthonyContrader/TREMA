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

public class TaskServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private final TaskServiceDTO taskServiceDTO = new TaskServiceDTO();
	private List<TaskDTO> allTasks = new ArrayList<>();
	//private List<TaskDTO> filteredTasks = new ArrayList<>();
	
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
				projectDTO = new ProjectDTO(null, null, null, null);
				projectDTO.setId(idproject);
				
				hrDTO = null;
				hrDTO = new HumanResourceDTO("", "", null);
				hrDTO.setId(idhr);
				
				taskDTO = null;
				taskDTO = new TaskDTO(descrizione_task, projectDTO, hrDTO);
				taskServiceDTO.insertTask(taskDTO);
				showAllTasks(request, response);
				break;

			case "updateRedirect":
				idtask = Integer.parseInt(request.getParameter("idtask"));
				
				taskDTO = null;
				taskDTO = new TaskDTO(null, null, null);
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
				projectDTO = new ProjectDTO(null, null, null, null);
				projectDTO.setId(idproject);
				
				hrDTO = null;
				hrDTO = new HumanResourceDTO("", "", null);
				hrDTO.setId(idhr);
				
				taskDTO = null;
				taskDTO = new TaskDTO(descrizione_task, projectDTO, hrDTO);
				taskServiceDTO.updateTask(taskDTO);
				showAllTasks(request, response);
				break;

			case "delete":
				idtask = Integer.parseInt(request.getParameter("idtask"));
				
				taskDTO = null;
				taskDTO = new TaskDTO(null, null, null);
				taskDTO.setIdtask(idtask);
				taskServiceDTO.deleteTask(taskDTO);
				showAllTasks(request, response);
				break;

			case "indietro":
				response.sendRedirect("homeProject.jsp");
				break;

			case "logsMenu":
				response.sendRedirect("index.jsp");
				break;

		}
	}
	
	private void showAllTasks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		allTasks.clear();
		//filteredTasks.clear();
		allTasks = taskServiceDTO.getAllTask();
		/*
		HttpSession session = request.getSession(true);
		
		ProjectDTO idprojectDTO = (ProjectDTO) session.getAttribute("id");
		HumanResourceDTO idhrDTO = (HumanResourceDTO) session.getAttribute("id");
		
		for (TaskDTO taskDTO : allTasks) {
			if (taskDTO.getProjectDTO().getId() == idprojectDTO.getId())
				filteredTasks.add(taskDTO);
			
			if (taskDTO.getHRDTO().getId() == idhrDTO.getId())
				filteredTasks.add(taskDTO);
		} */
				
		request.setAttribute("allTasks", allTasks);
		getServletContext().getRequestDispatcher("/task/manageTask.jsp").forward(request, response);
	}
}
