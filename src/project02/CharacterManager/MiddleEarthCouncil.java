package project02.CharacterManager;

public class MiddleEarthCouncil {
	
	private static MiddleEarthCouncil instance;
	private CharacterManager characterManager;
	
	
	private MiddleEarthCouncil() {}
	
	
	public static MiddleEarthCouncil getInstance() {
		if(instance == null) {
			instance = new MiddleEarthCouncil(); 
		}
		return instance;
	}
	
	
	public CharacterManager getCharacterManager() {
		if(characterManager == null) {
			characterManager = new CharacterManager();
		}
		return characterManager;
		
	}
}
