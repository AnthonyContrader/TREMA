package it.contrader.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.*;

import it.contrader.dto.*;
import it.contrader.service.*;

public class HumanResourceServlet extends HttpServlet {
		
		private static final long serialVersionUID = 1L;
		private int idhr;
		private HttpSession session;
		private int iduser;
		public HumanResourceServlet() {}
		
		public void updateList(HttpServletRequest request) {
			session.getAttribute("idHR");
			ServiceDTO<HumanResourceDTO> service=new HumanResourceService();
		}
		
		@Override
		public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
			final String  scelta= request.getParameter("richiesta"); //da dove spunta richiesta??
			final HttpSession session=request.getSession(true);
		//	this.userLogged=(UsersDTO) session.getAttribute("iduser");// possibile errore
			
			switch(scelta) {
			
			case "HumanResource":
				 showAllHumanResource(request, response);
				break;
			case "insertRedirect":
				response.sendRedirect("humanresource/insertHumanResource.jsp");
			case "insert":
				final int idHr=Integer.parseInt(request.getParameter("idHR"));
				final String name = request.getParameter("name");
				final String surname = request.getParameter("surname");
				final int iduser=Integer.parseInt(request.getParameter("iduser"));
				
			//	final HumanResourceDTO hrinsert=HumanResourceDTO(idHr, name, surname, iduser);
				//hrDTO.insertHR(hrinsert);
				showAllHumanResource(request, response);
				break;
			}
		}
}

