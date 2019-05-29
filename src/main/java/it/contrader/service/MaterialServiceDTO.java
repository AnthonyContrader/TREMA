package it.contrader.service;

import it.contrader.converter.MaterialConverter;
import it.contrader.dao.MaterialDAO;
import it.contrader.dto.MaterialDTO;
import it.contrader.model.Material;

public class MaterialServiceDTO extends AbstractServiceDTO<Material,MaterialDTO> {
	
	public MaterialServiceDTO() {
		dao = new MaterialDAO();
		converter = new MaterialConverter();
	}
}