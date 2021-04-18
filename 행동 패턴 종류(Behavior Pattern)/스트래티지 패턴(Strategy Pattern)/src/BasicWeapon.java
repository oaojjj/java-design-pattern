package tuto_jav;

public class BasicWeapon implements Weapon{
	String name = "기본 무기";
	@Override
	public void attack() {
		System.out.println("펀치 공격!");
	}

	@Override
	public String getName() {
		return name;
	}

}
