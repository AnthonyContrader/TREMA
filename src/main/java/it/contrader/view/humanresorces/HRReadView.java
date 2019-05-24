package it.contrader.view.humanresorces;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.model.HumanResource;
import it.contrader.view.AbstractView;

public class HRReadView extends AbstractView  {

	private int idHR;
	private Request request;
	
	private final String mode = "READ";
	
	@Override
	public void showResults(Request request) {
		if (request != null) {
			HumanResource HumanResource = (HumanResource) request.get("idHR");
			System.out.println(HumanResource);
			MainDispatcher.getInstance().callView("HumanResource", null);
		}
	}

	@Override
	public void showOptions() {
		System.out.println("Inserisci l'ID del dipendente:");
		idHR = Integer.parseInt(getInput());
	}

	@Override
	public void submit() {
		request = new Request();
		request.put("idHR", idHR);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("HumanResource", "doControl", request);

	}

}
