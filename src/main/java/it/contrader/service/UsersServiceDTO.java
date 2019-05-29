package it.contrader.service;

import it.contrader.model.*;
import it.contrader.dto.*;
import it.contrader.dao.*;
import it.contrader.converter.*;

public class UsersServiceDTO extends AbstractServiceDTO<Users,UsersDTO> {
	
	public UsersServiceDTO() {
		dao = new UsersDAO();
		converter = new UsersConverter();
	}
}
