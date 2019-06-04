package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.dto.MaterialDTO;
import it.contrader.dto.OrderDTO;  //should be removed
import it.contrader.dto.TaskDTO;
import it.contrader.service.MaterialService;

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
		MaterialDTO materialDTO = (MaterialDTO) this.session.getAttribute("material");
		List<MaterialDTO> allMaterial = this.materialService.findMaterialDTOByidTask(TaskDTO);
		request.setAttribute("allMaterialDTO", allMaterial);
	}

	@RequestMapping(value = "/materialManagement", method = RequestMethod.GET)
	public String materialManagement(HttpServletRequest request) {
		visualMaterial(request);
		return "material/manageMaterial";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		int idmaterial = Integer.parseInt(request.getParameter("idmaterial"));
		request.setAttribute("idmaterial", idmaterial);
		this.materialService.deleteMaterialByIdmaterial(idmaterial);
		visualMaterial(request);
		return "material/manageMaterial";

	}

	@RequestMapping(value = "/insertRedirect", method = RequestMethod.GET)
	public String insertRedirect(HttpServletRequest request) {
		return "material/insertMaterial";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(HttpServletRequest request,HttpSession session) {
		MaterialDTO materialLogged = (MaterialDTO) session.getAttribute("material");
		
		String materialName = request.getParameter("material").toString();
		

		MaterialDTO materialObj = new MaterialDTO();
		materialObj.setMaterialName(materialName);
		materialObj.setMaterialDTO(materialLogged);
		materialService.insertMaterial(materialObj);
		visualMaterial(request);
		 

		return "material/manageMaterial";
	}
	@RequestMapping(value = "/updateRedirect", method = RequestMethod.GET)
	public String updateRedirect(HttpServletRequest request) {
		int idmaterial = Integer.parseInt(request.getParameter("idmaterial"));
		MaterialDTO materialUpdate = new MaterialDTO();

		materialUpdate = this.materialService.getMaterialDTOByIdmaterial(idmaterial);
		request.setAttribute("materialUpdate", materialUpdate);
		return "material/updateMaterial";
	}		
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(HttpServletRequest request, HttpSession session) {
		
		Integer idmaterialUpdate = Integer.parseInt(request.getParameter("idmaterial"));
		MaterialDTO materialLogged = (MaterialDTO) session.getAttribute("material");
		String materialName = request.getParameter("material");
		
		MaterialDTO materialUpdateDTO = new MaterialDTO();
		materialUpdateDTO.setMaterialName(material);
		materialUpdateDTO.setMaterialDTO(materialLogged);
		materialUpdateDTO.setMaterialId(idmaterialUpdate);
		
		materialService.updateMaterial(materialUpdateDTO);
		visualMaterial(request);
		
		return "material/manageMaterial";
	}
	
}
