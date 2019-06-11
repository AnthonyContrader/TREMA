package it.contrader.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.dto.DipMaterialDTO;
import it.contrader.converter.ConverterDipMaterial;
import it.contrader.dao.DipMaterialRepository;
import it.contrader.model.DipMaterial;

import it.contrader.converter.ConverterTeam;
import it.contrader.dto.TeamDTO;

import it.contrader.dto.DipendentiDTO;
import it.contrader.converter.ConverterDipendenti;

import it.contrader.dto.MaterialDTO;
import it.contrader.converter.ConverterMaterial;

@Service
public class DipMaterialService {

	private final DipMaterialRepository dipMaterialRepository;		//DA FAREE!!
	//@Autowired
	//private TaskService taskService;

	@Autowired
	public DipMaterialService(DipMaterialRepository dipMaterialRepository) {
		this.dipMaterialRepository = dipMaterialRepository;
	}

	public List<DipMaterialDTO> getListDipMaterialDTO() {
		return ConverterDipMaterial.toListDTO((List<DipMaterial>) dipMaterialRepository.findAll());
	}

	public DipMaterialDTO getDipMaterialDTOById(Integer id) {
		return ConverterDipMaterial.toDTO(DipMaterialRepository.findById(id).get());
	}

	public boolean insertDipMaterial(DipMaterialDTO DipMaterialDTO) {
		return DipMaterialRepository.save(ConverterDipMaterial.toEntity(DipMaterialDTO)) != null;
	}

	public boolean updateDipMaterial(DipMaterialDTO DipMaterialDTO) {
		return DipMaterialRepository.save(ConverterDipMaterial.toEntity(DipMaterialDTO)) != null;
	}

	public void deleteDipMaterialById(Integer id) {
		DipMaterialRepository.deleteById(id);
	}

	public List<DipMaterialDTO> findDipMaterialDTOByTeam(TeamDTO teamDTO) {
		final List<DipMaterial> listDipMaterial = DipMaterialRepository.findAllByTeam(ConverterTeam.toEntity(teamDTO));
		final List<DipMaterialDTO> listDipMaterialDTO = new ArrayList<>();
		listDipMaterial.forEach(i -> listDipMaterialDTO.add(ConverterDipMaterial.toDTO(i)));
		return listDipMaterialDTO;
	}
}