package it.contrader.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.contrader.converter.MaterialConverter;
import it.contrader.dto.MaterialDTO;
import it.contrader.service.MaterialServiceDTO;

public class MaterialServlet extends HttpServlet {

	private final MaterialServiceDTO materialServiceDTO = new MaterialServiceDTO();
	private List<MaterialDTO> allMaterial = new ArrayList<>();

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		final String scelta = request.getParameter("richiesta");
		final HttpSession session = request.getSession(true);     //errore

		switch (scelta) {

		case "MaterialManager":
			allMaterial = this.materialServiceDTO.getAllMaterial();
			request.setAttribute("allMaterial", allMaterial);
			getServletContext().getRequestDispatcher("/material.jsp").forward(request, response);
			break;			

		case "insert":
			final int idmaterial = Integer.parseInt(request.getParameter("idmaterial"));
			final String tipo = request.getParameter("tipo");
			final int quantita = Integer.parseInt(request.getParameter("quantita"));
			final int idHR = Integer.parseInt(request.getParameter("idHR"));
			MaterialDTO material = new MaterialDTO(idmaterial, tipo, quantita, idHR);
			materialServiceDTO.insertMaterial(material);
			showAllMaterial(request, response);
			break;
					
		case "update":
			System.out.println("idmaterial: "+Integer.parseInt(request.getParameter("idmaterial")));
			System.out.println("tipo: "+request.getParameter("tipo"));
			System.out.println("quantita: "+request.getParameter("quantita"));
			System.out.println("idHR: "+request.getParameter("idHR"));

		    final int idmaterialUpdate = Integer.parseInt(request.getParameter("idmaterial"));
			final String tipoUpdate = request.getParameter("tipo");
			final int quantitaUpdate = Integer.parseInt(request.getParameter("quantita"));
			final int idHRUpdate = Integer.parseInt (request.getParameter("idHR"));
			final MaterialDTO Material = new MaterialDTO(idmaterialUpdate, tipoUpdate, quantitaUpdate, idHRUpdate);
					
			materialServiceDTO.updateMaterial(Material);
			showAllMaterial(request, response);
			break;

		case "delete":
			final int idmaterialUpdat = Integer.parseInt(request.getParameter("idmaterial"));  // errore
			
			final MaterialDTO use = new MaterialDTO();  // possibile passsaggio di parametri
			materialServiceDTO.deleteMaterial(use);
			showAllMaterial(request, response);
			break;

		case "Indietro":
			response.sendRedirect("home.jsp");
			break;

		case "LogsMenu":
			response.sendRedirect("homeLogs.jsp");
			break;

	}

}

private void showAllMaterial (HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		allMaterial = this.materialServiceDTO.getAllMaterial();
		request.setAttribute("allMaterial", allMaterial);
		getServletContext().getRequestDispatcher("/material.jsp").forward(request, response);
	}
}
