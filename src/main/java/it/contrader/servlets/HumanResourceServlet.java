package it.contrader.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
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
			session.getAttribute("idhr" );
			ServiceDTO<HumanResourceDTO> service = new HumanResourceServiceDTO();
			List<HumanResourceDTO> listDTO = service.getAllBy(idhr);
			request.setAttribute("list", listDTO);
		}
		
		@Override
		public void service (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			ServiceDTO<HumanResourceDTO> service = new HumanResourceServiceDTO();
		    
		    if(request.getParameter("idhr")!=null) {
		    	idhr = Integer.parseInt(request.getParameter("idHR").toString());
		    }

			if(request.getParameter("id")!=null) {
				id = Integer.parseInt(request.getParameter("id"));
		    }
			
			ItemDTO dto;
			boolean ans;
			String description, itemType;
			
			
		    String mode = request.getParameter("mode");
			
			session = request.getSession();
			session.setAttribute("ambientId",ambientId);
			
			switch (mode.toUpperCase()) {

			case "ITEMLISTBY":
				updateList(request);
				getServletContext().getRequestDispatcher("/item/itemmanager.jsp").forward(request, response);
				break;

			case "ITEMLISTOP":
				updateList(request);
				getServletContext().getRequestDispatcher("/homeoperatore.jsp").forward(request, response);
				break;

			case "READ":
				dto = service.read(id);
				request.setAttribute("dto", dto);
				getServletContext().getRequestDispatcher("/item/readitem.jsp").forward(request, response);
				break;

			case "INSERT":
				description= request.getParameter("description");
				itemType= request.getParameter("itemType");
				int ambientId = Integer.parseInt(request.getParameter("ambientId"));
				dto = new ItemDTO (description, itemType, ambientId);
				ans = service.insert(dto);
				request.setAttribute("ans", ans);
				updateList(request);
				getServletContext().getRequestDispatcher("/item/itemmanager.jsp").forward(request, response);
				break;

			case "PREUPDATE":
				dto = service.read(id);;
				request.setAttribute("dto", dto);
				getServletContext().getRequestDispatcher("/item/updateitem.jsp").forward(request, response);
				break;

			case "UPDATE":
				description = request.getParameter("description");
				itemType= request.getParameter("itemType");
				ambientId = Integer.parseInt(request.getParameter("ambientId"));
				int idToUpdate = Integer.parseInt(request.getParameter("idToUpdate"));
				dto = new ItemDTO(idToUpdate,description, itemType, ambientId);
				ans = service.update(dto);
				request.setAttribute("ans", ans);
				System.out.println(ans);
				updateList(request);
				getServletContext().getRequestDispatcher("/item/itemmanager.jsp").forward(request, response);
				break;

			case "DELETE":
				dto = service.read(id);
				ans = service.delete(dto);
				request.setAttribute("ans", ans);
				updateList(request);
				getServletContext().getRequestDispatcher("/item/itemmanager.jsp").forward(request, response);
				break;
			}
		}
}

