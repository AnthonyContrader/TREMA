package it.contrader.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.dto.DipendentiDTO;
import it.contrader.converter.ConverterDipendenti;

import it.contrader.dto.MaterialDTO;
import it.contrader.converter.ConverterMaterial;
import it.contrader.model.DipMaterial;
import it.contrader.dao.DipMaterialRepository;
import it.contrader.dto.DipMaterialDTO;
import it.contrader.converter.ConverterDipMaterial;

import java.util.ArrayList;
import java.util.List;

@Service
public class DipMaterialService {
	@Autowired
	private DipMaterialRepository dipMaterialRepository;
	
	public List<DipMaterialDTO> getListaTaskDTO() {
		return ConverterDipMaterial.toListDTO((List<DipMaterial>) dipMaterialRepository.findAll());
	}
	
	public DipMaterialDTO getDipMaterialDTOById(Integer idDipMaterial) {
		return ConverterDipMaterial.toDTO(dipMaterialRepository.findById(idDipMaterial).get());
	}
		
	public boolean insertDipMaterial(DipMaterialDTO dipMaterialDTO) {
		return dipMaterialRepository.save(ConverterDipMaterial.toEntity(dipMaterialDTO)) != null;
	}

	public boolean updateTask(DipMaterialDTO dipMaterialDTO) {
		return dipMaterialRepository.save(ConverterDipMaterial.toEntity(dipMaterialDTO)) != null;
	}
	
	public void deleteDipMaterialById(Integer dipMaterial) {
		dipMaterialRepository.deleteById(dipMaterial);
	}
	
	public List<DipMaterialDTO> findDipMaterialDTOByDipendenti(DipendentiDTO dipendentiDTO) {
		final List<DipMaterial> listDipMaterial = dipMaterialRepository.findAllByDipendenti(ConverterDipendenti.toEntity(dipendentiDTO));
		final List<DipMaterialDTO> listDipMaterialDTO = new ArrayList<>();
		listDipMaterial.forEach(i -> listDipMaterialDTO.add(ConverterDipMaterial.toDTO(i)));
		return listDipMaterialDTO;
	}
	
	public List<DipMaterialDTO> findDipMaterialDTOByMaterial(MaterialDTO materialDTO) {
		final List<DipMaterial> listDipMaterial = dipMaterialRepository.findAllByMaterial(ConverterMaterial.toEntity(materialDTO));
		final List<DipMaterialDTO> listDipMaterialDTO = new ArrayList<>();
		listDipMaterial.forEach(i -> listDipMaterialDTO.add(ConverterDipMaterial.toDTO(i)));
		return listDipMaterialDTO;
	}
}
