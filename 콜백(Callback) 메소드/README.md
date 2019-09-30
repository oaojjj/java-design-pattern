콜백 메소드(Callback)
=====================
콜백 메소드란?<br>
콜백 구현은 A클래스에서 동작할 수 없고 B클래스에서만 동작할 수 있는 메서드를 <br>
A클래스에서 인터페이스로 선언하여 B클래스에서 정의하고 A측에서 호출할 수 있도록 한다.<br>

**사용자가 시스템에게 처리 요청을 하면 call이고 시스템이 사용자에게 처리 요청을 하면 callback이다.**

구현 방법
---------
<img width="500" src="https://user-images.githubusercontent.com/49146043/65831529-91a6bf80-e2f5-11e9-9307-22854a750511.png">

다이어그램을 보면 이런 느낌이다.<br>

1. 우선 사용자가 download를 클릭했을 때 콜백을 하기위해 downloader클래스를 구현한다. 
<img width="600" src="https://user-images.githubusercontent.com/49146043/65831557-ed714880-e2f5-11e9-8693-efa50641ddbf.PNG">
setOnClickListener를 통해 리스너를 달아 다운로드가 끝나는 시점을 주시한다.<br><br>

2. 다운로드가 끝났을 때 콜백을 하기위해 콜백메서드를 만든다.
<img width="600" src="https://user-images.githubusercontent.com/49146043/65831572-39bc8880-e2f6-11e9-8b01-5a030b1493c8.PNG">

3. 사용자 클래스 browser를 만든다.(Main에서 바로 해도 된다)<br>
<img width="500" src="https://user-images.githubusercontent.com/49146043/65831555-d7fc1e80-e2f5-11e9-8e06-7fe9e3fe1186.PNG">
다운로드가 실패했거나 성공했을 때를 위해 OnDownloderListener로 파라미터를 전달해 리스너를 만든다.<br>
그 다음 상황에 맞는 콜백 메소드를 재정의하여 사용한다.<br><br>

4. 콜백메서드 구현 완료
<img width="500" src="https://user-images.githubusercontent.com/49146043/65831573-44771d80-e2f6-11e9-8287-78de1106773a.PNG">
