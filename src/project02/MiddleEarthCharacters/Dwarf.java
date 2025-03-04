package project02.MiddleEarthCharacters;

/**
 * Represents a Dwarf character.
 * Extends MiddleEarthCharacter.
 */
public class Dwarf extends MiddleEarthCharacter {

	/**
     * Constructs a Dwarf character with specified attributes.
     * 
     * @param name   The name of the Dwarf.
     * @param health The health points of the Dwarf.
     * @param power  The attack power of the Dwarf.
     */
	public Dwarf(String name, double health, double power) {
		super(name, health, power);
	}

   /**
	* Dwarf attack: 
	* Deals 1.5x damage to Elves.
    * Cannot damage Wizards or other Dwarves.
    * Deals normal damage to other races.
    */
	@Override
	public boolean attack(MiddleEarthCharacter target) {
		if(target.getRace() == "Elf") {
			target.health -= power * 1.5;
			System.out.println("Super effective attack! 1.5x damage!");
			return true;
		}
		if(target.getRace().equals("Wizard") || target.getRace().equals("Dwarf")) {
			System.out.println("Attack inneffective! 0 damage done!");
			return false;
		}
		target.health -= power;
		System.out.println("Attack successful!");
		return true;
	}

	
	@Override
	public String getRace() {
		return "Dwarf";
	}
	
	
}
