package it.contrader.servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.contrader.dto.MaterialDTO;
import it.contrader.dto.MaterialDTO;
import it.contrader.service.MaterialServiceDTO;
import it.contrader.service.MaterialServiceDTO;
import it.contrader.service.ServiceDTO;

public class MaterialServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private int idHR;
	private HttpSession session;
	private int idmaterial;
	public MaterialServlet() {
	}
	
	public void updateList(HttpServletRequest request) {
		session.getAttribute("idmaterial" );
		ServiceDTO<MaterialDTO> service = new MaterialServiceDTO();
		List<MaterialDTO> listDTO = service.getAllBy(idmaterial);
		request.setAttribute("list", listDTO);
	}
	
	@Override
	public void service (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServiceDTO<MaterialDTO> service = new MaterialServiceDTO();
	    
	    if(request.getParameter("idHR")!=null) {
	    	idHR = Integer.parseInt(request.getParameter("idHR").toString());
	    }

		if(request.getParameter("idmaterial")!=null) {
			idmaterial = Integer.parseInt(request.getParameter("idmaterial"));
	    }
		
		MaterialDTO dto;
		boolean ans;
		String tipo;
		int quantita;
		
		
	    String mode = request.getParameter("mode");
		
		session = request.getSession();
		session.setAttribute("idHR",idHR);
		
		switch (mode.toUpperCase()) {

		case "ITEMLISTBY":
			updateList(request);
			getServletContext().getRequestDispatcher("/material/material.jsp").forward(request, response);  //materialmanager or material?
			break;

		case "ITEMLISTOP":   //maybe should be removed
			updateList(request);
			getServletContext().getRequestDispatcher("/idHR.jsp").forward(request, response);
			break;

		case "READ":
			dto = service.read(idmaterial);
			request.setAttribute("dto", dto);
			getServletContext().getRequestDispatcher("/material/readmaterial.jsp").forward(request, response);
			break;

		case "INSERT":
			tipo= request.getParameter("tipo");
			quantita= Integer.parseInt(request.getParameter("quantita"));
			int idHR = Integer.parseInt(request.getParameter("idHR"));
			dto = new MaterialDTO (tipo, quantita, idHR);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/material/materialmanager.jsp").forward(request, response);  //materialmanager or material?
			break;

		case "PREUPDATE":
			dto = service.read(idmaterial);;
			request.setAttribute("dto", dto);
			getServletContext().getRequestDispatcher("/material/updatematerial.jsp").forward(request, response);
			break;

		case "UPDATE":
			tipo =request.getParameter("tipo");
			quantita= Integer.parseInt(request.getParameter("quantita"));
			idHR = Integer.parseInt(request.getParameter("idHR"));
			int idmaterialToUpdate = Integer.parseInt(request.getParameter("idmaterialToUpdate"));
			dto = new MaterialDTO(idmaterialToUpdate, tipo, quantita, idHR);
			ans = service.update(dto);
			request.setAttribute("ans", ans);
			System.out.println(ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/material/materialmanager.jsp").forward(request, response);	//materialmanager or material?
			break;

		case "DELETE":
			dto = service.read(idmaterial);
			ans = service.delete(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/material/materialmanager.jsp").forward(request, response);
			break;
		}
	}


}
