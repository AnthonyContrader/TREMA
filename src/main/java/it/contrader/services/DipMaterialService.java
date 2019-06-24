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
	@Autowired
	private DipMaterialRepository dipMaterialRepository;
	
	@Autowired
	private ConverterDipMaterial converterDM;
	
	@Autowired
	private ConverterDipendenti converterD;
	
	@Autowired
	private ConverterMaterial converterM;
	
	public List<DipMaterialDTO> findAllByDipendenti(DipendentiDTO dipendentiDTO) {
		return converterDM.toDTOList(dipMaterialRepository.findAllByDipendenti(converterD.toEntity(dipendentiDTO)));
	}
	
	public List<DipMaterialDTO> findAllByMaterial(MaterialDTO materialDTO) {
		return converterDM.toDTOList(dipMaterialRepository.findAllByMaterial(converterM.toEntity(materialDTO)));
	}
}
