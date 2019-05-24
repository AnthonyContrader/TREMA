package it.contrader.view.humanresorces;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class HRUpdateView extends AbstractView {
	
	private int idHRtoupdate;
	private String nametoupdate;
	private String surnametoupdate;
	private int idusertoupdate;
	private Request request;
	
	@Override
	public void showResults(Request request) {

		if (request!=null) {
			System.out.println("La modifica è andata a buon fine.\n");
			MainDispatcher.getInstance().callView("HumanResource", null);
		}
	}

	@Override
	public void showOptions() {
		System.out.println("Inserire l'ID del dipendente da modificare:");
		idHRtoupdate=Integer.parseInt(getInput().toString());
		System.out.println("Inserire il nuovo nome:");
		nametoupdate=getInput().toString();
		System.out.println("Inserire il nuovo cognome:");
		surnametoupdate=getInput().toString();
		System.out.println("Inserire il nuovo User ID");
		idusertoupdate=Integer.parseInt(getInput().toString());

	}

	@Override
	public void submit() {
		request = new Request();
		request.put("idHR", idHRtoupdate);
		request.put("name", nametoupdate);
		request.put("surname", surnametoupdate);
		request.put("iduser", idusertoupdate);
		request.put("mode", "UPDATE");
		MainDispatcher.getInstance().callAction("HumanResource", "doControl", request);


	}

}
