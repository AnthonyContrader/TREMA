package it.contrader.service;

import java.util.ArrayList;
import java.util.List;

import it.contrader.converter.MaterialConverter;
import it.contrader.dao.MaterialDAO;
import it.contrader.dto.MaterialDTO;
import it.contrader.model.Material;


public class MaterialServiceDTO {

	private final MaterialDAO materialDAO;

	public MaterialServiceDTO() {
		this.materialDAO = new MaterialDAO();
	}


	public List<MaterialDTO> getAllMaterial() {

		List<Material> list = materialDAO.getAllMaterial();
		List<MaterialDTO> listDTO = new ArrayList<>();

		for (Material material : list) {
			listDTO.add(MaterialConverter.toDTO(material));
		}

		return listDTO;
	}
	

	public boolean updateMaterial (MaterialDTO materialDTO) {
		return this.materialDAO.updateMaterial(MaterialConverter.toEntity(materialDTO));
		
}
	
	public boolean deleteMaterial (MaterialDTO materialDTO) {
		return this.materialDAO.deleteMaterial(MaterialConverter.toEntity(materialDTO));
		
}
	
	public boolean insertMaterial (MaterialDTO materialDTO) {
		return this.materialDAO.insertMaterial(MaterialConverter.toEntity(materialDTO));
	
}
		
	
	
}
