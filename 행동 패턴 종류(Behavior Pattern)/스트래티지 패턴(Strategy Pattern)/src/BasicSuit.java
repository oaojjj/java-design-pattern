package tuto_jav;

public class BasicSuit implements Suit {
	String name = "기본 수트";
	@Override
	public void move() {
		System.out.println("보행 가능!");
	}

	@Override
	public String getName() {
		return name;
	}

}
