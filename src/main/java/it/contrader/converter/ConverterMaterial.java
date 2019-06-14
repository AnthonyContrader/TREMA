package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.MaterialDTO;
import it.contrader.model.Material;

@Component
public class ConverterMaterial extends AbstractConverter<Material, MaterialDTO> {
	public MaterialDTO toDTO(Material material) {
		MaterialDTO materialDTO = null;
			
		if (material != null) {
			materialDTO = new MaterialDTO();
			materialDTO.setId(material.getId());
			materialDTO.setMaterial(material.getMaterial());
		}
		
		return materialDTO;
	}
	 
	public Material toEntity(MaterialDTO materialDTO) {
		Material material = null;
		
		if (materialDTO != null) {
			material = new Material();
			material.setId(materialDTO.getId());
			material.setMaterial(materialDTO.getMaterial());
		}
		
		return material;	
	}
}