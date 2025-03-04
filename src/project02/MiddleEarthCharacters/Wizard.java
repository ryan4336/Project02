package project02.MiddleEarthCharacters;

/**
 * Represents a Wizard character.
 * Extends MiddleEarthCharacter.
 */
public class Wizard extends MiddleEarthCharacter {

	/**
     * Constructs a Wizard character with specified attributes.
     * 
     * @param name   The name of the Wizard.
     * @param health The health points of the Wizard.
     * @param power  The attack power of the Wizard.
     */
	public Wizard(String name, double health, double power) {
		super(name, health, power);
	}

	/**
	* Wizard attack: 
	* Deals 1.5x damage to Dwarves.
    * Cannot damage Humans or other Wizards.
    * Deals normal damage to other races.
    */
	@Override
	public boolean attack(MiddleEarthCharacter target) {
		if(target.getRace() == "Dwarf") {
			target.health -= power * 1.5;
			System.out.println("Super effective attack! 1.5x damage!");
			return true;
		}
		if(target.getRace().equals("Human") || target.getRace().equals("Wizard")) {
			System.out.println("Attack inneffective! 0 damage done!");
			return false;
		}
		target.health -= power;
		System.out.println("Attack successful!");
		return true;
	}

	@Override
	public String getRace() {
		return "Wizard";
	}
	
}
