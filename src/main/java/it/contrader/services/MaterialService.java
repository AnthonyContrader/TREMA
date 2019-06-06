package it.contrader.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.model.Material;
import it.contrader.dto.MaterialDTO;
import it.contrader.dao.MaterialRepository;
import it.contrader.converter.ConverterMaterial;

import it.contrader.model.Task;
import it.contrader.dto.TaskDTO;
import it.contrader.converter.ConverterTask;

import java.util.ArrayList;
import java.util.List;

@Service
public class MaterialService {
	private final MaterialRepository materialRepository;
	
	@Autowired
	public MaterialService(MaterialRepository materialRepository) {
		this.materialRepository = materialRepository;
	}
	
	public List<MaterialDTO> getListaMAterialDTO(){
		return ConverterMaterial.toListDTO((List<Material>) materialRepository.findAll());
		
	}
	
	public MaterialDTO getMaterialDTOByIdmaterial(Integer idmaterial) {
		return ConverterMaterial.toDTO(materialRepository.findById(idmaterial).get());
	}

	public List<MaterialDTO> getListaMaterialDTOByTask(TaskDTO taskDTO) {
		return ConverterMaterial.toListDTO((List<Material>) materialRepository.findAllByTask(ConverterTask.toEntity(taskDTO)));
	}
	
	public boolean insertMaterial(MaterialDTO materialDTO) {
		return materialRepository.save(ConverterMaterial.toEntity(materialDTO)) != null;
	}
	
	public boolean updateMaterial(MaterialDTO materialDTO) {
		return materialRepository.save(ConverterMaterial.toEntity(materialDTO)) != null;
	}
	
	public void deletematerialByIdmaterial(Integer idmaterial) {
		materialRepository.deleteById(idmaterial);
	}
	
	public List<MaterialDTO> findMaterialDTOByTask(Task task) {
		final List<Material> listMaterial = materialRepository.findAllByTask(task);
		final List<MaterialDTO> listMaterialDTO = new ArrayList<>();
		listMaterial.forEach(i -> listMaterialDTO.add(ConverterMaterial.toDTO(i)));
		return listMaterialDTO;
	}
}
