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
	    return true;
	}
}
