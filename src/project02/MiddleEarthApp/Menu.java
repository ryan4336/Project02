package project02.MiddleEarthApp;

import java.util.Scanner;

import project02.CharacterManager.CharacterManager;
import project02.CharacterManager.MiddleEarthCouncil;
import project02.MiddleEarthCharacters.Dwarf;
import project02.MiddleEarthCharacters.Elf;
import project02.MiddleEarthCharacters.Human;
import project02.MiddleEarthCharacters.MiddleEarthCharacter;
import project02.MiddleEarthCharacters.Orc;
import project02.MiddleEarthCharacters.Wizard;

public class Menu {
	
	public static void displayMenu(Scanner scanner) {
		System.out.println("\nWhat would you like to do?\n-----------------------\n");
		System.out.println("1. Add a new character.");
		System.out.println("2. View all characters.");
		System.out.println("3. Update a character.");
		System.out.println("4. Delete a character.");
		System.out.println("5. Execute all characters' attack actions.");
		System.out.println("6. Exit.");
		
		int userChoice;
		
		
		while(true) {
			System.out.println("\nPlease enter a number (1-6): ");

			try {
				userChoice = scanner.nextInt();
				scanner.nextLine();
				break;
			}catch(Exception e){
				System.out.println("Error: Must enter an integer.");
				scanner.nextLine();
				continue;
			}
		}
		
		
		
		switch(userChoice) {
			case 1:
				Menu.addCharacter(scanner);
				break;
			case 2:
				Menu.viewCharacters(scanner);
				break;
			case 3:
				Menu.updateCharacter(scanner);
				break;
			case 4:
				
				break;
			case 5:
				
				break;
			case 6:
				
				System.out.println("\nExiting program...");
				scanner.close();
				System.exit(0);
				
		}
		
	}
	
	
	private static void addCharacter(Scanner scanner) {
		
		String name;
		int health;
		int power;
		
		System.out.println("Enter the new character's name: ");
		name = scanner.nextLine();
		
		System.out.println("Enter the new character's health: ");
		while(!scanner.hasNextInt()) {
			System.out.println("Error: Must enter an integer value.");
			scanner.next();
		}
		health = scanner.nextInt();
		scanner.nextLine();
		
		
		System.out.println("Enter the new character's power: ");
		while(!scanner.hasNextInt()) {
			System.out.println("Error: Must enter an integer value.");
			scanner.next();
		}
		power = scanner.nextInt();
		scanner.nextLine();
		
		String race;
		while(true) {
			System.out.println("Enter the new character's race: ");
			race = scanner.nextLine().toLowerCase();
			
			
			if(!race.equals("elf") && !race.equals("dwarf") && !race.equals("wizard") && !race.equals("orc") && !race.equals("human")) {
				System.out.println("ERROR: Race \"" + race + "\" not available. Please choose Elf, Orc, Wizard, Human, or Dwarf.");
				continue;	
			}
			break;
		}
					
			
		
		
		MiddleEarthCouncil instance = MiddleEarthCouncil.getInstance();
		CharacterManager characterManager = instance.getCharacterManager();
		
		switch(race) {
		case "orc":
			Orc newOrc = new Orc(name, health, power);
			characterManager.addCharacter(newOrc);
			break;
		case "elf":
			Elf newElf = new Elf(name, health, power);
			characterManager.addCharacter(newElf);
			break;
		case "dwarf":
			Dwarf newDwarf = new Dwarf(name, health, power);
			characterManager.addCharacter(newDwarf);
			break;
		case "human":
			Human newHuman = new Human(name, health, power);
			characterManager.addCharacter(newHuman);
			break;
		case "wizard":
			Wizard newWizard = new Wizard(name, health, power);
			characterManager.addCharacter(newWizard);
			break;
			
		}
		Menu.displayMenu(scanner);
	}
	
	
	public static void viewCharacters(Scanner scanner) {
		MiddleEarthCouncil instance = MiddleEarthCouncil.getInstance();
		CharacterManager characterManager = instance.getCharacterManager();
		
		characterManager.displayAllCharacters();
		
		Menu.displayMenu(scanner);
	}
	
	public static void updateCharacter(Scanner scanner) {
		MiddleEarthCouncil instance = MiddleEarthCouncil.getInstance();
		CharacterManager characterManager = instance.getCharacterManager();
		
		String name;
		String newName;
		int health;
		int power;
		
		System.out.println("Enter the name of the character you want to update: ");
		name = scanner.nextLine();
		
		MiddleEarthCharacter characterToUpdate = characterManager.getCharacter(name);
		if(characterToUpdate == null) {
			System.out.println("Returning to menu...");
			Menu.displayMenu(scanner);
		}
		
		System.out.println("Enter the character's new name: ");
		newName = scanner.nextLine();
		
		System.out.println("Enter the character's new health: ");
		while(!scanner.hasNextInt()) {
			System.out.println("Error: Must enter an integer value.");
			scanner.next();
		}
		health = scanner.nextInt();
		scanner.nextLine();
		
		
		System.out.println("Enter the character's new power: ");
		while(!scanner.hasNextInt()) {
			System.out.println("Error: Must enter an integer value.");
			scanner.next();
		}
		power = scanner.nextInt();
		scanner.nextLine();
		
		characterManager.updateCharacter(characterToUpdate, newName, health, power);
		Menu.displayMenu(scanner);
	}
	
}
