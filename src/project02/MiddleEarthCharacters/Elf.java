package project02.MiddleEarthCharacters;

/**
 * Represents an Elf character.
 * Extends MiddleEarthCharacter.
 */
public class Elf extends MiddleEarthCharacter {
	
	/**
     * Constructs an Elf character with specified attributes.
     * 
     * @param name   The name of the Elf.
     * @param health The health points of the Elf.
     * @param power  The attack power of the Elf.
     */
	public Elf(String name, double health, double power) {
		super(name, health, power);
	}

	/**
	* Elf attack: 
	* Deals 1.5x damage to Orcs.
    * Cannot damage Dwarves or other Elves.
    * Deals normal damage to other races.
    */
	@Override
	public boolean attack(MiddleEarthCharacter target) {
		if(target.getRace() == "Orc") {
			target.health -= power * 1.5;
			System.out.println("Super effective attack! 1.5x damage!");
			return true;
		}
		if(target.getRace().equals("Elf") || target.getRace().equals("Dwarf")) {
			System.out.println("Attack inneffective! 0 damage done!");
			return false;
		}
		target.health -= power;
		System.out.println("Attack successful!");
		return true;
	}

	@Override
	public String getRace() {
		return "Elf";
	}
	
	
}
