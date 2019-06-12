package it.contrader.dto;

import java.util.List;
import it.contrader.model.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DipMaterialDTO {
    private int IdDipMaterial;
    
    private int Quantita;

    private Dipendenti Dipendenti;
	
    private Material Material;

	private List<TeamDTO> TeamDTO;


}
    
