package it.contrader.servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import it.contrader.dto.ProjectDTO;
import it.contrader.service.ProjectServiceDTO;
import it.contrader.service.ServiceDTO;

public class ProjectServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private HttpSession session;
	private int iduser;
	
	public ProjectServlet() {
	}
	
	public void updateList(HttpServletRequest request) {
		session.getAttribute("iduser" );
		ServiceDTO<ProjectDTO> service = new ProjectServiceDTO();
		List<ProjectDTO> listDTO = service.getAllBy(iduser);
		request.setAttribute("list", listDTO);
	}
	
	@Override
	public void service (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServiceDTO<ProjectDTO> service = new ProjectServiceDTO();
	    

		if(request.getParameter("iduser")!=null) {
			iduser = Integer.parseInt(request.getParameter("iduser"));
	    }
		
		ProjectDTO dto;
		boolean ans;
		int idproject;
		String name, description, projectType;
		
		
	    String mode = request.getParameter("mode");
		
		session = request.getSession();
		session.setAttribute("iduser",iduser);
		
		switch (mode.toUpperCase()) {

		case "PROJECTLISTBY":
			updateList(request);
			getServletContext().getRequestDispatcher("/project/projectmanager.jsp").forward(request, response);
			break;

		case "PROJECTLISTOP":
			updateList(request);
			getServletContext().getRequestDispatcher("/homeoperatore.jsp").forward(request, response);
			break;

		case "READ":
			
			idproject = Integer.parseInt(request.getParameter("idproject"));
			
			ServiceDTO<ProjectDTO> projectservice = new ProjectServiceDTO();
			List<ProjectDTO>listDTO = projectservice.getAllBy(idproject);
			request.setAttribute("list", listDTO);
			
			session.setAttribute("projectId",idproject);
			
			dto = service.read(idproject);
			request.setAttribute("dto", dto);
			getServletContext().getRequestDispatcher("/project/readproject.jsp").forward(request, response);
			break;

		case "INSERT":
			name= request.getParameter("name");
			description= request.getParameter("descrizione");
			projectType= request.getParameter("tipo");
			int iduser = Integer.parseInt(request.getParameter("iduser"));
			dto = new ProjectDTO (name, description, projectType, iduser);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/project/projectmanager.jsp").forward(request, response);
			break;

		case "PREUPDATE":
			idproject = Integer.parseInt(request.getParameter("idproject"));
			dto = service.read(idproject);
			dto.setIdproject(idproject);
			request.setAttribute("dto", dto);
			getServletContext().getRequestDispatcher("/project/updateproject.jsp").forward(request, response);
			break;

		case "UPDATE":
			name = request.getParameter("name");
			description = request.getParameter("descrizione");
			projectType= request.getParameter("tipo");
			iduser = Integer.parseInt(request.getParameter("iduser"));
			int idToUpdate = Integer.parseInt(request.getParameter("idToUpdate"));
			dto = new ProjectDTO(idToUpdate,name ,description, projectType, iduser);
			ans = service.update(dto);
			request.setAttribute("ans", ans);
			System.out.println(ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/project/projectmanager.jsp").forward(request, response);
			break;

		case "DELETE":
			idproject = Integer.parseInt(request.getParameter("idproject"));
			dto = service.read(idproject);
			ans = service.delete(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/project/projectmanager.jsp").forward(request, response);
			break;
		}
	}


}
