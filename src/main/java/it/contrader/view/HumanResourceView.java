package it.contrader.view;

import java.util.List;
import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.model.*;

public class HumanResourceView extends AbstractView {

	private Request request;
	private String choice;
	
	public HumanResourceView() {
	}
	
	@Override
	public void showResults(Request request) {

		if (request != null) {
			System.out.println("\n--------- Gestione dipendenti da parte degli user: ----------\n");
			System.out.println("IDHR\tNome\t\tCognome\t\tID User ");
			System.out.print("-------------------------------------------------------------\n");

			List<HumanResource> hrs = (List<HumanResource>) request.get("humanresource");
			System.out.println();
			
			for (HumanResource x : hrs) {
				System.out.println(x);
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