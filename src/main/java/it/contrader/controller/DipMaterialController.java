package it.contrader.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.DipMaterialDTO;
import it.contrader.dto.DipendentiDTO;
import it.contrader.dto.MaterialDTO;
import it.contrader.services.DipMaterialService;

@CrossOrigin
@RestController
@RequestMapping("/DipMaterial")
public class DipMaterialController extends AbstractController<DipMaterialDTO> {
	@Autowired
	private DipMaterialService dipMaterialService;

	// POST Angular a DipMaterialDTO
	@PostMapping("/dipMaterialDipendentiManagement")
	public List<DipMaterialDTO> dipMaterialDipendentiManagement(@RequestBody DipendentiDTO dipendentiDTO) {
		return dipMaterialService.findAllByDipendenti(dipendentiDTO);
	}

	// POST Angular a DipMaterialDTO
	@PostMapping("/dipMaterialMaterialManagement")
	public List<DipMaterialDTO> dipMaterialMaterialManagement(@RequestBody MaterialDTO materialDTO) {
		return dipMaterialService.findAllByMaterial(materialDTO);
	}
}