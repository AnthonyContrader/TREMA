package it.contrader.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;
import it.contrader.dto.UsersDTO;
import it.contrader.service.ServiceDTO;
import it.contrader.service.UsersServiceDTO;

public class UsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UsersServlet() {}
	
	public void updateList(HttpServletRequest request) {
		ServiceDTO<UsersDTO> service = new UsersServiceDTO();
		List<UsersDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServiceDTO<UsersDTO> service = new UsersServiceDTO();
		String mode = request.getParameter("mode");
		UsersDTO dto;
		int id;
		boolean ans;

		switch (mode.toUpperCase()) {

		case "USERLIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/user/usermanager.jsp").forward(request, response);
			break;

		case "READ":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			request.setAttribute("dto", dto);
			getServletContext().getRequestDispatcher("/user/readuser.jsp").forward(request, response);
			break;

		case "INSERT":
			String username = request.getParameter("username").toString();
			String password = request.getParameter("password").toString();
			String usertype = request.getParameter("usertype").toString();
			dto = new UsersDTO (username,password,usertype);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/user/usermanager.jsp").forward(request, response);
			break;

		case "READTOUPDATE":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			request.setAttribute("dto", dto);
			getServletContext().getRequestDispatcher("/user/updateuser.jsp").forward(request, response);
			break;
			
		case "UPDATE":
			username = request.getParameter("username");
			password = request.getParameter("password");
			usertype = request.getParameter("usertype");
			id = Integer.parseInt(request.getParameter("id"));
			dto = new UsersDTO (id,username, password, usertype);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/user/usermanager.jsp").forward(request, response);
			break;

		case "DELETE":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			ans = service.delete(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/user/usermanager.jsp").forward(request, response);
			break;
		}
	}
}
