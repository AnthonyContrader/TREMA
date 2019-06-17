package it.contrader.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.MaterialDTO;
import it.contrader.services.MaterialService;

@CrossOrigin
@RestController
@RequestMapping("/Material")
public class MaterialController extends AbstractController<MaterialDTO> {
	@Autowired
	MaterialService materialService;
	
	// POST Angular a DipendentiDTO
	@PostMapping("/materialManagement")
	public List<MaterialDTO> materialManagement() {
		return materialService.findAll();
	}
}
