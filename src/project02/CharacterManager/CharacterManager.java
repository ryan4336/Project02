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
	    System.out.println("Added character successfully!\n");
	    return true;
	}
	
	public MiddleEarthCharacter getCharacter(String name) {
		System.out.println("Searching for character named \"" + name + "\"...");
		for(int i = 0; i < characters.length; i++) {
			if(characters[i] == null) {
				continue;
			}
			if(characters[i].getName().equals(name)) {
				System.out.println("Character found!\n");
				return characters[i];
			}
			
		}
		System.out.println("Character with name \"" + name + "\" not found.");
		return null;
	}
}
