package it.contrader.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.DipMaterialDTO;

@CrossOrigin
@RestController
@RequestMapping("/DipMaterial")
public class DipMaterialController extends AbstractController<DipMaterialDTO> {
	
}