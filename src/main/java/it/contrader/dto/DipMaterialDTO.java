package it.contrader.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DipMaterialDTO {
    private int IdDipMaterial;
    
    private int Quantita;

    private DipendentiDTO DipendentiDTO;
	
    private MaterialDTO MaterialDTO;

	private List<TeamDTO> TeamDTO;

}
    
