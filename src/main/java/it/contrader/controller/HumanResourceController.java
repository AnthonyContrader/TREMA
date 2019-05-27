package it.contrader.controller;

import java.util.List;

import it.contrader.main.MainDispatcher;
import it.contrader.controller.Controller;
import it.contrader.controller.Request;
import it.contrader.model.*;
import it.contrader.service.*;

public class HumanResourceController implements Controller{
		

	private static String sub_package = "humanresorces.";
	private HRService hrService;

	public HumanResourceController() {
		this.hrService = new HRService();
	}

  
	@Override
	public void doControl(Request request) {
		String mode = (String) request.get("mode");
		String choice = (String) request.get("choice");

		int idHr = 0;
		String name;
		String surname;
		int idUser;

		switch (mode) {
		case "READ":
			idHr = Integer.parseInt(request.get("idHR").toString());
			HumanResource hr = hrService.readHR(idHr);
			request.put("humanresource", hr);
			MainDispatcher.getInstance().callView(sub_package + "HRRead", request);
			break;
		case "INSERT":
			name  = request.get("name").toString();
			surname = request.get("surname").toString();
			idHr = Integer.parseInt(request.get("idHR").toString());
			idUser = Integer.parseInt(request.get("iduser").toString());
			hrService.insertHR(idHr, name, surname, idUser);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "HRInsert", request);
			break;
		case "DELETE":
			idHr = Integer.parseInt(request.get("idHR").toString());
			hrService.deleteHR(idHr);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "HRDelete", request);
			break;
		case "UPDATE":
			name  = request.get("name").toString();
			surname = request.get("surname").toString();
			idHr = Integer.parseInt(request.get("idHR").toString());
			idUser = Integer.parseInt(request.get("iduser").toString());
			hrService.updateHR(idHr, name, surname, idUser);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "HRUpdate", request);
			break;
		case "HumanResource":
			//MainDispatcher.getInstance().callView("User", null);
			List<HumanResource> hrl = hrService.getAllHR();
			request.put("humanresource", hrl);
			MainDispatcher.getInstance().callView("HumanResource", request);
			break;

		case "GETCHOICE":

			switch (choice.toUpperCase()) {
			case "L":
				MainDispatcher.getInstance().callView(sub_package + "HRRead", null);
				break;
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "HRInsert", null);
				break;
			case "M":
				MainDispatcher.getInstance().callView(sub_package + "HRUpdate", null);
				break;
			case "C":
				MainDispatcher.getInstance().callView(sub_package + "HRDelete", null);
				break;
			case "E":
				MainDispatcher.getInstance().callView("Login", null);
				break;
			case "B":
				MainDispatcher.getInstance().callView("HomeUser", null);
				break;
			default:
				MainDispatcher.getInstance().callView("Login", null);
			}
		default:
			MainDispatcher.getInstance().callView("Login", null);
		}
	}
}
