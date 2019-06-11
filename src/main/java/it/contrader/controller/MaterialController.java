package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.TaskDTO;
import it.contrader.services.TaskService;
import it.contrader.wmesspring.dto.ClientDTO;
import it.contrader.wmesspring.dto.OrderDTO;
import it.contrader.wmesspring.dto.UserDTO;
import it.contrader.dto.MaterialDTO;
import it.contrader.services.MaterialService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/Material")
public class MaterialController {

	private final MaterialService materialService;
	
	@Autowired
	public MaterialController(MaterialService materialService) {
		this.materialService = materialService;
	}


	@RequestMapping(value = "/materialManagement", method = RequestMethod.GET)
	public List<MaterialDTO> materialManagement(@RequestParam(value = "IdMaterial") int IdMaterial) { 
		materialDTO materialDTOMaterialList = new MaterialDTO();
		materialDTOMaterialList.setIdMaterial(IdMaterial);
		return this.materialService.findMaterialDTOByMaterial(ConverterMaterial.toEntity(MaterialDTOMaterialList));
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)	
	public void delete(@RequestParam(value ="IdMaterial") int id) {
		this.materialService.deleteMaterialById(id);
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public void insert(@RequestBody MaterialDTO material) {
		materialService.insertMaterial(material);

	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public MaterialDTO read(@RequestParam(value = "IdMaterial") int id) {
		MaterialDTO materialUpdate = new MaterialDTO();
		materialUpdate = this.materialService.getMaterialDTOByIdMaterial(id);
		return materialUpdate;
	}		
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public void update(@RequestBody MaterialtDTO material) {
		materialService.updateMaterial(material);
	}
}
