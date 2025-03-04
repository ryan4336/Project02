package project02.MiddleEarthCharacters;

/**
 * Represents a Human character.
 * Extends MiddleEarthCharacter.
 */
public class Human extends MiddleEarthCharacter {

	/**
     * Constructs a Human character with specified attributes.
     * 
     * @param name   The name of the Human.
     * @param health The health points of the Human.
     * @param power  The attack power of the Human.
     */
	public Human(String name, double health, double power) {
		super(name, health, power);
	}
	
	/**
	* Human attack: 
	* Deals 1.5x damage to Wizards.
    * Cannot damage Orcs or other Humans.
    * Deals normal damage to other races.
    */
	@Override
	public boolean attack(MiddleEarthCharacter target) {
		if(target.getRace() == "Wizard") {
			target.health -= power * 1.5;
			System.out.println("Super effective attack! 1.5x damage!");
			return true;
		}
		if(target.getRace().equals("Orc") || target.getRace().equals("Human")) {
			System.out.println("Attack inneffective! 0 damage done!");
			return false;
		}
		target.health -= power;
		System.out.println("Attack successful!");
		return true;
	}

	@Override
	public String getRace() {
		return "Human";
	}
	
	
}
