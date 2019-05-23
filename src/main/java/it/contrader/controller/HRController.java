package it.contrader.controller;

import java.util.List;
import it.contrader.main.MainDispatcher;
import it.contrader.model.*;
import it.contrader.service.*;

public class HRController implements Controller {
	private static String sub_package = "humanresources";
	private HRService hrService;

	public HRController() {
		this.hrService = new HRService();
	}

	@Override
	public void doControl(Request request) {
		String mode = (String) request.get("mode");
		String choice = (String) request.get("choice");

		int id;
		int userId;
		String name;
		String surname;

		switch (mode) {
		case "READ":
				id=Integer.parseInt(request.get("id").toString());	
				
		 
		}

	}

}
