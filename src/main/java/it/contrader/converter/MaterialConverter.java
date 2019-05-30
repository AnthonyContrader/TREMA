package it.contrader.converter;

import it.contrader.dto.MaterialDTO;
import it.contrader.dto.HumanResourceDTO;
import it.contrader.model.Material;
import it.contrader.model.HumanResource;

public class MaterialConverter{

	public static Material toEntity(MaterialDTO materialDTO) {
		Material material = null;
		
		if (materialDTO != null) {
			HumanResource hr = HumanResourceConverter.toEntity(materialDTO.getHRDTO());
			material = new Material(materialDTO.getTipo(), materialDTO.getQuantita(), hr);
			material.setIdmaterial(materialDTO.getIdmaterial());
		}
		return material;
	}

	public static MaterialDTO toDTO(Material material) {
		MaterialDTO materialDTO = null;
		
		if (material != null) {
			HumanResource hrDTO = HumanResourceConverter.toDTO(material.getHR());
			materialDTO = new MaterialDTO(material.getTipo(), material.getQuantita(), hrDTO);
			materialDTO.setIdmaterial(material.getIdmaterial());
		}
	}
}
