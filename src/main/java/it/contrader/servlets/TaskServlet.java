package it.contrader.servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.contrader.dto.TaskDTO;
import it.contrader.service.TaskServiceDTO;
import it.contrader.service.ServiceDTO;

public class TaskServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private int idtask;
	private String descrizione;
	private int idproject;
	private int idHR;
	private HttpSession session;
	
	public TaskServlet() {
		
	}
	
	public void updateList(HttpServletRequest request) {
		session.getAttribute("idproject" );
		ServiceDTO<TaskDTO> service = new TaskServiceDTO();
		List<TaskDTO>listDTO = service.getAllBy(idproject);
		request.setAttribute("list", listDTO);
	}
	
	@Override
	public void service (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TaskDTO dto;
		boolean ans;
		
		ServiceDTO<TaskDTO> service = new TaskServiceDTO();
	    String mode = request.getParameter("mode");
	    
	    if(request.getParameter("idproject")!=null)
	    	idproject = Integer.parseInt(request.getParameter("idproject").toString());
	    
		session = request.getSession();
		session.setAttribute("idproject", idproject);
		
		switch (mode.toUpperCase()) {

		case "TASKLISTBY":
			updateList(request);
			getServletContext().getRequestDispatcher("/task/taskmanager.jsp").forward(request, response);
			break;
			
		case "BUILDINGLISTOP":
			updateList(request);
			getServletContext().getRequestDispatcher("/homeoperatore.jsp").forward(request, response);
			break;

		case "READ":
			idproject = Integer.parseInt(request.getParameter("idproject"));
				
			ServiceDTO<TaskDTO> itemservice = new TaskServiceDTO();
			List<TaskDTO>listDTO = itemservice.getAllBy(idproject);
			request.setAttribute("list", listDTO);
			
			session.setAttribute("idproject", idproject);
			
			dto = service.read(idproject);
			request.setAttribute("dto", dto);
			getServletContext().getRequestDispatcher("/task/readtask.jsp").forward(request, response);
			break;

		case "INSERT":
			descrizione= request.getParameter("descrizione_task");
			idproject = Integer.parseInt(request.getParameter("idproject"));
			idHR = Integer.parseInt(request.getParameter("idHR"));
			
			dto = new TaskDTO (descrizione, idproject, idHR);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/task/taskmanager.jsp").forward(request, response);
			break;

		case "PREUPDATE":
			idtask = Integer.parseInt(request.getParameter("idtask"));
			dto = service.read(idtask);
			dto.setIdtask(idtask);
			request.setAttribute("dto", dto);
			getServletContext().getRequestDispatcher("/task/updatetask.jsp").forward(request, response);
			break;

		case "UPDATE":
			descrizione= request.getParameter("descrizione_task");
			idproject = Integer.parseInt(request.getParameter("idproject"));
			idHR = Integer.parseInt(request.getParameter("idHR"));
			
			dto = new TaskDTO (descrizione, idproject, idHR);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/task/taskmanager.jsp").forward(request, response);
			break;

		case "DELETE":
			idtask = Integer.parseInt(request.getParameter("idtask"));
			dto = service.read(idtask);
			ans = service.delete(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/task/taskmanager.jsp").forward(request, response);
			break;
		}
	}
}
