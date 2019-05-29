package it.contrader.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import it.contrader.dto.*;
import it.contrader.service.*;

public class HumanResourceServlet extends HttpServlet {
		
		private static final long serialVersionUID = 1L;
		private int idhr;
		private HttpSession session;
		public HumanResourceServlet() {}
		
		public void updateList(HttpServletRequest request) {
			session.getAttribute("idhr" );
			ServiceDTO<HumanResourceDTO> service = new HumanResourceServiceDTO();
			List<HumanResourceDTO> listDTO = service.getAllBy(idhr);
			request.setAttribute("list", listDTO);
		}
		
		@Override
		public void service (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			ServiceDTO<HumanResourceDTO> service = new HumanResourceServiceDTO();
		    
		    if(request.getParameter("idHR")!=null) {
		    	idhr = Integer.parseInt(request.getParameter("idHR").toString());
		    }
			
		    HumanResourceDTO hrdto;
			boolean ans;
			int iduser;
			String name, surname;
			
			
		    String mode = request.getParameter("mode");
			
			session = request.getSession();
			session.setAttribute("idHR",idhr);
			
			switch (mode.toUpperCase()) {

			case "HRLISTBY":
				updateList(request);
				getServletContext().getRequestDispatcher("/item/hrmanager.jsp").forward(request, response);
				break;

			case "HRLISTTOP":
				updateList(request);
				getServletContext().getRequestDispatcher("/hrhome.jsp").forward(request, response);
				break;

			case "READ":
				hrdto = service.read(idhr);
				request.setAttribute("hrdto", hrdto); //possibile error
				getServletContext().getRequestDispatcher("/item/hrread.jsp").forward(request, response);
				break;

			case "INSERT":
				name= request.getParameter("name");
				surname= request.getParameter("surname");
				iduser = Integer.parseInt(request.getParameter("iduser"));
				hrdto = new HumanResourceDTO (name, surname, iduser);
				ans = service.insert(hrdto);
				request.setAttribute("ans", ans);
				updateList(request);
				getServletContext().getRequestDispatcher("/item/hrinsert.jsp").forward(request, response);
				break;

			case "PREUPDATE":
				hrdto = service.read(idhr);
				request.setAttribute("hrdto", hrdto);
				getServletContext().getRequestDispatcher("/item/hrpreupdate.jsp").forward(request, response);
				break;

			case "UPDATE":
				name = request.getParameter("name");
				surname= request.getParameter("surname");
				iduser = Integer.parseInt(request.getParameter("iduser"));
				int idToUpdate = Integer.parseInt(request.getParameter("idToUpdate"));
				hrdto = new HumanResourceDTO(idToUpdate,name, surname, iduser);
				ans = service.update(hrdto);
				request.setAttribute("ans", ans);
				System.out.println(ans);
				updateList(request);
				getServletContext().getRequestDispatcher("/item/hrupdate.jsp").forward(request, response);
				break;

			case "DELETE":
				hrdto = service.read(idhr);
				ans = service.delete(hrdto);
				request.setAttribute("ans", ans);
				updateList(request);
				getServletContext().getRequestDispatcher("/item/hrdelete.jsp").forward(request, response);
				break;
			}
		}
}

