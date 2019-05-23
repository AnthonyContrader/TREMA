package it.contrader.view;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.model.HumanResource;

public class HRView extends AbstractView {


	private Request request;
	private String choice;


	@Override
	public void showResults(Request request) {

		if (request != null) {
			int iduser = (int) request.get("iduser");
			System.out.println("\n--------- Gestione dipendenti da parte degli user  " + iduser + " ----------\n");
			System.out.println("idHR\t\tDipendente\tNome\tCognome\tID User ");
			System.out.print("------------------------------------------------------\n");

			List<HumanResource> list = (List<HumanResource>) request.get("listhumanresource");

			for (HumanResource a : list) {
				System.out.println(a);
				System.out.println();
			}
		}
	}

	@Override
	public void showOptions() {
		System.out.println("          Scegli l'operazione da effettuare:");
		System.out.println("[L]eggi [I]nserisci [M]odifica [C]ancella [B]ack [E]sci");
	}

	@Override
	public void submit() {
		try {
			this.choice = getInput();
		} catch(Exception e) {
			this.choice = "";
		}
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "GETCHOICE");
		MainDispatcher.getInstance().callAction("HumanResource", "doControl", this.request);

	}

}
