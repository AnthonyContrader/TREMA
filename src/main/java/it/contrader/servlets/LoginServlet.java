package it.contrader.servlets;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import it.contrader.dto.UsersDTO;
import it.contrader.service.UsersServiceDTO;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private final UsersServiceDTO usersServiceDTO = new UsersServiceDTO();

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		final HttpSession session = request.getSession();
		session.setAttribute("utente", null);

		if (request != null) {
			final String username = request.getParameter("username").toString().trim();
			final String password = request.getParameter("password").toString().trim();
			final UsersDTO userDTO = usersServiceDTO.getUserByUsernameAndPassword(username, password);

			if (userDTO != null)
				session.setAttribute("utente", userDTO);
			
			switch (userDTO.getUsertype()) {
			case "admin":
				getServletContext().getRequestDispatcher("/homeAdmin.jsp").forward(request, response);
				break;
			case "HR_manager":
				getServletContext().getRequestDispatcher("/homeAdmin.jsp").forward(request, response);
				break;
			case "project_manager":
				getServletContext().getRequestDispatcher("/homeAdmin.jsp").forward(request, response);
				break;
			default:
				getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
				break;
			}
		}
	}

}
