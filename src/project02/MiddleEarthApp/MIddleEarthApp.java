package project02.MiddleEarthApp;

import java.util.Scanner;

import project02.CharacterManager.CharacterManager;
import project02.CharacterManager.MiddleEarthCouncil;
import project02.MiddleEarthCharacters.Dwarf;
import project02.MiddleEarthCharacters.Elf;
import project02.MiddleEarthCharacters.Human;
import project02.MiddleEarthCharacters.Orc;
import project02.MiddleEarthCharacters.Wizard;

/**
 * Main application class for managing Middle Earth characters.
 * Initializes default characters and starts the menu system.
 */
public class MIddleEarthApp {

	/**
     * The main method initializes the program by creating characters,
     * adding them to the CharacterManager, and starting the menu.
     * 
     * @param args Command-line arguments.
     */
	public static void main(String[] args) {
		Orc orc1 = new Orc("Gary", 100, 10);
		Orc orc2 = new Orc("Gerald", 100, 10);
		Elf elf1 = new Elf("James", 100, 10);
		Elf elf2 = new Elf("Jerry", 100, 10);
		Dwarf dwarf1 = new Dwarf("Henry", 100, 10);
		Dwarf dwarf2 = new Dwarf("Harold", 100, 10);
		Wizard wizard1 = new Wizard("Bart", 100, 10);	
		Wizard wizard2 = new Wizard("Barry", 100, 10);
		Human human1 = new Human("Jerry", 100, 10);
		Human human2 = new Human("Jeremy", 100, 10);
		
		MiddleEarthCouncil instance = MiddleEarthCouncil.getInstance();
		CharacterManager characterManager = instance.getCharacterManager();
		
		
		characterManager.addCharacter(orc1);
		characterManager.addCharacter(orc2);
		characterManager.addCharacter(elf1);
		characterManager.addCharacter(elf2);
		characterManager.addCharacter(dwarf1);
		characterManager.addCharacter(dwarf2);
		characterManager.addCharacter(wizard1);
		characterManager.addCharacter(wizard2);
		characterManager.addCharacter(human1);
		characterManager.addCharacter(human2);
		
	
		characterManager.displayAllCharacters();
		
		Scanner scanner = new Scanner(System.in);
		Menu.displayMenu(scanner);
		
	}

}
