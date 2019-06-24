package it.contrader.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.DipMaterialDTO;
import it.contrader.dto.DipendentiDTO;
import it.contrader.dto.MaterialDTO;
import it.contrader.services.DipMaterialService;

@CrossOrigin("*")
@RestController
@RequestMapping("/dipmaterial")
public class DipMaterialController extends AbstractController<DipMaterialDTO> {
	@Autowired
	private DipMaterialService dipMaterialService;

	// POST Angular a DipMaterialDTO
	@GetMapping("/dipMaterialDipendentiManagement")
	public List<DipMaterialDTO> dipMaterialDipendentiManagement(@RequestParam("id") Long id) {
		DipendentiDTO dipendentiDto = new DipendentiDTO();
		dipendentiDto.setId(id);
		return dipMaterialService.findAllByDipendenti(dipendentiDto);
	}

	// POST Angular a DipMaterialDTO
	@GetMapping("/dipMaterialMaterialManagement")
	public List<DipMaterialDTO> dipMaterialMaterialManagement(@RequestParam("id") Long id) {
		MaterialDTO materialDTO = new MaterialDTO();
		materialDTO.setId(id);
		return dipMaterialService.findAllByMaterial(materialDTO);
	}
}