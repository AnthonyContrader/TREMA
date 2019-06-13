package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.DipendentiDTO;
import it.contrader.model.Dipendenti;

public class ConverterDipendenti {
	public static DipendentiDTO toDTO(Dipendenti dipendenti) {
		DipendentiDTO dipendentiDTO = null;
		
		if (dipendenti != null) {
			dipendentiDTO = new DipendentiDTO();
			dipendentiDTO.setIdDipendente(dipendenti.getIdDipendente());
			dipendentiDTO.setNomeDip(dipendenti.getNomeDip());
			dipendentiDTO.setCognomeDip(dipendenti.getCognomeDip());
		}
		
		return dipendentiDTO;
	}
	 
	public static Dipendenti toEntity(DipendentiDTO dipendentiDTO) {
		Dipendenti dipendenti = null;
		
		if (dipendentiDTO != null) {
			dipendenti = new Dipendenti();
			dipendenti.setIdDipendente(dipendentiDTO.getIdDipendente());
			dipendenti.setNomeDip(dipendentiDTO.getNomeDip());
			dipendenti.setCognomeDip(dipendentiDTO.getCognomeDip());
		}
		
		return dipendenti;	
	}
	
	public static List<DipendentiDTO> toListDTO(List<Dipendenti> list) {
		List<DipendentiDTO> listDipendentiDTO = new ArrayList<>();
		
		if (!list.isEmpty()) {
			for (Dipendenti dipendenti : list) {
				listDipendentiDTO.add(ConverterDipendenti.toDTO(dipendenti));
			}
		}
		
		return listDipendentiDTO;
	}

	public static List<Dipendenti> toListEntity(List<DipendentiDTO> listDipendentiDTO) {
		List<Dipendenti> list = new ArrayList<>();
		
		if (!listDipendentiDTO.isEmpty()) {
			for (DipendentiDTO dipendentiDTO : listDipendentiDTO) {
				list.add(ConverterDipendenti.toEntity(dipendentiDTO));
			}
		}
		
		return list;
	}
}