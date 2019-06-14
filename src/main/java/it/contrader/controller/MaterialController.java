package it.contrader.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.MaterialDTO;

@CrossOrigin
@RestController
@RequestMapping("/Material")
public class MaterialController extends AbstractController<MaterialDTO> {
	
}
