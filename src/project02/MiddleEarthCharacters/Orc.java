package project02.MiddleEarthCharacters;

/**
 * Represents an Orc character.
 * Extends MiddleEarthCharacter.
 */
public class Orc extends MiddleEarthCharacter {

	/**
     * Constructs an Orc character with specified attributes.
     * 
     * @param name   The name of the Orc.
     * @param health The health points of the Orc.
     * @param power  The attack power of the Orc.
     */
	public Orc(String name, double health, double power) {
		super(name, health, power);
	}

	/**
	* Orc attack: 
	* Deals 1.5x damage to Humans.
    * Cannot damage Elves or other Orcs.
    * Deals normal damage to other races.
    */
	@Override
	public boolean attack(MiddleEarthCharacter target) {
		if(target.getRace() == "Human") {
			target.health -= power * 1.5;
			System.out.println("Super effective attack! 1.5x damage!");
			return true;
		}
		if(target.getRace().equals("Elf") || target.getRace().equals("Orc")) {
			System.out.println("Attack inneffective! 0 damage done!");
			return false;
		}
		target.health -= power;
		System.out.println("Attack successful!");
		return true;
	}

	@Override
	public String getRace() {
		return "Orc";
	}
	
}
