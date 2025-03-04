package project02.MiddleEarthCharacters;

/**
 * Abstract class used as super class to Dwarf, Orc, Elf, Human, and Wizard classes.
 */
public abstract class MiddleEarthCharacter {
	protected String name;
	protected double health;
	protected double power;
	
	/**
     * Constructs a Middle Earth character with the specified attributes.
     * 
     * @param name   The name of the character.
     * @param health The health points of the character.
     * @param power  The attack power of the character.
     */
	public MiddleEarthCharacter(String name, double health, double power) {
		this.name = name;
		this.health = health;
		this.power = power;
	}
	
	/**
     * Executes an attack on another character. 
     * 
     * @param target The character being attacked.
     * @return true if the attack was successful, false if ineffective.
     */
	public abstract boolean attack(MiddleEarthCharacter target);
	/**
     * Returns the race of the character.
     * 
     * @return The race of the character.
     */
	abstract String getRace();
	
	/**
     * Displays the character's information including name, health, power, and race.
     */
	public void displayInfo() {
		System.out.println("Name: " + name + "; Health: " + health + "; Power: " + power + "; Race: " + getRace());
	}

	/**
     * Retrieves the name of the character.
     * 
     * @return The name of the character.
     */
	public String getName() {
		return name;
	}

	/**
     * Updates the name of the character.
     * 
     * @param name The new name of the character.
     */
	public void setName(String name) {
		this.name = name;
	}

	/**
     * Retrieves the current health points of the character.
     * 
     * @return The health of the character.
     */
	public double getHealth() {
		return health;
	}
	
	/**
     * Updates the health points of the character.
     * 
     * @param health The new health value of the character.
     */
	public void setHealth(double health) {
		this.health = health;
	}

	/**
     * Retrieves the attack power of the character.
     * 
     * @return The attack power of the character.
     */
	public double getPower() {
		return power;
	}

	/**
     * Updates the attack power of the character.
     * 
     * @param power The new attack power of the character.
     */
	public void setPower(double power) {
		this.power = power;
	}
	
	
}
