package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.MaterialDTO;
import it.contrader.dto.DipMaterialDTO;
import it.contrader.model.Material;
import it.contrader.model.DipMaterial;
import it.contrader.model.Dipendenti;
import it.contrader.dto.DipendentiDTO;

public class ConverterDipMaterial {

	public static DipMaterialDTO toDTO(DipMaterial dipMaterial) {

		DipMaterialDTO dipMaterialDTO = null;
		
		if (dipMaterial != null) {
			dipMaterialDTO = new DipMaterialDTO();
			dipMaterialDTO.setDipendenti(dipMaterial.getDipendenti());
			dipMaterialDTO.setMaterial(dipMaterial.getMaterial());
			dipMaterialDTO.setQuantita(dipMaterial.getQuantita());
			dipMaterialDTO.setIdDipMaterial(dipMaterial.getIdDipMaterial());	
		}
	
	return dipMaterialDTO;
	
	}
	
	public static DipMaterial toEntity(DipMaterialDTO dipMaterialDTO) {
		
		DipMaterial dipMaterial = null;
		
		if (dipMaterialDTO != null) {
			dipMaterial = new DipMaterial();
			dipMaterial.setDipendenti(dipMaterialDTO.getDipendenti());
			dipMaterial.setMaterial(dipMaterialDTO.getMaterial());
			dipMaterial.setQuantita(dipMaterial.getQuantita());
			dipMaterial.setIdDipMaterial(dipMaterial.getIdDipMaterial());
		}
		return dipMaterial;	
		}
	
	public static List<DipMaterialDTO> toListDTO(List<DipMaterial> list) {
		List<DipMaterialDTO> listDipMaterialDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (DipMaterial dipMaterial : list) {
				listDipMaterialDTO.add(ConverterDipMaterial.toDTO(dipMaterial));
			}
		}
		return listDipMaterialDTO;
	}

	public static List<DipMaterial> toListEntity(List<DipMaterialDTO> listDipMaterialDTO) {
		List<DipMaterial> list = new ArrayList<>();
		if (!listDipMaterialDTO.isEmpty()) {
			for (DipMaterialDTO dipMaterialDTO : listDipMaterialDTO) {
				list.add(ConverterDipMaterial.toEntity(dipMaterialDTO));
			}
		}
		return list;
	}
}
	