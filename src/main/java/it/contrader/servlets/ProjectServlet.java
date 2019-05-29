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
	private List<ProjectDTO> allClients = new ArrayList<ProjectDTO>();
	private List<ProjectDTO> filteredClients = new ArrayList<ProjectDTO>();

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		final String scelta = request.getParameter("richiesta");
		final HttpSession session = request.getSession(true);
		final UsersDTO userLogged = (UsersDTO) session.getAttribute("utente");

		switch (scelta) {

		case "Project":
			showAllProject(request, response);
			break;

		case "insertRedirect":
			response.sendRedirect("project/insertProject.jsp"); //possibile errore
			break;

		case "insert":
			
			final int idproject = Integer.parseInt(request.getParameter("idproject"));
			final String name = request.getParameter("name");
			final String descrizione = request.getParameter("descrizione");
			final String tipo = request.getParameter("tipo");
			final int iduser = Integer.parseInt(request.getParameter("iduser"));
			// UserDTO userInsert = new UserDTO("","","");

			// userInsert.setId(userId);
			final ProjectDTO projectInsert = new ProjectDTO(idproject, name, descrizione, tipo,iduser);
			projectServiceDTO.insertProject(projectInsert);
			showAllClient(request, response);
			break;

		case "updateRedirect":
			int idProject = Integer.parseInt(request.getParameter("idproject"));
			ProjectDTO projectUpdate = new ProjectDTO();
			projectUpdate.setIdproject(idproject);

			projectUpdate = this.projectServiceDTO.readProject(projectUpdate);
			request.setAttribute("projectUpdate", projectUpdate);
			getServletContext().getRequestDispatcher("/project/updateProject.jsp").forward(request, response);

			break;

		case "update":
			final Integer clientIdUpdate = Integer.parseInt(request.getParameter("client_id"));
			// final Integer userIdUpdate =
			// Integer.parseInt(request.getParameter("user_id"));
			final String clientNameUpdate = request.getParameter("client_name");

			final ClientDTO clientDTO = new ClientDTO(userLogged, clientNameUpdate);
			clientDTO.setId(clientIdUpdate);
			clientServiceDTO.updateClient(clientDTO);
			showAllClient(request, response);
			break;

		case "delete":
			final Integer clientIdDelete = Integer.parseInt(request.getParameter("id"));

			final ClientDTO clientdelete = new ClientDTO(userLogged, "");
			clientdelete.setId(clientIdDelete);
			clientServiceDTO.deleteClient(clientdelete);
			showAllClient(request, response);
			break;

		case "indietro":
			response.sendRedirect("homeBO.jsp");
			break;

		case "logsMenu":
			response.sendRedirect("index.jsp");
			break;

		}

	}
	
	private void showAllProject(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	// Show all client for user logged
	private void showAllClient(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		allClients.clear();
		filteredClients.clear();
		allClients = this.clientServiceDTO.getAllClient();
		HttpSession session = request.getSession(true);
		UserDTO userLogged=(UserDTO) session.getAttribute("utente");
		
		for (ClientDTO clientDTO:allClients) {
			if (clientDTO.getUserDTO().getId()==userLogged.getId())
				filteredClients.add(clientDTO);
		}
			
		request.setAttribute("allClient", filteredClients);
		getServletContext().getRequestDispatcher("/client/manageClient.jsp").forward(request, response);
	}
}