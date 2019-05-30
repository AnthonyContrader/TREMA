package it.contrader.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.contrader.converter.*;
import it.contrader.dto.*;
import it.contrader.service.*;

/**
 * La servlet si occupa di parlare con la JSP e utilizza i servizi opportuni.
 * Per chi far� User dovr� anche occuparsi del Login che abbiamo lasciato come
 * struttura e va modificata in modo opportuno
 *
 */
public class UsersServlet extends HttpServlet {

	private final UsersServiceDTO userServiceDTO = new UsersServiceDTO();
	private List<UsersDTO> allUsers = new ArrayList<>();

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		final String scelta = request.getParameter("richiesta");
		final HttpSession session = request.getSession(true);

		switch (scelta) {

		case "admin":
			allUsers = this.userServiceDTO.getAllUsers();
			request.setAttribute("allUser", allUsers);
			getServletContext().getRequestDispatcher("/user/manageUser.jsp").forward(request, response);
			break;

		case "insertRedirect":
			response.sendRedirect("user/insertUser.jsp");
			break;

		case "insert":
			// final Integer id = Integer.parseInt(request.getParameter("user_id"));
			final String username = request.getParameter("username");
			final String password = request.getParameter("password");
			final String usertype = request.getParameter("usertype");
			final UsersDTO users = new UsersDTO(username, password, usertype);
			userServiceDTO.insertUsers(users);
			showAllUsers(request, response);
			break;

		case "updateRedirect":
			int id = Integer.parseInt(request.getParameter("iduser"));
			UsersDTO userUpdate = new UsersDTO("", "", "");
			userUpdate.setId(id);

			userUpdate = this.userServiceDTO.readUser(userUpdate);
			request.setAttribute("userUpdate", userUpdate);
			getServletContext().getRequestDispatcher("/user/updateUser.jsp").forward(request, response);

			break;

		case "update":
			//System.out.println("ID: " + Integer.parseInt(request.getParameter("user_id")));
			//System.out.println("username: " + request.getParameter("user_user"));
			//System.out.println("password: " + request.getParameter("user_pass"));
			//System.out.println("Tipo utente: " + request.getParameter("user_type"));

			final Integer idUpdate = Integer.parseInt(request.getParameter("iduser"));
			final String usernameUpdate = request.getParameter("username");
			final String passwordUpdate = request.getParameter("password");
			final String usertypeUpdate = request.getParameter("usertype");
			final UsersDTO user = new UsersDTO(usernameUpdate, passwordUpdate, usertypeUpdate);
			user.setId(idUpdate);

			userServiceDTO.updateUser(user);
			showAllUsers(request, response);
			break;

		case "delete":
			final Integer deleteId = Integer.parseInt(request.getParameter("id"));

			final UsersDTO userdelete = new UsersDTO("", "", "");
			userdelete.setId(deleteId);
			userServiceDTO.deleteUsers(userdelete);
			showAllUsers(request, response);
			break;

		case "indietro":
			response.sendRedirect("homeAdmin.jsp");
			break;

		case "logsMenu":
			response.sendRedirect("index.jsp");
			break;

		}

	}

	private void showAllUsers(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		allUsers = this.userServiceDTO.getAllUsers();
		request.setAttribute("allUser", allUsers);
		getServletContext().getRequestDispatcher("/user/manageUser.jsp").forward(request, response);
	}
}
