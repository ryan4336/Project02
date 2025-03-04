package project02.CharacterManager;

import project02.MiddleEarthCharacters.MiddleEarthCharacter;

public class CharacterManager {
	private MiddleEarthCharacter[] characters;
	private int size;
	
	/**
     * Constructs a CharacterManager object with an initial capacity of 2.
     */
	public CharacterManager() {
		characters = new MiddleEarthCharacter[2];
		size = 0;
	}
	
	/**
     * Adds a new character to the characters array. If the array is full, it doubles the size of the array.
     * 
     * @param c The character to be added.
     * @return true if the character is added successfully.
     */
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
	
	/**
     * Searches for a character by name.
     * 
     * @param name The name of the character to search for.
     * @return The character if found, otherwise null.
     */
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
	
	/**
     * Updates the details of an existing character.
     * 
     * @param character The character to update.
     * @param name      The new name of the character.
     * @param health    The new health value of the character.
     * @param power     The new power value of the character.
     * @return true if the character is updated successfully, otherwise false.
     */
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
	
	/**
     * Deletes a character from the characters array.
     * 
     * @param character The character to delete.
     * @return true if the character is successfully deleted, otherwise false.
     */
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
	
	/**
     * Displays all characters currently stored in the characters array.
     */
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
