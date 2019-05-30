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
	private HumanResourceServiceDTO hrServiceDTO = new HumanResourceServiceDTO();
	private List<MaterialDTO> allMaterials = new ArrayList<MaterialDTO>();
	private List<MaterialDTO> filteredMaterialss = new ArrayList<MaterialDTO>();
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String scelta = request.getParameter("richiesta");
		final HttpSession session = request.getSession(true);
		
		// Here I don't know if userLogged is the general user that login in the app
		// or is only the user of the entity.
		final UsersDTO userLogged = (UsersDTO) session.getAttribute("utente");
		
		switch (scelta) {
			case "MaterialManager":
				showAllMaterials(request, response);
				break;
				
			case "insertRedirect":
				response.sendRedirect("material/insertClient.jsp");
				break;

		case "insert":
			final int idmaterial = Integer.parseInt(request.getParameter("idmaterial"));
			final String tipo = request.getParameter("tipo");
			final int quantita = Integer.parseInt(request.getParameter("quantita"));
			final int idhr = Integer.parseInt(request.getParameter("idHR"));
			
			HumanResourceDTO hrDTO = new HumanResourceDTO(null, null, null);
			hrDTO.setId(idhr);
			
			final MaterialDTO materialInsert = new MaterialDTO(tipo, quantita, hrDTO);
			materialServiceDTO.insertMaterial(materialInsert);
			showAllMaterials(request, response);
			break;

		case "updateRedirect":
			int idmaterial = Integer.parseInt(request.getParameter("id"));
			MaterialDTO materialUpdate = new MaterialDTO(new UserDTO("", "", ""), "");
			materialUpdate.setIdmaterial(idmaterial)

			materialUpdate = this.materialServiceDTO.readMaterial(materialUpdate);
			request.setAttribute("clientUpdate", materialUpdate);
			getServletContext().getRequestDispatcher("/material/updateMaterial.jsp").forward(request, response);

			break;

		case "update":
			final Integer idmaterial = Integer.parseInt(request.getParameter("idmaterial"));
			final String tipo = request.getParameter("tipo");
			final int quantita = Integer.parseInt(request.getParameter("quantita"));

			final MaterialDTO materialtDTO = new MaterialDTO(tipo, quantita, 0);
			materialtDTO.setIdmaterial(idmaterial);
			clientServiceDTO.updateClient(clientDTO);
			showAllClient(request, response);
			break;

		case "delete":
			final Integer materialIdDelete = Integer.parseInt(request.getParameter("idmaterial"));

			final MaterialDTO materialdelete = new MaterialDTO(userLogged, "");
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
	
	// Show all material for user logged
	private void showAllMaterials(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		allClients.clear();
		filteredClients.clear();
		allClients = this.clientServiceDTO.getAllClient();
		HttpSession session = request.getSession(true);
		UserDTO userLogged=(UserDTO) session.getAttribute("utente");
			
		for (ClientDTO clientDTO:allClients) {
			if (clientDTO.getUserDTO().getId()==userLogged.getId())
				filteredClients.add(clientDTO);
		}
				
		request.setAttribute("allClient", filteredClients);
		getServletContext().getRequestDispatcher("/client/manageClient.jsp").forward(request, response);
	}
}
