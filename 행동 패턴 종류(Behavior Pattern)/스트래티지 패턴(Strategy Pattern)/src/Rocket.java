package tuto_jav;

public class Rocket implements Weapon{
	String name = "로켓";
	@Override
	public void attack() {
		System.out.println("미사일 발사!!");
	}
	
	public String getName() {
		return name;
	}
}
