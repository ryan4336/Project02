package project02.CharacterManager;

/**
 * Singleton class.
 * Ensures only one instance of MiddleEarthCouncil exists and provides access to the CharacterManager.
 */
public class MiddleEarthCouncil {
	
	private static MiddleEarthCouncil instance;
	private CharacterManager characterManager;
	
	/**
     * Private constructor to prevent instantiation from outside the class.
     * Initializes the CharacterManager.
     */
	private MiddleEarthCouncil() {
		characterManager = new CharacterManager();
	}
	
	/**
     * Provides access to the single instance of MiddleEarthCouncil.
     * If no instance exists, it creates one.
     * 
     * @return The singleton instance of MiddleEarthCouncil.
     */
	public static MiddleEarthCouncil getInstance() {
		if(instance == null) {
			instance = new MiddleEarthCouncil(); 
		}
		return instance;
	}
	
	/**
     * Retrieves the CharacterManager associated with the council.
     * 
     * @return The CharacterManager instance.
     */
	public CharacterManager getCharacterManager() {
		return characterManager;
		
	}
}
