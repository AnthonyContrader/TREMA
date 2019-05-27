package it.contrader.view.humanresorces;

import it.contrader.controller.*;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class HRInsertView extends AbstractView {

	private Request request;
	private String name;
	private String surname;
	private int iduser;
	private int idhr;

	private  final String mode = "INSERT";

	public HRInsertView() {
		new HumanResourceController();
	}

	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("L'inserimento e' andato a buon fine.\n");
			MainDispatcher.getInstance().callView("HumanResource", null);
		}
	}

	@Override 
	public void showOptions() {
		try {
			System.out.println("Inserisci l'ID dell'hr");
			idhr = Integer.parseInt(getInput());
			System.out.println("Inserisci l'ID dell'User");
			iduser = Integer.parseInt(getInput());
			System.out.println("Inserisci il nome del dipendente");
			name= getInput();
			System.out.println("Inserisci il cognome del dipendente");
			surname= getInput();
		} catch (Exception e) {

		}
	}

	@Override
	public void submit() {
		request = new Request();
		request.put("idHR", idhr);
		request.put("name", name);
		request.put("surname", surname);
		request.put("iduser", iduser);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("HumanResource", "doControl", request);
	}

}

