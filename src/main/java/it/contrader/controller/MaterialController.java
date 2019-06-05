package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.dto.MaterialDTO;
import it.contrader.dto.UserDTO;
import it.contrader.services.MaterialService;

import java.util.List;

@Controller
@RequestMapping("/Material")
public class MaterialController {

	private final MaterialService materialService;
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	public MaterialController(MaterialService materialService) {
		this.materialService = materialService;
	}

	private void visualMaterial(HttpServletRequest request) {
		UserDTO userDTO = (UserDTO) this.session.getAttribute("utente");
		List<MaterialDTO> allMaterial = this.materialService.findMaterialDTOByUser(userDTO);
		request.setAttribute("allMaterialDTO", allMaterial);
	}

	@RequestMapping(value = "/materialManagement", method = RequestMethod.GET)
	public String materialManagement(HttpServletRequest request) {
		visualMaterial(request);
		return "material/manageMaterial";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("id", id);
		this.materialService.deletematerialByIdmaterial(id);
		visualMaterial(request);
		return "material/manageMaterial";

	}

	@RequestMapping(value = "/insertRedirect", method = RequestMethod.GET)
	public String insertRedirect(HttpServletRequest request) {
		return "material/insertMaterial";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(HttpServletRequest request,HttpSession session) {
		UserDTO userLogged = (UserDTO) session.getAttribute("utente");
		
		String materialName = request.getParameter("material").toString();
		int quantita = Integer.parseInt(request.getParameter("quantita"));
		

		MaterialDTO materialObj = new MaterialDTO();
		materialObj.setMaterial(materialName);
		materialObj.setQuantita(quantita);
		materialObj.setUserDTO(userLogged);
		materialService.insertMaterial(materialObj);
		visualMaterial(request);
		 

		return "material/manageMaterial";
	}
	@RequestMapping(value = "/updateRedirect", method = RequestMethod.GET)
	public String updateRedirect(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		MaterialDTO materialUpdate = new MaterialDTO();

		materialUpdate = this.materialService.getMaterialDTOByIdmaterial(id);
		request.setAttribute("materialUpdate", materialUpdate);
		return "material/updateMaterial";
	}		
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(HttpServletRequest request, HttpSession session) {
		
		Integer idUpdate = Integer.parseInt(request.getParameter("idMaterial"));
		UserDTO userLogged = (UserDTO) session.getAttribute("utente");
		String materialName = request.getParameter("material");
		int quantita = Integer.parseInt(request.getParameter("quantita"));
		
		MaterialDTO materialUpdateDTO = new MaterialDTO();
		materialUpdateDTO.setMaterial(materialName);
		materialUpdateDTO.setQuantita(quantita);
		materialUpdateDTO.setUserDTO(userLogged);
		materialUpdateDTO.setIdmaterial(idUpdate);
		
		materialService.updateMaterial(materialUpdateDTO);
		visualMaterial(request);
		
		return "material/manageMaterial";
	}
	
}
