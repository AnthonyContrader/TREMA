package it.contrader.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import it.contrader.dto.DipendentiDTO;
import it.contrader.dto.MaterialDTO;
import it.contrader.dto.TaskDTO;
import it.contrader.services.DipendentiService;

@CrossOrigin
@RestController
@RequestMapping("/Dipendenti")
public class DipendentiController {
	private final DipendentiService dipendentiService;
	
	@Autowired
	public DipendentiController(DipendentiService dipendentiService) {
		this.dipendentiService = dipendentiService;
	}

	@RequestMapping(value = "/dipendentiManagement", method = RequestMethod.GET)
	public List<DipendentiDTO> dipendentiManagement() {
		return this.dipendentiService.getListDipendentiDTO();
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public void delete(@RequestParam(value = "IdDipendenti") Integer idDipendenti) {
		this.dipendentiService.deleteDipendentiById(idDipendenti);
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public void insert(@RequestBody DipendentiDTO dipendentiDTO) {
		this.dipendentiService.insertDipendenti(dipendentiDTO);
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public DipendentiDTO read(@RequestParam(value = "IdMaterial") Integer idDipendenti) {
		DipendentiDTO dipendentiUpdate = new DipendentiDTO();
		dipendentiUpdate = this.dipendentiService.getDipendentiDTOById(idDipendenti);
		return dipendentiUpdate;
	}	
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public void update(@RequestBody DipendentiDTO dipendentiDTO) {
		dipendentiService.updateDipendenti(dipendentiDTO);
	}
	
	/*
	 * @RequestMapping(value = "/update", method = RequestMethod.POST) public
	 * List<DipendentiDTO> update(@RequestParam(value = "IdDipendenti") Integer
	 * idDipendente,
	 * 
	 * @RequestParam(value = "NomeDip") String nomeDip,
	 * 
	 * @RequestParam(value = "CognomeDip") String cognomeDip) {
	 * 
	 * DipendentiDTO dipendentiDTO = new DipendentiDTO();
	 * dipendentiDTO.setIdDipendente(idDipendente);
	 * dipendentiDTO.setCognomeDip(nomeDip);
	 * dipendentiDTO.setCognomeDip(cognomeDip);
	 * dipendentiService.updateDipendenti(dipendentiDTO);
	 * 
	 * return this.dipendentiService.getListDipendentiDTO(); }
	 */
}
