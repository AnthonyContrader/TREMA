package it.contrader.view.humanresorces;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class HRDeleteView extends AbstractView {

	private int idHR;
	private Request request;
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("La cancellazione è andata a buon fine.\n");
			MainDispatcher.getInstance().callView("HumanResource", null);
		}
	}

	@Override
	public void showOptions() {

		System.out.print("Inserire l'ID della HR da eliminare:\n");
		idHR=Integer.parseInt(getInput());

	}

	@Override
	public void submit() {
		request = new Request();
		request.put("mode","DELETE" );
		request.put("idHR", idHR);
		MainDispatcher.getInstance().callAction("HumanResource", "doControl", request);
	}

}
