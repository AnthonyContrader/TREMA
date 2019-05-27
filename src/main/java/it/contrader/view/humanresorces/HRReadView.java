package it.contrader.view.humanresorces;

import it.contrader.controller.*;
import it.contrader.main.MainDispatcher;
import it.contrader.model.HumanResource;
import it.contrader.view.AbstractView;
import it.contrader.controller.Request;

public class HRReadView extends AbstractView  {

	private int idHR;
	private Request request;
	private final String mode = "READ";
	
	public HRReadView() {
		new HumanResourceController();
	}
	
	@Override
	public void showResults(Request request) {
		if (request != null) {
			HumanResource hr = (HumanResource) request.get("humanresource");
			System.out.println(hr);
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
