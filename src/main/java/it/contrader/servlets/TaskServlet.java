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
	//private HumanResourceServiceDTO hrServiceDTO = new HumanResourceServiceDTO();
	private List<TaskDTO> allTasks = new ArrayList<TaskDTO>();
	private List<TaskDTO> filteredTasks = new ArrayList<TaskDTO>();
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String scelta = request.getParameter("richiesta");
		//final HttpSession session = request.getSession(true);
		
		int idtask;
		String descrizioneTask;
		int idproject;
		int idhr;
		HumanResourceDTO hrDTO;
		ProjectDTO projectDTO;
		
		// Here I don't know if userLogged is the general user that login in the app
		// or is only the user of the entity.
		//final UsersDTO userLogged = (UsersDTO) session.getAttribute("utente");
		
		switch (scelta) {
			case "MaterialManager":
				showAllTasks(request, response);
				break;
				
			case "insertRedirect":
				response.sendRedirect("task/insertTask.jsp");
				break;

		case "insert":
			descrizioneTask = request.getParameter("descrizione_task");
			idproject = Integer.parseInt(request.getParameter("idproject"));
			idhr = Integer.parseInt(request.getParameter("idHR"));
			
			projectDTO = new ProjectDTO("", "", "", null);
			projectDTO.setId(idproject);
			
			hrDTO = new HumanResourceDTO(null, null, null);
			hrDTO.setId(idhr);
			
			final TaskDTO taskInsert = new TaskDTO(descrizioneTask, projectDTO, hrDTO);
			taskServiceDTO.insertTask(taskInsert);
			showAllTasks(request, response);
			break;

		case "updateRedirect":
			idtask = Integer.parseInt(request.getParameter("idmaterial"));
			
			TaskDTO taskUpdate = new TaskDTO("", null, null);
			taskUpdate.setIdtask(idtask);

			taskUpdate = this.taskServiceDTO.readTask(taskUpdate);
			request.setAttribute("taskUpdate", taskUpdate);
			getServletContext().getRequestDispatcher("/task/updateTask.jsp").forward(request, response);

			break;

		case "update":
			idtask = Integer.parseInt(request.getParameter("idtask"));
			descrizioneTask = request.getParameter("descrizione_task");
			idproject = Integer.parseInt(request.getParameter("idHR"));
			idhr = Integer.parseInt(request.getParameter("idHR"));
			
			projectDTO = new ProjectDTO("", "", "", null);
			projectDTO.setId(idproject);
			
			hrDTO = new HumanResourceDTO(null, null, null);
			hrDTO.setId(idhr);
			
			final TaskDTO taskDTO = new TaskDTO(descrizioneTask, projectDTO, hrDTO);
			taskDTO.setIdtask(idtask);
			taskServiceDTO.updateTask(taskDTO);
			showAllTasks(request, response);
			break;

		case "delete":
			final Integer materialIdDelete = Integer.parseInt(request.getParameter("idtask"));

			final TaskDTO taskdelete = new TaskDTO("", null, null);
			taskdelete.setIdtask(materialIdDelete);
			taskServiceDTO.deleteTask(taskdelete);
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
	
	// Show all material for user logged.. (
	// I think that here all materials must be showed from the actual HR...
	private void showAllTasks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		allTasks.clear();
		filteredTasks.clear();
		allTasks = this.taskServiceDTO.getAllTask();
		//HttpSession session = request.getSession(true);
		
		ProjectDTO projectDTO = new ProjectDTO("", "", "", null);
		int idproject = Integer.parseInt(request.getParameter("idproject"));
		projectDTO.setId(idproject);
		
		HumanResourceDTO hrDTO = new HumanResourceDTO(null, null, null);
		int idhr = Integer.parseInt(request.getParameter("idHR"));
		hrDTO.setId(idhr);
		
		for (TaskDTO taskDTO : allTasks) {
			if (taskDTO.getProjectDTO().getId() == projectDTO.getId())
				filteredTasks.add(taskDTO);
			
			if (taskDTO.getHRDTO().getId() == hrDTO.getId())
				filteredTasks.add(taskDTO);
		}
				
		request.setAttribute("allMaterial", filteredTasks);
		getServletContext().getRequestDispatcher("/task/manageTask.jsp").forward(request, response);
	}
}
