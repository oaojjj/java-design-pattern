package tuto_jav;

public class Robot {
	private String name;

	// 접근점
	private Weapon weapon;
	private Suit suit;

	// 생성자
	public Robot(String name, Weapon weapon, Suit suit) {
		this.name = name;
		this.weapon = weapon;
		this.suit = suit;
	}

	// 로봇의 상태 표시
	public void display() {
		System.out.println("로봇 이름 : " + this.name);
		System.out.println("무기 상태 : " + weapon.getName());
		System.out.println("수트 상태 : " + suit.getName());
	}

	public void attack() {
		// 델리게이트 (어떤 동작방식을 가지는 지는 모른다.)
		weapon.attack();
	}

	public void move() {
		// 델리게이트
		suit.move();
	}

	// getter, setter
	public void setName(String name) {
		this.name = name;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	public void setSuit(Suit suit) {
		this.suit = suit;
	}

}