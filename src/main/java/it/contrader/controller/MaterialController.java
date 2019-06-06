package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.dto.TaskDTO;
import it.contrader.services.TaskService;

import it.contrader.dto.MaterialDTO;
import it.contrader.services.MaterialService;

import java.util.List;

@Controller
@RequestMapping("/Material")
public class MaterialController {
	private final TaskService taskService;
	private final MaterialService materialService;
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	public MaterialController(MaterialService materialService, TaskService taskservice) {
		this.materialService = materialService;
		this.taskService = taskservice;
	}

	private void visualMaterial(HttpServletRequest request) {
		int idtask = Integer.parseInt(request.getParameter("id_task"));
		TaskDTO taskDTO = new TaskDTO();
		taskDTO.setIdTask(idtask);
		
		List<MaterialDTO> allMaterial = this.materialService.getListaMaterialDTOByTask(taskDTO);
		request.setAttribute("allMaterialDTO", allMaterial);
	}

	@RequestMapping(value = "/materialManagement", method = RequestMethod.GET)
	public String materialManagement(HttpServletRequest request) {
		visualMaterial(request);
		return "material/manageMaterial";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		int idmaterial = Integer.parseInt(request.getParameter("id_material"));
		request.setAttribute("id_material", idmaterial);
		this.materialService.deletematerialByIdmaterial(idmaterial);
		visualMaterial(request);
		return "material/manageMaterial";
	}

	@RequestMapping(value = "/insertRedirect", method = RequestMethod.GET)
	public String insertRedirect(HttpServletRequest request) {
		return "material/insertMaterial";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(HttpServletRequest request,HttpSession session) {
		TaskDTO taskInsertDTO = new TaskDTO();
		
		String materialInsert = request.getParameter("material");
		int quantitaInsert = Integer.parseInt(request.getParameter("quantita"));
		Integer idtaskInsert = Integer.parseInt(request.getParameter("id_task"));
		taskInsertDTO.setIdTask(idtaskInsert);
		
		MaterialDTO materialDTO = new MaterialDTO();
		materialDTO.setMaterial(materialInsert);
		materialDTO.setQuantita(quantitaInsert);
		materialDTO.setTaskDTO(taskInsertDTO);
		
		materialService.insertMaterial(materialDTO);
		
		visualMaterial(request);
		return "material/manageMaterial";
	}
	@RequestMapping(value = "/updateRedirect", method = RequestMethod.GET)
	public String updateRedirect(HttpServletRequest request) {
		List<TaskDTO> taskList = taskService.getListaTaskDTO();
		
		MaterialDTO materialUpdate = new MaterialDTO();
		int idmaterial = Integer.parseInt(request.getParameter("id_material"));
		materialUpdate = this.materialService.getMaterialDTOByIdmaterial(idmaterial);
		request.setAttribute("materialUpdate", materialUpdate);
		request.setAttribute("taskList", taskList);
		return "material/updateMaterial";
	}		
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(HttpServletRequest request, HttpSession session) {
		Integer idmaterialUpdate = Integer.parseInt(request.getParameter("id_material"));
		String materialUpdate = request.getParameter("material");
		int quantitaUpdate = Integer.parseInt(request.getParameter("quantita"));
		int idtaskUpdate = Integer.parseInt(request.getParameter("id_task"));
		
		TaskDTO taskUpdateDTO = new TaskDTO();
		taskUpdateDTO.setIdTask(idtaskUpdate);
		
		MaterialDTO materialUpdateDTO = new MaterialDTO();
		materialUpdateDTO.setIdmaterial(idmaterialUpdate);
		materialUpdateDTO.setMaterial(materialUpdate);
		materialUpdateDTO.setQuantita(quantitaUpdate);
		materialUpdateDTO.setTaskDTO(taskUpdateDTO);
		
		materialService.updateMaterial(materialUpdateDTO);
		visualMaterial(request);
		
		return "material/manageMaterial";
	}
	
}
