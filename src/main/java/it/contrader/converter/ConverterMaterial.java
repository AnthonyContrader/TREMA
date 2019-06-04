package it.contrader.wmesspring.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.wmesspring.dto.ClientDTO;
import it.contrader.wmesspring.dto.OrderDTO;
import it.contrader.wmesspring.dto.TaskDTO;
import it.contrader.wmesspring.model.Client;
import it.contrader.wmesspring.model.Order;
import it.contrader.wmesspring.model.Task;



public class ConverterMaterial {
	 
	public static MaterialDTO toDTO(Material material) {

			MaterialDTO materialDTO = null;
			
			if (material != null) {
				materialDTO = new MaterialDTO();
				materialDTO.setMaterialDTO(ConverterTask.toDTO(material.getTask()));
				
				materialDTO.setMaterialName(material.getMaterialName());

				materialDTO.setIdmaterial(material.getIdmaterial());	
				
	
				
			}
		
		return materialDTO;
	}
	 
	public static Material toEntity(MaterialDTO materialDTO) {
		
		Material material = null;
		
		if (materialDTO != null) {
			material = new Material();
			material.setTask(ConverterTask.toEntity(materialDTO.getTaskDTO()));

			material.setIdmaterial(materialDTO.getIdmaterial());
			material.setMaterialName(materialDTO.getMaterial());
			
			
			
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
			for (MaterialDTO materialDTO : listClientDTO) {
				list.add(ConverterMAterial.toEntity(materialDTO));
			}
		}
		return list;
	}
	
	}