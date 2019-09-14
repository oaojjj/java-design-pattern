전략 패턴(Strategy Pattern)
===========================
전략 패턴이란?<br>
동적으로 알고리즘 패턴을 변경할 수 있는 구조이다. 알고리즘 인터페이스를 정의하고, 각각을 캡슐화하여 교체 사용이 가능하다. 즉, 전략을 쉽게 바꿀 수 있도록 해주는 디자인 패턴이다.<br>
참고 문서 : https://www.tutorialspoint.com/design_pattern/strategy_pattern.htm

## 디자인 원칙
1. 애플리케이션에서 달라지는 부분을 찾아내고, 달라지지 않는 부분으로부터 분리 시킨다.<br>
2. 구현이 아닌 인터페이스에 맞춰서 프로그래밍한다.
3. 상속보다는 구성을 활용한다.

## 쓰임새
1. 기존에 추가된 객체의 동작을 변경하려는 경우<br>
Robot 추상클래스를 만들고 상속받아 객체화 시켰을 때, attack이나 move를 수정하고싶으면 기존의 코드를 수정해야 한다.<br> 하지만 그런 경우 새로운 기능을 위해 기존의 속성을 변경해야 하기에 OCP를 위반하는 행위이다.<br>
```java
public abstract class Robot {
    public Robot() {}
    private String name;
    
    public Robot(String name) {
        this.name = name;
    }
    
    abstract void attck();
    abstract void move();
}

// 아이언맨
public class IronMan extends Robot {
    public IronMan() {}
 
    public IronMan(String name) {
        super(name);
    }
 
    @Override
    void attck() {
        System.out.println("미사일 발사");
    }
    
     @Override
    void move() {
        System.out.println("보행가능,비행가능");
    }
 
}
.
.
.

```
2. 새로운 객체가 추가되었을 경우<br>
새로운 로봇 아톰이 추가되었을 때 아이언맨의 move 메소드를 동일하게 사용하고 싶지만 별도로 만들어 주어야 한다.<br> 그렇게 되면 중복된 코드를 만들기 때문에 좋지 않다.


# UML
<img width="1000" src="https://user-images.githubusercontent.com/49146043/64711631-dc9e9580-d4f4-11e9-9369-63708055c88f.png">

# 구현
### 1. 로봇의 이동, 공격 기능에 대한 인터페이스(Stategy)

```java
public interface Suit {
	public void move();
	public String getName();
}

public interface Weapon {
	public void attack();
	public String getName();
}
```

### 2. 기능을 구현한 구체적인 클래스(ConcreteStrategy)

```java
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
```

### 3. 로봇 클래스
```java
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
```

### 4. 메인 클래스(Client)
```java
public static void main(String[] args) {
		Robot robot = new Robot("로봇", new BasicWeapon(), new BasicSuit());
		
		// 기본 상태
		robot.display();
		System.out.println("-----------------");
		robot.attack();
		robot.move();
}
```
**실행**
```
로봇 이름 : 로봇
무기 상태 : 기본 무기
수트 상태 : 기본 수트
--------------------
펀치 공격!!
보행 가능!
```

### 5. 전략 추가
```java
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
```

### 6. 전략 변경
```java
public class Main {
	public static void main(String[] args) {
		Robot robot = new Robot("로봇", new BasicWeapon(), new BasicSuit());
		
		// 기본 상태
		robot.display();
		System.out.println("---------------");
		robot.attack();
		robot.move();
		
		// 전략 변경 방법(로봇 상태 변경)
		robot.setName("아이언맨");
		robot.setSuit(new IronManSuit());
		robot.setWeapon(new Rocket());
		robot.display();
		System.out.println("---------------");
		robot.attack();
		robot.move();
		
		// 전략 변경
		robot = new Robot("태권브이",new Sword(),new BasicSuit());
		robot.display();
		System.out.println("---------------");
		robot.attack();
		robot.move();
	}
}
```

### 7. 최종 실행
```
로봇 이름 : 로봇
무기 상태 : 기본 무기
수트 상태 : 기본 수트
---------------
펀치 공격!
보행 가능!

================

로봇 이름 : 아이언맨
무기 상태 : 로켓
수트 상태 : 아이언맨 수트
---------------
미사일 발사!!
비행 가능!!
보행 가능!

================

로봇 이름 : 태권브이
무기 상태 : 칼
수트 상태 : 기본 수트
---------------
칼 공격!
보행 가능!

================

```
