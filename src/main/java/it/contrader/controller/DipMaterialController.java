package it.contrader.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.TeamDTO;
import it.contrader.dto.UserDTO;
import it.contrader.dto.DipMaterialDTO;
import it.contrader.services.DipMaterialService;
import it.contrader.model.DipMaterial;
import it.contrader.model.Dipendenti;
import it.contrader.model.Material;
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

	@RequestMapping(value = "dipMaterialManagement", method = RequestMethod.GET)
	public List<DipMaterialDTO> dipMaterialManagement(@RequestParam(value = "IdDipMaterial") DipMaterialDTO IdDipMaterial) {
		TeamDTO teamDTODipMaterialList = new TeamDTO();
		teamDTODipMaterialList.setDipMaterialDTO(IdDipMaterial);
		return this.dipMaterialService.findDipMaterialDTOByTeam(teamDTODipMaterialList);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public void delete(@RequestParam(value = "IdDipMaterial") int id) {
		this.dipMaterialService.deleteDipMaterialById(id);
	}
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public void insert(@RequestBody DipMaterialDTO dipMaterialDTO) {
		this.dipMaterialService.insertDipMaterial(dipMaterialDTO);
	}

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public DipMaterialDTO read(@RequestParam(value = "IdDipMaterial") int id) {
		DipMaterialDTO dipMaterialUpdate = new DipMaterialDTO();
		dipMaterialUpdate = this.dipMaterialService.getDipMaterialDTOById(id);
		return dipMaterialUpdate;

	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
    public List<DipMaterialDTO> update(@RequestParam(value = "IdDipMaterial") int idUpdate,
            @RequestParam(value = "Quantita") int Quantita,
			@RequestParam(value = "IdDipendenti") Dipendenti IdDipendenti,
			@RequestParam(value = "IdMaterial") Material IdMaterial) {

		DipMaterialDTO dipMaterial = new DipMaterialDTO();
        dipMaterial.setIdDipMaterial(idUpdate);
        dipMaterial.setQuantita(Quantita);
		dipMaterial.setDipendenti(IdDipendenti);
		dipMaterial.setMaterial(IdMaterial);
		dipMaterialService.updateDipMaterial(dipMaterial);

		return this.dipMaterialService.getListDipMaterialDTO();
	}

}