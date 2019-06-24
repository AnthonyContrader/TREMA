package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DipMaterialDTO {
	
	private long id;
    
    private int quantita;
    
    private MaterialDTO materialDTO;
	
	private DipendentiDTO dipendentiDTO;


}
    
