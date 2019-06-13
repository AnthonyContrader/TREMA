package it.contrader.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.DipMaterialDTO;
import it.contrader.services.DipMaterialService;
import it.contrader.dto.DipendentiDTO;
import it.contrader.dto.MaterialDTO;

@CrossOrigin
@RestController
@RequestMapping("/DipMaterial")
public class DipMaterialController {
	private final DipMaterialService dipMaterialService;

	@Autowired
	public DipMaterialController(DipMaterialService dipMaterialService) {
		this.dipMaterialService = dipMaterialService;
	}

	@RequestMapping(value = "/taskManagement", method = RequestMethod.GET)
	public List<DipMaterialDTO> taskManagement(@RequestParam(value = "Entity") String entity,
											   @RequestParam(value = "Id") Integer id) {
		
		switch (entity) {
			case "Dipendenti":
				DipendentiDTO dipendentiDTOList = new DipendentiDTO();
				dipendentiDTOList.setIdDipendente(id);
				return this.dipMaterialService.findDipMaterialDTOByDipendenti(dipendentiDTOList);
			case "Material":
				MaterialDTO materialDTOTeamList = new MaterialDTO();
				materialDTOTeamList.setIdMaterial(id);
				return this.dipMaterialService.findDipMaterialDTOByMaterial(materialDTOTeamList);
			default:
				return null;
		}
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public void delete(@RequestParam(value = "IdDipMaterial") Integer idDipMaterial) {
		this.dipMaterialService.deleteDipMaterialById(idDipMaterial);
	}
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public void insert(@RequestBody DipMaterialDTO dipMaterialDTO) {
		this.dipMaterialService.insertDipMaterial(dipMaterialDTO);
	}

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public DipMaterialDTO read(@RequestParam(value = "IdDipMaterial") Integer idDipMaterial) {
		DipMaterialDTO dipMaterialUpdate = new DipMaterialDTO();
		dipMaterialUpdate = this.dipMaterialService.getDipMaterialDTOById(idDipMaterial);
		return dipMaterialUpdate;

	}
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public void update(@RequestBody DipMaterialDTO dipMaterialDTO) {
		dipMaterialService.updateTask(dipMaterialDTO);
	}
	
	/*
	 * @RequestMapping(value = "/update", method = RequestMethod.POST) public
	 * List<DipMaterialDTO> update(@RequestParam(value = "IdDipMaterial") Integer
	 * idUpdate,
	 * 
	 * @RequestParam(value = "Quantita") int Quantita,
	 * 
	 * @RequestParam(value = "IdDipendenti") Dipendenti IdDipendenti,
	 * 
	 * @RequestParam(value = "IdMaterial") Material IdMaterial) {
	 * 
	 * DipMaterialDTO dipMaterial = new DipMaterialDTO();
	 * dipMaterial.setIdDipMaterial(idUpdate); dipMaterial.setQuantita(Quantita);
	 * dipMaterial.setDipendenti(IdDipendenti); dipMaterial.setMaterial(IdMaterial);
	 * dipMaterialService.updateDipMaterial(dipMaterial);
	 * 
	 * return this.dipMaterialService.getListDipMaterialDTO(); }
	 */
}