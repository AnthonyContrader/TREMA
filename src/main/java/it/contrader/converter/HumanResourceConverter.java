package it.contrader.converter;

import it.contrader.dto.HumanResourceDTO;
import it.contrader.dto.UsersDTO;
import it.contrader.model.HumanResource;
import it.contrader.model.Users;

public class HumanResourceConverter {
	
	public static HumanResource toEntity(HumanResource humanResource) {

		HumanResource hr = null;
		if (humanResource != null) {
			Users user = UsersConverter.toEntity(humanResource.getUserDTO());
			hr = new HumanResource(humanResource.getName(), humanResource.getSurname(), user);
			hr.setId(humanResource.getId());
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
