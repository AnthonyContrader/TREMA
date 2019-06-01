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
import it.contrader.dto.UsersDTO;
import it.contrader.service.HumanResourceServiceDTO;

public class HumanResourceServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private HumanResourceServiceDTO HrServiceDTO = new HumanResourceServiceDTO();
	private List<HumanResourceDTO> allHr = new ArrayList<HumanResourceDTO>();
	private List<HumanResourceDTO> filteredHr = new ArrayList<HumanResourceDTO>();

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		final String scelta = request.getParameter("richiesta");
		final HttpSession session = request.getSession(true);
		final UsersDTO userLogged = (UsersDTO) session.getAttribute("utente");

		switch (scelta) {

		case "human_manager":
			showAllHr(request, response);
			break;

		case "insertRedirect":
			response.sendRedirect("/humanresource/insertHumanResource.jsp");
			break;

		case "insert":
			// final int userId = Integer.parseInt(request.getParameter("user_id"));
			final String HrName = request.getParameter("name");
			final String HrSurname = request.getParameter("surname");
			// UserDTO userInsert = new UserDTO("","","");

			// userInsert.setId(userId);
			final HumanResourceDTO HrInsert = new HumanResourceDTO(userLogged,HrName,HrSurname);
			HrServiceDTO.insertHr(HrInsert);
			showAllHr(request, response);
			break;

		case "updateRedirect":
			int id = Integer.parseInt(request.getParameter("idHR"));
			HumanResourceDTO HrUpdate = new HumanResourceDTO(new UsersDTO("", "", ""),"","");
			HrUpdate.setId(id);

			HrUpdate = this.HrServiceDTO.readHr(HrUpdate);
			request.setAttribute("HrUpdate", HrUpdate);
			getServletContext().getRequestDispatcher("/humanresource/updateHumanResource.jsp").forward(request, response);

			break;

		case "update":
			final Integer HrIdUpdate = Integer.parseInt(request.getParameter("idHR"));
			// final Integer userIdUpdate =
			// Integer.parseInt(request.getParameter("user_id"));
			final String HrNameUpdate = request.getParameter("name");
			final String HrSurnameUpdate = request.getParameter("surname");

			final HumanResourceDTO HrDTO = new HumanResourceDTO(userLogged,HrNameUpdate,HrSurnameUpdate);
			HrDTO.setId(HrIdUpdate);
			HrServiceDTO.updateHr(HrDTO);
			showAllHr(request, response);
			break;

		case "delete":
			final Integer HrIdDelete = Integer.parseInt(request.getParameter("idHR"));
			final HumanResourceDTO Hrdelete = new HumanResourceDTO(userLogged,"","");
			Hrdelete.setId(HrIdDelete);
			HrServiceDTO.deleteHr(Hrdelete);
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
	

	// Show all project for user logged
	private void showAllHr(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		allHr.clear();
		filteredHr.clear(); 
		allHr = HrServiceDTO.getAllHr();
		HttpSession session = request.getSession(true);
		UsersDTO userLogged=(UsersDTO) session.getAttribute("utente");
		
		for (HumanResourceDTO HrDTO:allHr) {
			if (HrDTO.getUserDTO().getId()==userLogged.getId()) {
					filteredHr.add(HrDTO); }
		}
		request.setAttribute("allHr", filteredHr);
		getServletContext().getRequestDispatcher("/humanresource/manageHumanResource.jsp").forward(request, response);
	}
}
