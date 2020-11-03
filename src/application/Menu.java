package application;

import java.util.List;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;

import dao.CasesDao;
import dao.SwitchesDao;
import entity.Cases;
import entity.Switches;

public class Menu {
	
	private CasesDao CaseDao = new CasesDao();
	private SwitchesDao switchDao = new SwitchesDao();
	
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
			
			try {
				if (selection.equals("1")) {
					displayCases(); 
				} else if (selection.contentEquals("2")) {
					displayCase();
				} else if (selection.contentEquals("3")) {
					createCase();
				} else if (selection.contentEquals("4")) {
					deleteCase();
				} else if (selection.contentEquals("5")) {
					createSwitch();
				} else if (selection.contentEquals("6")) {
					deleteSwitch();
				} 
			} catch (SQLException e) {
				e.printStackTrace();
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
	
	private void displayCases() throws SQLException {
		List<Cases> Cases = CaseDao.getCases();
		System.out.println("\n");
		
		for(Cases cases : Cases) {
			System.out.println(cases.getCaseId() + " : " + cases.getMaterial());
		}
	}
	
	public void displayCase() throws SQLException {
		System.out.println("Enter Case Id: ");
		int id = Integer.parseInt(scanner.nextLine());
		
		Cases cases = CaseDao.getCaseById(id);
		System.out.println(cases.getCaseId() + ": " + cases.getMaterial() + " " + cases.getSizePercentage());
		for (Switches switches : cases.getSwitches()) {
			System.out.println();
		}
	}
	
	public void createCase() throws SQLException {
		System.out.print("Enter new Case Name: ");
		String caseName = scanner.nextLine();
		System.out.print("Enter new Size Percentage: ");
		String sizePercentage = scanner.nextLine();
		
		CaseDao.createNewCase(caseName, sizePercentage);
	}
	
	public void deleteCase() throws SQLException {
		System.out.print("Enter case id to delete: ");
		int id = Integer.parseInt(scanner.nextLine());
		CaseDao.deleteCaseById(id);
	}
 	
	public void createSwitch() throws SQLException {
		System.out.print("Enter Manufacturer name of new Switch: ");
		String manufacturer = scanner.nextLine();
		System.out.print("Enter Terms name of new Switch: ");
		String terms = scanner.nextLine();		
		System.out.print("Enter Switch name of new Switch: ");
		String name = scanner.nextLine();	
		System.out.print("Enter Case Id of new Switch: ");
		int caseId = Integer.parseInt(scanner.nextLine());
		
		switchDao.createNewSwitches(manufacturer, terms, name, caseId);
	}
	
	public void deleteSwitch() throws SQLException {
		System.out.print("Enter Switch Id you'd like to delete: ");
		int id = Integer.parseInt(scanner.nextLine());
		switchDao.deleteSwitchesbySwitchId(id);
	}

}
