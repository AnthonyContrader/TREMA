package it.contrader.main;
import java.util.*;

public class Application {

    public static void main(String[] args) {
        MainDispatcher.getInstance().callAction("Login", "doControl", null);
       
        inserimento inserimento=new inserimento(); 
        ricerca ricerca=new ricerca();
        cancella cancella=new cancella();
                
        Scanner input = new Scanner(System.in);

        int a=0;
        String test;
        
        System.out.println("Benvenuto in TREMA!!\n");
        do {
        	System.out.println("Premi:\n-1 per inserire i dati\n-2 per la ricerca\n-3 per cancellare\n-4 per uscire\n");
        	test=input.nextLine();
        	a=Integer.parseInt(test);
        	switch(a) {
        						case 1:	 	System.out.println("-Inserisci 1 per inserire in HR\n-Inserisci 2 per inserire MR\n");
        									test=input.nextLine();
        									a=Integer.parseInt(test);
        									if(a==1) {
        													inserimento.inserimento_HR();  //eseguo l'inserimento in db di hr
        									}else if(a!=1 && a!=2){
        													System.out.println("ERRORE!! Inserisci un valore valido!!");
        									}else{
        													inserimento.inserimento_MR(); //eseguo l'inserimento in db di mr
        									}
        							break;
        						case 2:		System.out.println("-Inserisci 1 per ricercare HR\n-Inserisci 2 per ricercare MR\n");
			        						test=input.nextLine();
											a=Integer.parseInt(test);
											if(a==1) {
															ricerca.ricerca_HR();		//eseguo la ricerca in db di hr
											}else if(a!=1 && a!=2){
															System.out.println("ERRORE!! Inserisci un valore valido!!\n");
											}else{
															ricerca.ricerca_MR();		//eseguo la ricerca in db di mr
											}
        							break;
        						case 3:		System.out.println("-Inserisci 1 per cancellare HR\n-Inserisci 2 per cancellare MR\n");
			        						test=input.nextLine();
											a=Integer.parseInt(test);
											if(a==1) {
															cancella.cancella_HR();		//eseguo la cancellazione in db di hr
											}else if(a!=1 && a!=2){
															System.out.println("ERRORE!! Inserisci un valore valido!!\n");
											}else{
															cancella.cancella_MR();		//eseguo la cancellazione in db di mr
											}
        							break;
        						case 4: 	a=70;  // per uscire
        							break;
        	}
        	
        }while(a!=70);  //il menù si ripete finchè non setto a=70(scegliendo l'opzione 4)
        System.out.println("Bye bye\n");
    }

}
