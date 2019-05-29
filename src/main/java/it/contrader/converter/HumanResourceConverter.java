package it.contrader.converter;

import it.contrader.dto.*;
import it.contrader.model.*;

public class HumanResourceConverter implements Converter<HumanResource, HumanResourceDTO>{
		public HumanResource toEntity(HumanResourceDTO hrDTO) {
			HumanResource hr=null;
			
			if(hrDTO!=null) {
				hr=new HumanResource(hrDTO.getIdHR(), hrDTO.getName(), hrDTO.getSurname(), hrDTO.getIduser());;
			}				
			return hr;
		}
		
		public HumanResourceDTO toDTO(HumanResource hr) {
			HumanResourceDTO hrDTO=null;
			if(hr!=null) {
				hrDTO=new HumanResourceDTO(hr.getIdHR(), hr.getName(), hr.getSurname(), hr.getIduser());
			}
			return hrDTO;
		}
}
