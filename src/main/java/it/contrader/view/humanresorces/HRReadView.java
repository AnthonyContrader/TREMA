package it.contrader.view.humanresorces;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.model.HumanResource;
import it.contrader.view.AbstractView;

public class HRReadView extends AbstractView  {

	private int idHR;
	private int idUser;
	private Request request;

	@Override
	public void showResults(Request request) {
		if (request != null) {
			HumanResource HumanResource = (HumanResource) request.get("HumanResource");
			System.out.println(HumanResource);
			MainDispatcher.getInstance().callView("HumanResource", null);
		}

	}

	@Override
	public void showOptions() {
		System.out.println("Inserisci l'ID del dipendente:");
		idHR = Integer.parseInt(getInput());
		System.out.println("Inserisci l'ID dell'User");
		idUser = Integer.parseInt(getInput());

	}

	@Override
	public void submit() {
		request = new Request();
		request.put("idHR", idHR);
		request.put("idUser", idUser);
		request.put("mode", "READ");
		MainDispatcher.getInstance().callAction("HumanResource", "doControl", request);

	}

}
