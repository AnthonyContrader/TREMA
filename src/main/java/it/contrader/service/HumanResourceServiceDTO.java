package it.contrader.service;

import java.util.ArrayList;
import java.util.List;

import it.contrader.converter.HumanResourceConverter;
import it.contrader.dao.*;
import it.contrader.dto.HumanResourceDTO;
import it.contrader.model.*;

public class HumanResourceServiceDTO extends AbstractServiceDTO<HumanResource,HumanResourceDTO>{
	
	public HumanResourceDTO() {
		dao=new HumanResourceDAO();
		converter=new HumanResourceConverter();
	}
}
