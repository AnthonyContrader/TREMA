package it.contrader.main;
import java.util.*;

public class Application {

    public static void main(String[] args) {
        MainDispatcher.getInstance().callAction("Login", "doControl", null);
        
        persona p=new persona();
        materiale m=new materiale();
        
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();

        int a=0;
        String test;
        
        System.out.println("Benvenuto in TREMA!!");
        do {
        	System.out.println("Possibile menù...");
        	test=input.nextLine();
        	a=Integer.parseInt(test);
        	switch(a) {
        						case 1:
        							break;
        						case 2:
        							break;
        	}
        	
        }while(a!=70);
       
    }

}
