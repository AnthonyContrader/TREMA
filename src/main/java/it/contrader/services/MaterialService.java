package it.contrader.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.ConverterMaterial;
import it.contrader.converter.ConverterUser;
import it.contrader.dao.MaterialRepository;
import it.contrader.dto.MaterialDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Material;

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

	
	public boolean insertMaterial(MaterialDTO materialDTO) {
		return materialRepository.save(ConverterMaterial.toEntity(materialDTO)) != null;
	}
	
	public boolean updateMaterial(MaterialDTO materialDTO) {
		return materialRepository.save(ConverterMaterial.toEntity(materialDTO)) != null;
	}
	
	public void deletematerialByIdmaterial(Integer idmaterial) {
		materialRepository.deleteById(idmaterial);
	}

	
	public List<MaterialDTO> findMaterialDTOByUser( UserDTO userDTO) {
		
		final List<Material> listMaterial = materialRepository.findAllByUser(ConverterUser.toEntity(userDTO));
		final List<MaterialDTO> listMaterialDTO = new ArrayList<>();
		listMaterial.forEach(i -> listMaterialDTO.add(ConverterMaterial.toDTO(i)));
		return listMaterialDTO;
	}
}
