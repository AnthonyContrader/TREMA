package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.MaterialDTO;
import it.contrader.model.Material;


public class MaterialConverter {


	public static Material toEntity(MaterialDTO materialDTO) {

		Material material = null;
		if (materialDTO != null) {
			material = new Material(materialDTO.getIdmaterial(), materialDTO.getTipo(), materialDTO.getQuantita(), materialDTO.getIdHR());
		}

		return material;
	}


	public static MaterialDTO toDTO(Material material) {

		MaterialDTO materialDTO = null;
		if (material != null) {
			materialDTO = new MaterialDTO(material.getIdmaterial(), material.getTipo(), material.getQuantita(), material.getIdHR());
		}

		return materialDTO;
	}
	

}
