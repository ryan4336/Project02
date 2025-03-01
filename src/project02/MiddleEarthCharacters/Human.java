package project02.MiddleEarthCharacters;

public class Human extends MiddleEarthCharacter {

	public Human(String name, double health, double power) {
		super(name, health, power);
	}

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
