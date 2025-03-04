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

/**
 * Provides a user interface for managing Middle Earth characters.
 * Allows adding, updating, deleting, and viewing characters, as well as executing attacks.
 */
public class Menu {
	
	/**
     * Displays the main menu, processes user input, and calls a method based on the input.
     * 
     * @param scanner Scanner object for user input.
     */
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
				Menu.deleteCharacter(scanner);
				break;
			case 5:
				Menu.attack(scanner);
				break;
			case 6:
				
				System.out.println("\nExiting program...");
				scanner.close();
				System.exit(0);
				
		}
		
	}
	
	/**
     * Adds a new character based on user input.
     * 
     * @param scanner Scanner object for user input.
     */
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
		return;
	}
	
	/**
     * Displays all characters in the CharacterManager.
     * 
     * @param scanner Scanner object for user input.
     */
	public static void viewCharacters(Scanner scanner) {
		MiddleEarthCouncil instance = MiddleEarthCouncil.getInstance();
		CharacterManager characterManager = instance.getCharacterManager();
		
		characterManager.displayAllCharacters();
		
		Menu.displayMenu(scanner);
		return;
	}
	
	/**
     * Updates an existing character's information using a name given by the user.
     * 
     * @param scanner Scanner object for user input.
     */
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
			return;
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
		return;
	}
	
	/**
     * Deletes a character based on a name of a character given by user input.
     * 
     * @param scanner Scanner object for user input.
     */
	public static void deleteCharacter(Scanner scanner) {
		MiddleEarthCouncil instance = MiddleEarthCouncil.getInstance();
		CharacterManager characterManager = instance.getCharacterManager();
		
		String name;
		
		System.out.println("Enter the name of the character you want to delete: ");
		name = scanner.nextLine();
		
		MiddleEarthCharacter characterToDelete = characterManager.getCharacter(name);
		if(characterToDelete == null) {
			System.out.println("\nReturning to menu...");
			Menu.displayMenu(scanner);
			return;
		}
		
		characterManager.deleteCharacter(characterToDelete);
		
		Menu.displayMenu(scanner);
	}
	
	/**
     * Executes an attack action between two characters given by the user.
     * 
     * @param scanner Scanner object for user input.
     */
	public static void attack(Scanner scanner) {
		MiddleEarthCouncil instance = MiddleEarthCouncil.getInstance();
		CharacterManager characterManager = instance.getCharacterManager();
		String attackerName;
		String victimName;
		
		System.out.println("Enter the name of the character that you will be attacking as: ");
		attackerName = scanner.nextLine();
		
		MiddleEarthCharacter attacker = characterManager.getCharacter(attackerName);
		if(attacker == null) {
			System.out.println("\nReturning to menu...");
			Menu.displayMenu(scanner);
			return;
		}
		
		System.out.println("Enter the name of the character that you will be attacking: ");
		victimName = scanner.nextLine();
		
		MiddleEarthCharacter victim = characterManager.getCharacter(victimName);
		if(victim == null) {
			System.out.println("\nReturning to menu...");
			Menu.displayMenu(scanner);
			return;
		}
		if(victim.equals(attacker)) {
			System.out.println("ERROR: You may not attack yourself.");
			System.out.println("\nReturning to menu...");
			Menu.displayMenu(scanner);
			return;
		}
		
		attacker.attack(victim);
		Menu.displayMenu(scanner);
	}
	
}
