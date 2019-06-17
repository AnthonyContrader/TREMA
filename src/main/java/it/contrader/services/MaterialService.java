package it.contrader.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.ConverterMaterial;
import it.contrader.dao.MaterialRepository;
import it.contrader.dto.MaterialDTO;
import it.contrader.dto.TaskDTO;
import it.contrader.model.Material;

@Service
public class MaterialService extends AbstractService<Material, MaterialDTO> {
	@Autowired
	private MaterialRepository materialRepository;
	
	@Autowired
	private ConverterMaterial converterMaterial;
	
	public List<MaterialDTO> findAll() {
		return converterMaterial.toDTOList(materialRepository.findAll());
	}
}
