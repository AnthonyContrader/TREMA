package it.contrader.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import it.contrader.dto.*;
import it.contrader.service.*;

public class HumanResourceServlet extends HttpServlet {

	private HumanResourceServiceDTO hrserviceDTO = new HumanResourceServiceDTO();
	private List<HumanResourceDTO> allHr = new ArrayList<HumanResourceDTO>();


	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		final String scelta = request.getParameter("richiesta");
		final HttpSession session = request.getSession(true);
		final UsersDTO userLogged = (UsersDTO) session.getAttribute("utente");

		switch (scelta) {

		case "HR_manager":
			
			allHr = this.hrserviceDTO.getAllHr();
			request.setAttribute("allHr", allHr);
			getServletContext().getRequestDispatcher("/humanresource/manageHumanResource.jsp").forward(request, response);
			break;

		case "insertRedirect":
			response.sendRedirect("humanresource/insertHumanResource.jsp");
			break;

		case "insert":
			// final int userId = Integer.parseInt(request.getParameter("user_id"));
			final String name = request.getParameter("name");
			final String surname = request.getParameter("surname");
			// UserDTO userInsert = new UserDTO("","","");

			// userInsert.setId(userId);
			final HumanResourceDTO hrin = new HumanResourceDTO(userLogged, name, surname);
			hrserviceDTO.insertHr(hrin);
			showAllHr(request, response);
			break;

		case "updateRedirect":
			int id = Integer.parseInt(request.getParameter("idHR"));
			HumanResourceDTO hrup = new HumanResourceDTO(new UsersDTO(" ", " ", " "), " ", " ");
			hrup.setId(id);

			hrup = this.hrserviceDTO.readHr(hrup);
			request.setAttribute("humanresourceUpdate", hrup);
			getServletContext().getRequestDispatcher("/humanresource/updateHumanResource.jsp").forward(request, response);

			break;

		case "update":
			final Integer hridupdate = Integer.parseInt(request.getParameter("idHR"));
			// final Integer userIdUpdate =
			// Integer.parseInt(request.getParameter("user_id"));
			final String idnameup = request.getParameter("name");
			final String idsurnameup = request.getParameter("surname");

			final HumanResourceDTO hrDTO = new HumanResourceDTO(userLogged, idnameup, idsurnameup);
			hrDTO.setId(hridupdate);
			hrserviceDTO.updateHr(hrDTO);
			showAllHr(request, response);
			break;

		case "delete":
			final Integer idhrdel = Integer.parseInt(request.getParameter("idHR"));

			final HumanResourceDTO idhrDel = new HumanResourceDTO(userLogged, "", "");
			idhrDel.setId(idhrdel);
			hrserviceDTO.deleteHr(idhrDel);
			showAllHr(request, response);
			break;

		case "indietro":
			response.sendRedirect("homeHumanResource.jsp");
			break;

		case "logsMenu":
			response.sendRedirect("index.jsp");
			break;

		}

	}
	
	// Show all client for user logged
	private void showAllHr(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		allHr.clear();
		allHr = this.hrserviceDTO.getAllHr();
		HttpSession session = request.getSession(true);
		UsersDTO userLogged=(UsersDTO) session.getAttribute("utente");
		
		for (HumanResourceDTO hrDTO:allHr) {
			if (hrDTO.getUserDTO().getId()==userLogged.getId())
				allHr.add(hrDTO);
		}
			
		request.setAttribute("allHr", allHr);
		getServletContext().getRequestDispatcher("/humanresource/manageHR.jsp").forward(request, response);
	}
}

