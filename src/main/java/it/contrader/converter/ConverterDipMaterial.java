package it.contrader.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.contrader.model.DipMaterial;
import it.contrader.dto.DipMaterialDTO;

@Component
public class ConverterDipMaterial extends AbstractConverter<DipMaterial, DipMaterialDTO> {
	@Autowired
	private ConverterDipendenti converterD;
	
	@Autowired
	private ConverterMaterial converterM;
	
	public DipMaterialDTO toDTO(DipMaterial dipMaterial) {
		DipMaterialDTO dipMaterialDTO = null;

		if (dipMaterial != null) {
			dipMaterialDTO = new DipMaterialDTO();
			dipMaterialDTO.setId(dipMaterial.getId());
			dipMaterialDTO.setQuantita(dipMaterial.getQuantita());
			dipMaterialDTO.setDipendentiDTO(converterD.toDTO(dipMaterial.getDipendenti()));
			dipMaterialDTO.setMaterialDTO(converterM.toDTO(dipMaterial.getMaterial()));
		}

		return dipMaterialDTO;
	}

	public DipMaterial toEntity(DipMaterialDTO dipMaterialDTO) {
		DipMaterial dipMaterial = null;

		if (dipMaterialDTO != null) {
			dipMaterial = new DipMaterial();
			dipMaterial.setId(dipMaterialDTO.getId());
			dipMaterial.setQuantita(dipMaterialDTO.getQuantita());
			dipMaterial.setDipendenti(converterD.toEntity(dipMaterialDTO.getDipendentiDTO()));
			dipMaterial.setMaterial(converterM.toEntity(dipMaterialDTO.getMaterialDTO()));
		}

		return dipMaterial;
	}
}
