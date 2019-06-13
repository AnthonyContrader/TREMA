package it.contrader.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.model.Material;
import it.contrader.dto.MaterialDTO;
import it.contrader.dao.MaterialRepository;
import it.contrader.converter.ConverterMaterial;

import it.contrader.dto.TaskDTO;
import it.contrader.dao.TaskRepository;
import it.contrader.converter.ConverterTask;

import java.util.ArrayList;
import java.util.List;

@Service
public class MaterialService {
	@Autowired
	private  MaterialRepository materialRepository;
	
	public List<MaterialDTO> getListaMaterialDTO(){
		return ConverterMaterial.toListDTO((List<Material>) materialRepository.findAll());
	}
	
	public MaterialDTO getMaterialDTOById(Integer idMaterial) {
		return ConverterMaterial.toDTO(materialRepository.findById(idMaterial).get());
	}

	public boolean insertMaterial(MaterialDTO materialDTO) {
		return materialRepository.save(ConverterMaterial.toEntity(materialDTO)) != null;
	}
	
	public boolean updateMaterial(MaterialDTO materialDTO) {
		return materialRepository.save(ConverterMaterial.toEntity(materialDTO)) != null;
	}
	
	public void deleteMaterialById(Integer idMaterial) {
		materialRepository.deleteById(idMaterial);
	}
}
