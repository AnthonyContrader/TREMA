package it.contrader.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.converter.ConverterDipendenti;
import it.contrader.dto.DipendentiDTO;
import it.contrader.services.DipendentiService;

@CrossOrigin
@RestController
@RequestMapping("/Dipendenti")
public class DipendentiController extends AbstractController<DipendentiDTO>{
	@Autowired
	DipendentiService dipendentiService;

	
	// POST Angular a DipendentiDTO
	@PostMapping("/dipendentiManagement")
	public List<DipendentiDTO> dipendentiManagement() {
		return dipendentiService.findAllDipendenti();
	}
}
