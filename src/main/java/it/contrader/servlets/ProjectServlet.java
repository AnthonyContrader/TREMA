package it.contrader.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.contrader.dto.ProjectDTO;
import it.contrader.dto.UsersDTO;
import it.contrader.service.ProjectServiceDTO;

public class ProjectServlet extends HttpServlet {

	private ProjectServiceDTO projectServiceDTO = new ProjectServiceDTO();
	private List<ProjectDTO> allProjects = new ArrayList<ProjectDTO>();
	private List<ProjectDTO> filteredProjects = new ArrayList<ProjectDTO>();

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		final String scelta = request.getParameter("richiesta");
		final HttpSession session = request.getSession(true);
		final UsersDTO userLogged = (UsersDTO) session.getAttribute("utente");

		switch (scelta) {

		case "project_manager":
			showAllProject(request, response);
			break;

		case "insertRedirect":
			response.sendRedirect("project/insertProject.jsp");
			break;

		case "insert":
			// final int userId = Integer.parseInt(request.getParameter("user_id"));
			final String projectName = request.getParameter("name");
			final String descrizione = request.getParameter("descrizione");
			final String tipo = request.getParameter("tipo");
			// UserDTO userInsert = new UserDTO("","","");

			// userInsert.setId(userId);
			final ProjectDTO projectInsert = new ProjectDTO(projectName,descrizione,tipo,userLogged);
			projectServiceDTO.insertProject(projectInsert);
			showAllProject(request, response);
			break;

		case "updateRedirect":
			int id = Integer.parseInt(request.getParameter("idproject"));
			ProjectDTO projectUpdate = new ProjectDTO("","","",new UsersDTO("", "", ""));
			projectUpdate.setId(id);

			projectUpdate = this.projectServiceDTO.readProject(projectUpdate);
			request.setAttribute("projectUpdate", projectUpdate);
			getServletContext().getRequestDispatcher("/project/updateProject.jsp").forward(request, response);

			break;

		case "update":
			final Integer projectIdUpdate = Integer.parseInt(request.getParameter("idproject"));
			// final Integer userIdUpdate =
			// Integer.parseInt(request.getParameter("user_id"));
			final String projectNameUpdate = request.getParameter("name");
			final String descrizioneUpdate = request.getParameter("descrizione");
			final String tipoUpdate = request.getParameter("tipo");

			final ProjectDTO projectDTO = new ProjectDTO(projectNameUpdate,descrizioneUpdate,tipoUpdate,userLogged);
			projectDTO.setId(projectIdUpdate);
			projectServiceDTO.updateProject(projectDTO);
			showAllProject(request, response);
			break;

		case "delete":
			final Integer projectIdDelete = Integer.parseInt(request.getParameter("idproject"));

			final ProjectDTO projectdelete = new ProjectDTO("","","",userLogged);
			projectdelete.setId(projectIdDelete);
			projectServiceDTO.deleteProject(projectdelete);
			showAllProject(request, response);
			break;

		case "indietro":
			response.sendRedirect("homeAdmin.jsp"); // DA MODIFICARE CON LA VIEW CORRETTA
			break;

		case "logsMenu":
			response.sendRedirect("index.jsp");
			break;

		}

	}
	

	// Show all project for user logged
	private void showAllProject(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		allProjects.clear();
		filteredProjects.clear(); 
		allProjects = this.projectServiceDTO.getAllProject();
		HttpSession session = request.getSession(true);
		UsersDTO userLogged=(UsersDTO) session.getAttribute("utente");
		
		for (ProjectDTO projectDTO:allProjects) {
			if (projectDTO.getUserDTO().getId()==userLogged.getId())
				filteredProjects.add(projectDTO); 
		}
			
		request.setAttribute("allProjects", filteredProjects);
		getServletContext().getRequestDispatcher("/project/manageProject.jsp").forward(request, response);
	}
}
