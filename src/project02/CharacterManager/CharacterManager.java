package project02.CharacterManager;

import project02.MiddleEarthCharacters.MiddleEarthCharacter;

public class CharacterManager {
	private MiddleEarthCharacter[] characters;
	private int size;
	
	public CharacterManager() {
		characters = new MiddleEarthCharacter[2];
		size = 0;
	}
	
	public boolean addCharacter(MiddleEarthCharacter c){
		if (size >= characters.length) { 
	        MiddleEarthCharacter[] newCharacters = new MiddleEarthCharacter[characters.length * 2];
	        for(int i = 0; i < characters.length; i++) {
	        	newCharacters[i] = characters[i];
	        }
	        characters = newCharacters;
	    }
	    characters[size] = c;
	    size++;
	    System.out.println("\nAdded character \"" + c.getName() + "\" successfully!");
	    return true;
	}
	
	public MiddleEarthCharacter getCharacter(String name) {
		System.out.println("\nSearching for character named \"" + name + "\"...");
		for(int i = 0; i < characters.length; i++) {
			if(characters[i] == null) {
				continue;
			}
			if(characters[i].getName().toLowerCase().equals(name.toLowerCase())) {
				System.out.println("Character found!");
				return characters[i];
			}
			
		}
		System.out.println("Character with name \"" + name + "\" not found.");
		return null;
	}
	
	public boolean updateCharacter(MiddleEarthCharacter character, String name, int health, int power) {
		for(int i = 0; i < characters.length; i++) {
			if(characters[i] == null) {
				continue;
			}
			if(character.equals(characters[i])) {
				System.out.println("\nUpdating character: ");
				characters[i].displayInfo();
				characters[i].setName(name);
				characters[i].setHealth(health);
				characters[i].setPower(power);
				System.out.println("Character after update: ");
				characters[i].displayInfo();
				return true;
			}
		}
		System.out.println("Character not found.");
		return false;
	}
	
	public boolean deleteCharacter(MiddleEarthCharacter character) {
		for(int i = 0; i < characters.length; i++) {
			if(characters[i] == null) {
				continue;
			}
			if(characters[i] == character) {
				
				for(int x = i; x < size - 1; x++) {
					characters[x] = characters[x + 1];
				}
				characters[size-1] = null;
				size--;
				System.out.println("\nCharacter named \"" + character.getName() + "\" deleted successfully.");
				return true;
			}
		}
		System.out.println("\nCharacter not found.");
		return false;
	}
	
	public void displayAllCharacters() {
		System.out.println("\nPrinting all character info...");
		for(int i = 0; i < characters.length; i++) {
			if(characters[i] == null) {
				continue;
			}
			if(characters[i] != null) {
				characters[i].displayInfo();
			}
			
		}
	}
}
