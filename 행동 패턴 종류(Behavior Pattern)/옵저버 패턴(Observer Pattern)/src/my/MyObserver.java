package my;

public interface MyObserver {
    // 데이터를 갱신할 때는 push와 pull 방식이 있다.
    // push는 observable을 구현하는 subject에서 값을 보내주는 것이다.
    // pull은 subject 자신을 넘겨주기 때문에 원하는 값만 쓸 수 있다.
    // 나는 데이터 pull 방식 사용
    void update(MyObservable observable, Object object);
}
