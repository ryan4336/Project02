package project02.MiddleEarthCharacters;

public class Wizard extends MiddleEarthCharacter {

	public Wizard(String name, double health, double power) {
		super(name, health, power);
	}

	@Override
	boolean attack(MiddleEarthCharacter target) {
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
	String getRace() {
		return "Wizard";
	}
	
}
