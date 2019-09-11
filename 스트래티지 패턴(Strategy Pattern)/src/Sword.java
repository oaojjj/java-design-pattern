package tuto_jav;

public class Sword implements Weapon{
	String name = "칼";
	@Override
	public void attack() {
		System.out.println("칼 공격!");
	}
	
	@Override
	public String getName() {
		return name;
	}
}
