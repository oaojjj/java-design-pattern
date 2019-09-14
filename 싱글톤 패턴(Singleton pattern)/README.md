싱글톤 패턴(Singleton pattern)
===========================
**싱글톤 패턴이란?**<br>
전역 변수를 사용하지 않고 객체를 하나만 생성하여, 생성된 인스턴스를 어디서든지 접근할 수 있도록 하기 위한 패턴이다.<br>
참고 문서 : https://www.tutorialspoint.com/design_pattern/singleton_pattern.htm

# 구현
*고전적인 싱글톤패턴 구현법*
```java
public class Singleton{
	
	// 인스턴스를 저장하기 위한 변수
	// 외부에서 직접 호출할 수 없도록 private
	private static Singleton sInstance;
	
	// 생성자도 private으로 선언하여 외부에서 호출할 수 없도록 한다.
	private Singleton(){}
	
	// 클래스의 유일한 인스턴스를 반환하는 메서드
	public static Singleton getInstance(){
		// 인스턴스가 존재하지 않는다면 생성
		if(sInstance == null){
			sInstance = new Singleton();
		}
		return sInstance;
	}	
}
```
위의 코드와 같이 생성자를 private 통해 외부에서는 생성자를 호출할 수 없도록 한다.<br>
이제 Singleton 클래스의 인스턴스는 getInstance 메서드를 이용해 반환받아 사용해야 한다.<br>
하지만 이렇게 구현한 것은 멀티스레드에서 인스턴스가 2개 이상 생성될 수 있다는 문제점이 있다.<br><br>
# 멀티쓰레드에서 구현
*LazyHolder 구현법*
```java
public class Singleton {
    private Singleton() {}
 
    private static class LazyHolder {
        static final Singleton INSTANCE = new Singleton();
    }
 
    public static Singleton getInstance() {
        return LazyHolder.INSTANCE;
    }
}
```
위의 방법은 객체가 필요할 때로 초기화를 미루는 것이다.<br>
Singleton 클래스 내부의 LazyHolder 클래스를 정적 초기화시 인스턴스를 생성하고 getInstance 메서드를 호출하여  반환한다.
참고 문서 : http://friday.fun25.co.kr/blog/?p=312
