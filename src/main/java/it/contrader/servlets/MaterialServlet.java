package it.contrader.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.contrader.dto.MaterialDTO;
import it.contrader.dto.HumanResourceDTO;
import it.contrader.dto.UsersDTO;

import it.contrader.service.MaterialServiceDTO;
import it.contrader.service.HumanResourceServiceDTO;

public class MaterialServlet extends HttpServlet{
	private MaterialServiceDTO materialServiceDTO = new MaterialServiceDTO();
	//private HumanResourceServiceDTO hrServiceDTO = new HumanResourceServiceDTO();
	private List<MaterialDTO> allMaterials = new ArrayList<MaterialDTO>();
	private List<MaterialDTO> filteredMaterials = new ArrayList<MaterialDTO>();
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String scelta = request.getParameter("richiesta");
		//final HttpSession session = request.getSession(true);
		
		int idmaterial;
		String tipo;
		int quantita;
		int idhr;
		HumanResourceDTO hrDTO;
		
		// Here I don't know if userLogged is the general user that login in the app
		// or is only the user of the entity.
		//final UsersDTO userLogged = (UsersDTO) session.getAttribute("utente");
		
		switch (scelta) {
			case "HR_manager":
				showAllMaterials(request, response);
				break;
				
			case "insertRedirect":
				response.sendRedirect("material/insertTask.jsp");
				break;

		case "insert":
			tipo = request.getParameter("tipo");
			quantita = Integer.parseInt(request.getParameter("quantita"));
			idhr = Integer.parseInt(request.getParameter("idHR"));
			
			hrDTO = new HumanResourceDTO(null, null, null);
			hrDTO.setId(idhr);
			
			final MaterialDTO materialInsert = new MaterialDTO(tipo, quantita, hrDTO);
			materialServiceDTO.insertMaterial(materialInsert);
			showAllMaterials(request, response);
			break;

		case "updateRedirect":
			idmaterial = Integer.parseInt(request.getParameter("idmaterial"));
			
			MaterialDTO materialUpdate = new MaterialDTO("", 0, null);
			materialUpdate.setIdmaterial(idmaterial);

			materialUpdate = this.materialServiceDTO.readMaterial(materialUpdate);
			request.setAttribute("materialUpdate", materialUpdate);
			getServletContext().getRequestDispatcher("/material/updateMaterial.jsp").forward(request, response);

			break;

		case "update":
			idmaterial = Integer.parseInt(request.getParameter("idmaterial"));
			tipo = request.getParameter("tipo");
			quantita = Integer.parseInt(request.getParameter("quantita"));
			idhr = Integer.parseInt(request.getParameter("idHR"));
			
			hrDTO = new HumanResourceDTO(null, null, null);
			hrDTO.setId(idhr);
			
			final MaterialDTO materialDTO = new MaterialDTO(tipo, quantita, null);
			materialDTO.setIdmaterial(idmaterial);
			materialServiceDTO.updateMaterial(materialDTO);
			showAllMaterials(request, response);
			break;

		case "delete":
			final Integer materialIdDelete = Integer.parseInt(request.getParameter("idmaterial"));

			final MaterialDTO materialdelete = new MaterialDTO("", 0, null);
			materialdelete.setIdmaterial(materialIdDelete);
			materialServiceDTO.deleteMaterial(materialdelete);
			showAllMaterials(request, response);
			break;

		case "indietro":
			response.sendRedirect("homeBO.jsp");
			break;

		case "logsMenu":
			response.sendRedirect("index.jsp");
			break;

		}
	}
	
	// Show all material for user logged.. (
	// I think that here all materials must be showed from the actual HR...
	private void showAllMaterials(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		allMaterials.clear();
		filteredMaterials.clear();
		allMaterials = this.materialServiceDTO.getAllMaterial();
		//HttpSession session = request.getSession(true);
		
		HumanResourceDTO hrDTO = new HumanResourceDTO(null, null, null);
		int idhr = Integer.parseInt(request.getParameter("idHR"));
		hrDTO.setId(idhr);
		
		for (MaterialDTO materialDTO : allMaterials) {
			if (materialDTO.getHRDTO().getId() == hrDTO.getId())
				filteredMaterials.add(materialDTO);
		}
				
		request.setAttribute("allMaterial", filteredMaterials);
		getServletContext().getRequestDispatcher("/material/manageMaterial.jsp").forward(request, response);
	}
}
