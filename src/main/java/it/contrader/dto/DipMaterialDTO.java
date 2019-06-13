package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
    
