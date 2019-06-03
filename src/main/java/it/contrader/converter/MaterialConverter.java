package it.contrader.converter;

import it.contrader.dto.MaterialDTO;
import it.contrader.dto.UsersDTO;
import it.contrader.model.Material;
import it.contrader.model.Users;

public class MaterialConverter{

	public static Material toEntity(MaterialDTO materialDTO) {
		
		Material material = null;
		if (materialDTO != null) {
			Users user = UsersConverter.toEntity(materialDTO.getUserDTO());
			material = new Material(materialDTO.getTipo(), materialDTO.getQuantita(), user);
			material.setIdmaterial(materialDTO.getIdmaterial());
		}
		return material;
	}

	public static MaterialDTO toDTO(Material material) {
		
		MaterialDTO materialDTO = null;
		if (material != null) {
			UsersDTO userDTO = UsersConverter.toDTO(material.getUser());
			materialDTO = new MaterialDTO(material.getTipo(), material.getQuantita(), userDTO);
			materialDTO.setIdmaterial(material.getIdmaterial());
		}
		
		return materialDTO;
	}
}
