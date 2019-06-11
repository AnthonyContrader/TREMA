package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.dto.DipendentiDTO;
import it.contrader.services.DipendentiService;

import it.contrader.dto.TaskDTO;
import it.contrader.services.TaskService;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/Dipendenti")
public class DipendentiController {

	private final DipendentiService dipendentitService;
	
	@Autowired
	public DipendentiController(DipendentiService dipendentiService) {
		this.dipendentiService = dipendentiService;
	}


	@RequestMapping(value = "/dipendentiManagement", method = RequestMethod.GET)
	public List<DipendentiDTO> dipendentiManagement(@RequestParam(value = "IdDipendenti") int IdDipendenti) { 
		dipendentiDTO dipendentiDTODipendentiList = new DipendentiDTO();
		dipendentiDTODipendentiList.setIdDipendenti(IdDipendenti);
		return this.dipendentiService.findDipendentiDTOByDipendenti(ConverterDipendenti.toEntity(DipendentiDTODipendentiList));
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)	
	public void delete(@RequestParam(value ="IdDipendenti") int id) {
		this.dipendentiService.deleteDipendentiById(id);
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public void insert(@RequestBody DipendentilDTO dipendenti) {
		dipendentiService.insertDipendenti(dipendenti);

	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public DipendentiDTO read(@RequestParam(value = "IdDipendenti") int id) {
		MaterialDTO dipendentiUpdate = new DipendentiDTO();
		dipendentiUpdate = this.dipendentiService.getDipendentiDTOByIdDipendenti(id);
		return dipendentiUpdate;
	}		
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public void update(@RequestBody DipendentitDTO dipendenti) {
		dipendentiService.updateDipendenti(dipendenti);
	}
}
