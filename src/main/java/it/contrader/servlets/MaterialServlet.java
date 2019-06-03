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


public class MaterialServlet extends HttpServlet{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MaterialServiceDTO materialServiceDTO = new MaterialServiceDTO();
	//private HumanResourceServiceDTO hrServiceDTO = new HumanResourceServiceDTO();
	private List<MaterialDTO> allMaterials = new ArrayList<>();
	private List<MaterialDTO> filteredMaterials = new ArrayList<>();
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		final String scelta = request.getParameter("richiesta");
		final HttpSession session = request.getSession(true);
		final HumanResourceDTO hrLogged = (HumanResourceDTO) session.getAttribute("hr");
		//final HttpSession session = request.getSession(true);
		// Here I don't know if userLogged is the general user that login in the app
		// or is only the user of the entity.
		final UsersDTO userLogged = (UsersDTO) session.getAttribute("utente");
		
		switch (scelta) {
			case "human_manager":
				showAllMaterials(request, response);
				break;
				
			case "insertRedirect":
				response.sendRedirect("material/insertMaterial.jsp");
				break;

		case "insert":
			
			final String tipo = request.getParameter("tipo");
			final Integer quantita = Integer.parseInt(request.getParameter("quantita"));
			
			final MaterialDTO materialInsert = new MaterialDTO(tipo,quantita,hrLogged);
			materialServiceDTO.insertMaterial(materialInsert);
			showAllMaterials(request, response);
			break;

		case "updateRedirect":
			
			int idmaterial = Integer.parseInt(request.getParameter("idmaterial"));
			
			MaterialDTO materialUpdate = new MaterialDTO("", 0,null);
			materialUpdate.setIdmaterial(idmaterial);

			materialUpdate = this.materialServiceDTO.readMaterial(materialUpdate);
			request.setAttribute("materialUpdate", materialUpdate);
			getServletContext().getRequestDispatcher("/material/updateMaterial.jsp").forward(request, response);

			break;

		case "update":
			
			final Integer materialIdUpdate = Integer.parseInt(request.getParameter("idmaterial"));
			// final Integer userIdUpdate =
			// Integer.parseInt(request.getParameter("user_id"));
			final String materialTipoUpdate = request.getParameter("tipo");
			final Integer materialQuantitaUpdate = Integer.parseInt(request.getParameter("quantita"));

			final MaterialDTO materialDTO = new MaterialDTO(materialTipoUpdate,materialQuantitaUpdate,hrLogged);
			materialDTO.setIdmaterial(materialIdUpdate);
			materialServiceDTO.updateMaterial(materialDTO);
			showAllMaterials(request, response);
			break;

		case "delete":
			
			final int materialIdDelete = Integer.parseInt(request.getParameter("idmaterial"));
			final MaterialDTO materialdelete = new MaterialDTO("",0, hrLogged);
			materialdelete.setIdmaterial(materialIdDelete);
			materialServiceDTO.deleteMaterial(materialdelete);
			showAllMaterials(request, response);
			break;

		case "indietro":
			response.sendRedirect("homeHumanResource.jsp");
			break;

		case "logsMenu":
			response.sendRedirect("index.jsp");
			break;

		}
	}
	
	
	// I think that here all materials must be showed from the actual HR...
	private void showAllMaterials(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		allMaterials.clear();
		filteredMaterials.clear();
		allMaterials = this.materialServiceDTO.getAllMaterial();
		HttpSession session = request.getSession(true);
		HumanResourceDTO hrLogged=(HumanResourceDTO) session.getAttribute("hr");
		
	
		
		for (MaterialDTO materialDTO : allMaterials) {
			if (materialDTO.getHRDTO().getId() == hrLogged.getId())
				filteredMaterials.add(materialDTO);
		}
				
		request.setAttribute("allMaterial", filteredMaterials);
		getServletContext().getRequestDispatcher("/material/manageMaterial.jsp").forward(request, response);
	}
}
