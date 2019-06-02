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
	private List<HumanResourceDTO> allHr = new ArrayList<>();
	private List<HumanResourceDTO> filteredHr = new ArrayList<>();

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
			final String HrName = request.getParameter("name");
			final String HrSurname = request.getParameter("surname");
			final HumanResourceDTO HrInsert = new HumanResourceDTO(userLogged,HrName,HrSurname);
			System.out.println(" "+HrName+" "+HrSurname+" "+userLogged.getId());

			HrServiceDTO.insertHr(HrInsert);
			showAllHr(request, response);
			break;

		case "updateRedirect":
<<<<<<< HEAD
			int id = Integer.parseInt(request.getParameter("idHR"));
			HumanResourceDTO HrUpdate = new HumanResourceDTO(new UsersDTO(" ", " ", " "), " ", " ");
			HrUpdate.setId(id);
			HrUpdate = this.HrServiceDTO.readHr(HrUpdate);
			System.out.println(" "+HrUpdate.getName()+" "+HrUpdate.getSurname());
=======
			final Integer id = Integer.parseInt(request.getParameter("id"));
			HumanResourceDTO HrUpdate = new HumanResourceDTO(new UsersDTO("", "", ""), "", "");
			HrUpdate.setId(id);
			HrUpdate = this.HrServiceDTO.readHr(HrUpdate);
			
			System.out.println(" "+HrUpdate.getName()+" "+HrUpdate.getSurname());
			
>>>>>>> b798bbf57ae9fd409c790837883f397b03e018f4
			request.setAttribute("HrUpdate", HrUpdate);
			getServletContext().getRequestDispatcher("/humanresource/updateHumanResource.jsp").forward(request, response);

			break;

		case "update":
<<<<<<< HEAD
			final int HrIdUpdate = Integer.parseInt(request.getParameter("idHr"));
			final String HrNameUpdate = request.getParameter("name");
			final String HrSurnameUpdate = request.getParameter("surname");
=======
			//System.out.println(" "+userLogged);
			final Integer HrIdUpdate = Integer.parseInt(request.getParameter("id"));
			final String HrNameUpdate = request.getParameter("name").toString();
			final String HrSurnameUpdate = request.getParameter("surname").toString();
			
			System.out.println(" "+HrIdUpdate+" "+ HrNameUpdate+" "+HrSurnameUpdate);
			
>>>>>>> b798bbf57ae9fd409c790837883f397b03e018f4
			final HumanResourceDTO HrDTO = new HumanResourceDTO(userLogged,HrNameUpdate,HrSurnameUpdate);
			HrDTO.setId(HrIdUpdate);
			HrServiceDTO.updateHr(HrDTO);
			showAllHr(request, response);
			break;

		case "delete":
<<<<<<< HEAD
			final int HrIdDelete = Integer.parseInt(request.getParameter("idhR"));
=======
			final int HrIdDelete = Integer.parseInt(request.getParameter("idhr"));
>>>>>>> b798bbf57ae9fd409c790837883f397b03e018f4
			final HumanResourceDTO Hrdelete = new HumanResourceDTO(userLogged," "," ");
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
	private void showAllHr(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		allHr.clear();
		filteredHr.clear(); 
		allHr = HrServiceDTO.getAllHr();
		HttpSession session = request.getSession(true);
		UsersDTO userLogged=(UsersDTO) session.getAttribute("utente");
		System.out.println(" "+userLogged.getId());
		for (HumanResourceDTO HrDTO:allHr) {
<<<<<<< HEAD
			if (HrDTO.getUserDTO().getId()==userLogged.getId()) 
					filteredHr.add(HrDTO); 
			//System.out.println(" "+ HrDTO.getName()+" "+ HrDTO.getSurname());
=======
			if (HrDTO.getUserDTO().getId()==userLogged.getId()) { 
					filteredHr.add(HrDTO); }
			System.out.println(" "+ HrDTO.getName()+" "+ HrDTO.getSurname());
>>>>>>> b798bbf57ae9fd409c790837883f397b03e018f4
		}
		request.setAttribute("allHr", filteredHr);
		getServletContext().getRequestDispatcher("/humanresource/manageHumanResource.jsp").forward(request, response);
	}
}
