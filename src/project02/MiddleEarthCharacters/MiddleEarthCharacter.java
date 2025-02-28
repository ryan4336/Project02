package project02.MiddleEarthCharacters;

public abstract class MiddleEarthCharacter {
	protected String name;
	protected double health;
	protected double power;
	
	
	public MiddleEarthCharacter(String name, double health, double power) {
		this.name = name;
		this.health = health;
		this.power = power;
	}
	
	abstract boolean attack(MiddleEarthCharacter target);
	abstract String getRace();
	
	public void displayInfo() {
		System.out.println("Name: " + name + "; Health: " + health + "; Power: " + power + "; Race: " + getRace());
	}
	
}
