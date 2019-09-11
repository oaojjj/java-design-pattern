package tuto_jav;

public class IronManSuit implements Suit{
	String name = "아이언맨 수트";

	@Override
	public void move() {
		System.out.println("비행 가능!!");
		System.out.println("보행 가능!");
	}

	@Override
	public String getName() {
		return name;
	}
}
