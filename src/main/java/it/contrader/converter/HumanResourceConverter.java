package it.contrader.converter;

import it.contrader.dto.HumanResourceDTO;
import it.contrader.dto.UsersDTO;
import it.contrader.model.HumanResource;
import it.contrader.model.Users;

public class HumanResourceConverter {
	
	public static HumanResource toEntity(HumanResourceDTO hrdto) {

		HumanResource hr = null;
		if (hrdto != null) {
			Users user = UsersConverter.toEntity(hrdto.getUserDTO());
			hr = new HumanResource(hrdto.getName(), hrdto.getSurname(),user);
			hr.setId(hrdto.getId());
		}
		return hr;
	}

	
	public static HumanResourceDTO toDTO(HumanResource hr) {

		HumanResourceDTO hrdto  = null;
		if (hr != null) {
			UsersDTO userDTO = UsersConverter.toDTO(hr.getUser());
			hrdto = new HumanResourceDTO(hr.getName(), hr.getSurname(), userDTO);
			hrdto.setId(hr.getId());
		}

		
		return hrdto;
	}
	

}
