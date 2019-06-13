package it.contrader.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.MaterialDTO;
import it.contrader.services.MaterialService;

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
	public List<MaterialDTO> materialManagement() {
		return this.materialService.getListaMaterialDTO();
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public void delete(@RequestParam(value = "IdMaterial") Integer idMaterial) {
		this.materialService.deleteMaterialById(idMaterial);
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public void insert(@RequestBody MaterialDTO materialDTO) {
		this.materialService.insertMaterial(materialDTO);
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public MaterialDTO read(@RequestParam(value = "IdMaterial") Integer idMaterial) {
		MaterialDTO materialUpdate = new MaterialDTO();
		materialUpdate = this.materialService.getMaterialDTOById(idMaterial);
		return materialUpdate;
	}	
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public void update(@RequestBody MaterialDTO materialDTO) {
		materialService.updateMaterial(materialDTO);
	}
	
	/*
	 * @RequestMapping(value = "/update", method = RequestMethod.POST) public
	 * List<MaterialDTO> update(@RequestParam(value = "IdMaterial") Integer
	 * idMaterial,
	 * 
	 * @RequestParam(value = "Material") String material) {
	 * 
	 * MaterialDTO materialDTO = new MaterialDTO();
	 * materialDTO.setIdMaterial(idMaterial); materialDTO.setMaterial(material);
	 * materialService.updateMaterial(materialDTO);
	 * 
	 * return this.materialService.getListaMaterialDTO(); }
	 */
}
