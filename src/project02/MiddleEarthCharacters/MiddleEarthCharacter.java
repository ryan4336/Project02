package project02.MiddleEarthCharacters;

public abstract class MiddleEarthCharacter {
	private String name;
	private double health;
	private double power;
	
	
	public MiddleEarthCharacter(String name, double health, double power) {
		this.name = name;
		this.health = health;
		this.power = power;
	}
	
	abstract boolean attack(MiddleEarthCharacter target);
	abstract String getRace();
	
	public void displayInfo() {
		System.out.println("Printing Character Details:");
		System.out.println("Name: " + name);
		System.out.println("Health: " + health);
		System.out.println("Power: " + power);
		System.out.println("Race: " + getRace());
	}
}
