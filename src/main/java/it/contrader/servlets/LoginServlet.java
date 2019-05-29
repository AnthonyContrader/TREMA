package it.contrader.servlets;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import it.contrader.dto.UsersDTO;
import it.contrader.service.ServiceDTO;
import it.contrader.service.UsersServiceDTO;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final HttpSession session = request.getSession();
		session.setAttribute("utente", null);

		ServiceDTO<UsersDTO> service = new UsersServiceDTO();

		if (request != null) {
			String username = request.getParameter("username").toString();
			String password = request.getParameter("password").toString();
			UsersDTO dto = service.read(username, password);
			if (dto != null)
				session.setAttribute("users", dto);
			else
				getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);

			switch (dto.getUsertype().toUpperCase()) {
			case "ADMIN":
				getServletContext().getRequestDispatcher("/homeadmin.jsp").forward(request, response);
				break;
			case "HR_MANAGER":
				getServletContext().getRequestDispatcher("/homeHR.jsp").forward(request, response);
				break;
			case "PJ_MANAGER":
				getServletContext().getRequestDispatcher("/homePJ.jsp").forward(request, response);
				break;
			default:
				getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
				break;
			}
		}
	}
}
