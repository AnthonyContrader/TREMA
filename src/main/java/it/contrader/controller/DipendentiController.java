package it.contrader.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.DipendentiDTO;

@CrossOrigin
@RestController
@RequestMapping("/Dipendenti")
public class DipendentiController extends AbstractController<DipendentiDTO>{
	
}
