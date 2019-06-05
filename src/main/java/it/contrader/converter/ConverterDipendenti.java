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
				dipendentiDTO.setTaskDTO(ConverterTask.toDTO(dipendenti.getTask()));
				
				dipendentiDTO.setName(dipendenti.getName());
				
				dipendentiDTO.setSurname(dipendenti.getSurname());

				dipendentiDTO.setIdDipendente(dipendenti.getIdDipendente());		
			}
		
		return dipendentiDTO;
	}
	 
	public static Dipendenti toEntity(DipendentiDTO dipendentiDTO) {
		
		Dipendenti dipendenti = null;
		
		if (dipendentiDTO != null) {
			dipendenti = new Dipendenti(0, null, null, null);
			dipendenti.setTask(ConverterTask.toEntity(dipendentiDTO.getTaskDTO()));

			dipendenti.setIdDipendente(dipendentiDTO.getIdDipendente());
			dipendenti.setName(dipendentiDTO.getName());
			dipendenti.setSurname(dipendentiDTO.getSurname());			
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