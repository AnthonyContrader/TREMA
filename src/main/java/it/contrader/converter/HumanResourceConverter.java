package it.contrader.converter;

import it.contrader.dto.*;
import it.contrader.model.*;
public class HumanResourceConverter {
	
	public static HumanResource toEntity(HumanResourceDTO hrdto) {

		HumanResource hr = null;
		if (hrdto != null) {
			Users user = UsersConverter.toEntity(hrdto.getUserDTO());
			hr = new HumanResource(user, hrdto.getName());
			hr.setId(hrdto.getId());
		}
		return hr;
	}

	
	public static HumanResourceDTO toDTO(HumanResource hr) {

		HumanResourceDTO hrdto  = null;
		if (hr != null) {
			UsersDTO userDTO = UsersConverter.toDTO(hr.getUser());
			hrdto = new HumanResourceDTO(userDTO, hr.getName(), hr.getSurname());
			hrdto.setId(hr.getId());
		}

		
		return hrdto;
	}
	

}
