package it.contrader.service;
import it.contrader.converter.*;
import it.contrader.dao.*;
import it.contrader.dto.*;
import it.contrader.model.*;

public class HumanResourceServiceDTO extends AbstractServiceDTO<HumanResource,HumanResourceDTO>{
	
	public HumanResourceServiceDTO() {
		dao = new HumanResourceDAO();
		converter = new HumanResourceConverter();
	}
}
