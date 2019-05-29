package it.contrader.converter;

import it.contrader.dto.MaterialDTO;
import it.contrader.model.Material;
import it.contrader.converter.*;

public class MaterialConverter implements Converter<Material,MaterialDTO> {

	public Material toEntity(MaterialDTO materialDTO) {

		Material material = null;
		if (materialDTO != null) {
			material = new Material (materialDTO.getIdmaterial(), materialDTO.getTipo(), materialDTO.getquantita(), materialDTO.getidHR());
			
		}
		Integer idmaterial =materialDTO.getIdmaterial();
		if(idmaterial != null) {
			material.setIdmaterial(idmaterial);
		}


		return material;
	}

	public MaterialDTO toDTO(Material material) {

		MaterialDTO materialDTO = null;
		if (material != null) {
			materialDTO = new MaterialDTO(material.getIdmaterial(), material.getTipo(), material.getQuantita(), material.getIdHR());
		}

		return materialDTO;
	}
}
