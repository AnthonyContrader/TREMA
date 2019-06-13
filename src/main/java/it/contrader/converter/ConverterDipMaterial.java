package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.model.DipMaterial;
import it.contrader.dto.DipMaterialDTO;

import it.contrader.model.Material;
import it.contrader.model.SubTask;
import it.contrader.dto.MaterialDTO;
import it.contrader.dto.SubTaskDTO;
import it.contrader.model.Dipendenti;
import it.contrader.dto.DipendentiDTO;
import it.contrader.model.Team;
import it.contrader.dto.TeamDTO;

public class ConverterDipMaterial {

	public static DipMaterialDTO toDTO(DipMaterial dipMaterial) {
		DipMaterialDTO dipMaterialDTO = null;
		
		if (dipMaterial != null) {
			dipMaterialDTO = new DipMaterialDTO();
			dipMaterialDTO.setIdDipMaterial(dipMaterial.getIdDipMaterial());
			dipMaterialDTO.setQuantita(dipMaterial.getQuantita());
			dipMaterialDTO.setDipendentiDTO(ConverterDipendenti.toDTO(dipMaterial.getDipendenti()));
			dipMaterialDTO.setMaterialDTO(ConverterMaterial.toDTO(dipMaterial.getMaterial()));
			
			List<Team> teamList = dipMaterial.getTeam();
			List<TeamDTO> teamListDTO = new ArrayList<TeamDTO>();
		}
	
		return dipMaterialDTO;
	}
	
	public static DipMaterial toEntity(DipMaterialDTO dipMaterialDTO) {
		DipMaterial dipMaterial = null;
		
		if (dipMaterialDTO != null) {
			dipMaterial = new DipMaterial();
			dipMaterial.setIdDipMaterial(dipMaterialDTO.getIdDipMaterial());
			dipMaterial.setQuantita(dipMaterialDTO.getQuantita());
			dipMaterial.setDipendenti(ConverterDipendenti.toEntity(dipMaterialDTO.getDipendentiDTO()));
			dipMaterial.setMaterial(ConverterMaterial.toEntity(dipMaterialDTO.getMaterialDTO()));
			
			List<TeamDTO> teamListDTO = dipMaterialDTO.getTeamDTO();
			List<Team> teamList = new ArrayList<Team>();
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
	