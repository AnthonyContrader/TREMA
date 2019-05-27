package it.contrader.view;

import java.util.*;
import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.model.Material;

public class MaterialView extends AbstractView {
	
	private Request request;
	private String choice;

	@Override
	public void showResults(Request request) {

		if(request!= null) {
			System.out.println("\n-------------------- Gestione dei materiali --------------------");
			System.out.println("ID\tTipo\t\tquantita\tIdHR");
			System.out.print("-----------------------------------------------------------------\n");

			List<Material> materials = (List<Material>) request.get("material");
			System.out.println();

			for (Material x : materials) {
				System.out.println(x);
				System.out.println();
			}
		}
	}

	@Override
	public void showOptions() {
		System.out.println("Scegli l'operazione da effettuare:");
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
		MainDispatcher.getInstance().callAction("Material", "doControl", this.request);
	}


}