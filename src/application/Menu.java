package application;

import java.util.List;
import java.util.Arrays;
import java.util.Scanner;

public class Menu {
	
	private Scanner scanner = new Scanner(System.in);
	private List<String> options = Arrays.asList(
			"Display Cases",
			"Display a Case",
			"Create Case",
			"Delete Case",
			"Create Case Switch",
			"Delete Case Switch");
	
	public void start() {
		String selection = "";
		
		do {
			printMenu();
			selection = scanner.nextLine();
			
			if (selection.equals("1")) {
				//displayCases(); 
			} else if (selection.contentEquals("2")) {
				//displayCase();
			} else if (selection.contentEquals("3")) {
				//createCase();
			} else if (selection.contentEquals("4")) {
				//deleteCase();
			} else if (selection.contentEquals("5")) {
				//createSwitch();
			} else if (selection.contentEquals("5")) {
				//deleteSwitch();
			} 
			
			System.out.println("Press enter to continue...");
			scanner.hasNextLine();
		} while (!selection.equals("-1"));
	}
	
	private void printMenu() {
		System.out.println("Select an Option:\n--------------------");
		for (int i = 0; i < options.size(); i++) {
			System.out.println(i + 1 + ") " + options.get(i));
		}
	}

}
