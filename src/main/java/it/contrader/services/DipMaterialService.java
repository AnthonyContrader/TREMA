package it.contrader.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.ConverterDipMaterial;
import it.contrader.converter.ConverterDipendenti;
import it.contrader.converter.ConverterMaterial;
import it.contrader.dao.DipMaterialRepository;
import it.contrader.dto.DipMaterialDTO;
import it.contrader.dto.DipendentiDTO;
import it.contrader.dto.MaterialDTO;
import it.contrader.model.DipMaterial;

@Service
public class DipMaterialService extends AbstractService<DipMaterial, DipMaterialDTO> {
	private final DipMaterialRepository dipMaterialRepository;
	
	@Autowired
	private ConverterDipMaterial converterDM;
	
	@Autowired
	private ConverterDipendenti converterD;
	
	@Autowired
	private ConverterMaterial converterM;
	
	@Autowired
	public DipMaterialService(DipMaterialRepository dipMaterialRepository) {
		this.dipMaterialRepository = dipMaterialRepository;
	}
	
	public List<DipMaterialDTO> findByDipendenti(DipendentiDTO dipendentiDTO) {
		final List<DipMaterial> list = dipMaterialRepository.findByDipendenti(converterD.toEntity(dipendentiDTO));
		final List<DipMaterialDTO> listDTOs = new ArrayList<>();
		list.forEach(i -> listDTOs.add(converterDM.toDTO(i)));
		return listDTOs;
	}
	
	public List<DipMaterialDTO> findByMaterial(MaterialDTO materialDTO) {
		final List<DipMaterial> list = dipMaterialRepository.findByMaterial(converterM.toEntity(materialDTO));
		final List<DipMaterialDTO> listDTOs = new ArrayList<>();
		list.forEach(i -> listDTOs.add(converterDM.toDTO(i)));
		return listDTOs;
	}
}
