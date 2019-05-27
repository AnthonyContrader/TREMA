package it.contrader.view.humanresorces;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class HRUpdateView extends AbstractView {
	
	private int idHR;
	private String name;
	private String surname;
	private int iduser;
	private Request request;
	
	public HRUpdateView() {}
	
	@Override
	public void showResults(Request request) {

		if (request!=null) {
			System.out.println("La modifica e' andata a buon fine.\n");
			MainDispatcher.getInstance().callView("HumanResource", null);
		}
	}

	@Override
	public void showOptions() {
		System.out.println("Inserire l'ID del dipendente da modificare:");
		idHR=Integer.parseInt(getInput().toString());
		System.out.println("Inserire il nuovo nome:");
		name=getInput().toString();
		System.out.println("Inserire il nuovo cognome:");
		surname=getInput().toString();
		System.out.println("Inserire il nuovo User ID");
		iduser=Integer.parseInt(getInput().toString());

	}

	@Override
	public void submit() {
		request = new Request();
		request.put("idHR", idHR);
		request.put("name", name);
		request.put("surname", surname);
		request.put("iduser", iduser);
		request.put("mode", "UPDATE");
		MainDispatcher.getInstance().callAction("HumanResource", "doControl", request);


	}

}
