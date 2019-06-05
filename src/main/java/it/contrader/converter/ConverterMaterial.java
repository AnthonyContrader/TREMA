package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.DipendentiDTO;
import it.contrader.dto.MaterialDTO;
import it.contrader.dto.TaskDTO;
import it.contrader.model.Dipendenti;
import it.contrader.model.Material;
import it.contrader.model.Task;



public class ConverterMaterial {
	 
	public static MaterialDTO toDTO(Material material) {

			MaterialDTO materialDTO = null;
			
			if (material != null) {
				materialDTO = new MaterialDTO();
				materialDTO.setTaskDTO(ConverterTask.toDTO(material.getTask()));
				
				materialDTO.setMaterial(material.getMaterial());
				
				materialDTO.setQuantita(material.getQuantita());

				materialDTO.setIdmaterial(material.getIdmaterial());		
			}
		
		return materialDTO;
	}
	 
	public static Material toEntity(MaterialDTO materialDTO) {
		
		Material material = null;
		
		if (materialDTO != null) {
			material = new Material();
			material.setTask(ConverterTask.toEntity(materialDTO.getTaskDTO()));

			material.setIdMaterial(materialDTO.getIdmaterial());
			material.setMaterial(materialDTO.getMaterial());
			material.setQuantita(materialDTO.getQuantita());			
		}
		return material;	
		}
	
	public static List<MaterialDTO> toListDTO(List<Material> list) {
		List<MaterialDTO> listMaterialDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (Material material : list) {
				listMaterialDTO.add(ConverterMaterial.toDTO(material));
			}
		}
		return listMaterialDTO;
	}

	public static List<Material> toListEntity(List<MaterialDTO> listMaterialDTO) {
		List<Material> list = new ArrayList<>();
		if (!listMaterialDTO.isEmpty()) {
			for (MaterialDTO materialDTO : listMaterialDTO) {
				list.add(ConverterMaterial.toEntity(materialDTO));
			}
		}
		return list;
	}
	
	}