package ui;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import model.*;


public class Main {

	private VolleyballCup vc;
	private Scanner input;
	
	public Main() {
		vc = new VolleyballCup("IV Copa Panamericana de Voleibol Masculino Sub-21", "mayo de 2019", "lima");
		input = new Scanner(System.in);
	}
	
	
	public static void main(String[] args) throws IOException {
		Main m = new Main();
		m.menu();
	}
	
	public void menu() throws IOException {
		vc.loadInformation("data/1.csv");
		System.out.println("\n-------------------------------------------------------------------------- \n");
		System.out.println("\n<--------------------------------->MENU<---------------------------------> \n");
		System.out.println("\n-------------------------------------------------------------------------- \n");
		System.out.println("1- search participant");
		System.out.println("2- search spectator");
		System.out.println("3- estructura de arbol");
		System.out.println("4- estructura de lista");
		System.out.println("5- EXIT");
		System.out.println("\n-------------------------------------------------------------------------- \n");

		int op = input.nextInt();
		input.nextLine();
		
		if(op == 1) {
			op1();
		}else if(op == 2) {
			op2();
		}else if(op == 3) {
			op3();
		}else if(op == 4) {
			op4();
		}else if(op == 5) {
			System.out.println("\n--------------------------------------------------------------------------- ");
			System.out.println("<----------------------THANKS----------------------->");
			System.out.println("--------------------------------------------------------------------------- ");
			System.exit(0);
		}
	}
	
	public void op1() throws IOException {
		long time = System.currentTimeMillis();
		System.out.println("Enter the partisipan's id");
		String id = input.nextLine();
		model.Person p = vc.searchParticipantById(id);
		if(p != null) {
			System.out.println(vc.toString());
		}else {
			System.out.println("the value does not exist");
		}
		
		time = (System.currentTimeMillis()-time)/1000;
		
		 toContinue();
	}
	
	public void op2() throws IOException {
		long time = System.currentTimeMillis();
		System.out.println("Enter the spectator id");
		String id = input.nextLine();
		model.Person p = vc.searchPersonById(id);
		if(p != null) {
			System.out.println(vc.toString());
		}else {
			System.out.println("the value does not exist");
		}
		
		time = (System.currentTimeMillis()-time)/1000;
		
		 toContinue();
	}
	
	public void op3() throws IOException {
		List<String> countries = vc.getParticipantCountries();
		for(int i = 0; i < countries.size()-1; i++) {
			System.out.println(countries.get(i)+"\n");
			i++;
		}
		System.out.println("Chose one countrie");
		String co = input.nextLine();
		
		System.out.println("no se que pasa, segun yo, eso deberia imprimir el arbol");
		
		//System.out.println(vc.printBinaryTree(vc.getRootSpectator(), 0, co));
		
		
		 toContinue();
	}
	
	public void op4() {
			
		}
	
	public void toContinue() throws IOException {
		System.out.println("\n--------------------------------------------------------------------------- ");
		System.out.println("1. MENU \n 2. EXIT");
		
		int what = input.nextInt();
		input.nextLine();
			if(what == 1){
				menu();
			}else{
				System.out.println("\n--------------------------------------------------------------------------- ");
				System.out.println("<----------------------THANKS----------------------->");
				System.out.println("--------------------------------------------------------------------------- ");
				System.exit(0);
				
			}
	}


}
