데코레이터 패턴(Decorator Pattern)
=================================
**데코레이터 패턴이란?**<br>
객체에 추가적인 요건을 동적으로 첨가한다. decorator는 sub class를 만드는 것을 통해서 기능을 유연하게 확장할 수 있는 방법을 제공한다. 
예를들면 java.io 패키지에서 제공하는 많은 부분들이 decorator패턴을 바탕으로 만들어졌다.

## OCP(Open Close Principle)
class는 확장에 대해서는 열려 있어야 하지만 코드 변경에 대해서는 닫혀 있어야 한다. <br>
기존 코드는 건드리지 않은 채로 확장을 통해서 새로운 행동을 간단하게 추가할 수 있도록 한다.

## 정리
1. decorator의 super class는 자신이 장힉하고 있는 객체의 super class와 같다.
2. 한 객체를 여러 개의 decorator로 감쌀 수 있다.
decorator는 자신이 감싸고 있는 객체와 같은 super class를 가지고 있기 떄문에 원래 객체가 들어갈 자리에 decorator 객체를 집어넣어도 상관 없다.
3. **(keypoint)** decorator는 자신이 장식하고 있는 객체에서 어떤 행동을 위임하는 것 외에 원하는 추가적인 작업을 수행할 수 있다. 
4. 객체는 언제든지 감쌀 수 있기 때문에 실행중에 필요한 decorator를 마음대로 적용할 수 있다.

# UML
<img width="1000" src="https://www.tutorialspoint.com/design_pattern/images/decorator_pattern_uml_diagram.jpg">
