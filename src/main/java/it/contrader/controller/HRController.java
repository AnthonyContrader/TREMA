package it.contrader.controller;

import java.util.List;
import it.contrader.main.MainDispatcher;
import it.contrader.model.*;
import it.contrader.service.*;

public class HRController implements Controller {
	private static String sub_package = "humanresource.";

	private HRService HrService;//

	public HRController() {
		this.HrService = new HRService();
	}


	@Override
	public void doControl(Request request) {

		String mode = (String) request.get("mode");
		String choice = (String) request.get("choice");

		int id = 0;
		String name;//
		String surname;//
		int userid;//
		HumanResource hr = null;//
		
		switch (mode) {
		case "READ":
			id = Integer.parseInt(request.get("id").toString());
			HrService = HrService.readHR(id);
			request.put("humanresource", hr);
			MainDispatcher.getInstance().callView(sub_package + "HrRead", request);
			break;
		case "INSERT":
			name = request.get("name").toString();
			surname = request.get("surname").toString();
			userid = Integer.parseInt(request.get("id").toString());
			hr = new HumanResource(id, userid, name, surname);
			boolean result=HrService.insertHR(hr);
			request.put("result", result);
			MainDispatcher.getInstance().callView(sub_package + "HRInsert", request);
			break;
		case "DELETE":
			id = Integer.parseInt(request.get("id").toString());
			HrService.deleteHR(id);
			request = new Request();
			request.put("mode", "ok");
			MainDispatcher.getInstance().callView(sub_package + "HRDelete", request);
			break;
		case "UPDATE":
			id = Integer.parseInt(request.get("id").toString());
			name = request.get("name").toString();
			surname = request.get("surname").toString();
			userid = Integer.parseInt(request.get("userid").toString());
			hr = new HumanResource(id, userid, name, surname);
			hr.setidHR(id);
			HrService.updateHR(hr);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "HRUpdate", request);
			break;
		case "HumanResource":
			List<HumanResource> humanr =HrService.getAllHR();
			request = new Request();
			request.put("humanresources", humanr);
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
				MainDispatcher.getInstance().callView("HomeAdmin", null);
				break;
			default:
				MainDispatcher.getInstance().callView("Login", null);
			}
		default:
			System.out.println("controller default \n");
			MainDispatcher.getInstance().callView("Login", request);
		}

	}

}
