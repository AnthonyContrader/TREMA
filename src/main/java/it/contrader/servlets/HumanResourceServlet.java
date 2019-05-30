package it.contrader.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import it.contrader.dto.*;
import it.contrader.service.*;

public class ClientServlet extends HttpServlet {

	private ClientServiceDTO clientServiceDTO = new ClientServiceDTO();
	private List<ClientDTO> allClients = new ArrayList<ClientDTO>();
	private List<ClientDTO> filteredClients = new ArrayList<ClientDTO>();

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		final String scelta = request.getParameter("richiesta");
		final HttpSession session = request.getSession(true);
		final UserDTO userLogged = (UserDTO) session.getAttribute("utente");

		switch (scelta) {

		case "ClientManager":
			showAllClient(request, response);
			break;

		case "insertRedirect":
			response.sendRedirect("client/insertClient.jsp");
			break;

		case "insert":
			// final int userId = Integer.parseInt(request.getParameter("user_id"));
			final String clientName = request.getParameter("client_name");
			// UserDTO userInsert = new UserDTO("","","");

			// userInsert.setId(userId);
			final ClientDTO clientInsert = new ClientDTO(userLogged, clientName);
			clientServiceDTO.insertClient(clientInsert);
			showAllClient(request, response);
			break;

		case "updateRedirect":
			int id = Integer.parseInt(request.getParameter("id"));
			ClientDTO clientUpdate = new ClientDTO(new UserDTO("", "", ""), "");
			clientUpdate.setId(id);

			clientUpdate = this.clientServiceDTO.readClient(clientUpdate);
			request.setAttribute("clientUpdate", clientUpdate);
			getServletContext().getRequestDispatcher("/client/updateClient.jsp").forward(request, response);

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

