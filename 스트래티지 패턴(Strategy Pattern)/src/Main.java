package tuto_jav;

public class Main {
	public static void main(String[] args) {
		Robot robot = new Robot("로봇", new BasicWeapon(), new BasicSuit());
		
		// 기본 상태
		robot.display();
		System.out.println("---------------");
		robot.attack();
		robot.move();
		System.out.println("\n================\n");
		
		// 전략 변경 방법(로봇 상태 변경)
		robot.setName("아이언맨");
		robot.setSuit(new IronManSuit());
		robot.setWeapon(new Rocket());
		robot.display();
		System.out.println("---------------");
		robot.attack();
		robot.move();
		System.out.println("\n================\n");
		
		// 전략 변경
		robot = new Robot("태권브이",new Sword(),new BasicSuit());
		robot.display();
		System.out.println("---------------");
		robot.attack();
		robot.move();
		System.out.println("\n================\n");
	}
}
