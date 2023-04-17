## <img src="https://img.icons8.com/doodle/48/null/blossom-powerpuff-girls.png"  width="25" height="25" style="padding: 0;margin-bottom:-5px;" /> 1. 함수형 프로그래밍 (FP : Functional Programming)이 무엇인가요?

<details>
<summary>답변</summary>
<div markdown="1">

```

함수형 프로그래밍은 순수함수를 조합하고 공유상태, 변경 가능한 데이터 및 부작용을 피하는 기본 원칙에 따라
소프트웨어를 구성하는 것을 말합니다. 명령형이 아닌 선언적 방식으로 구현되며 흐름제어를 명시적으로 기술하지 않고
프로그램 로직이 표현됩니다.

```
</div>
</details>

<details>
<summary>부연설명</summary>
<div markdown="1">

### 1급 객체 (First object, First class citizen)

```

1급 함수라고 하며 보통 자바스크립트를 배울때 많이 나오는 개념이며 함수형 프로그래밍의 전제조건이기도 합니다.
- 변수나 데이터 구조안에 넣을 수 있다.
- 파라미터로 전달 할 수 있다.
- 동적으로 프로퍼티 할당 가능
- 리턴값으로 사용할 수 있다.

```

### 1급 객체 예시

```java
@FunctionalInterface
public interface SumAndMulti {
		// 함수가 매개변수로 들어옴
    int apply(SumFunc sumFunc, int a, int b, int c);

}
```

```java
@FunctionalInterface
public interface SumDouble {
		// 리턴값이 또 다른 함수
    SumFunc apply(int a, int b);

}
```

```java
@FunctionalInterface
public interface SumFunc {

    int apply(int a, int b);

}
```

```java
public class Test {

    public static void main ( String[] args ) {
        SumFunc sumFunc = Integer::sum;
        System.out.println( sumFunc.apply( 3, 5 ) );   // 8이 출력
        SumDouble sumDouble = ( a, b ) -> ( a1, b1 ) -> a1 + b1 * 2;
        System.out.println( sumDouble.apply( 3, 5 ) ); // SumFunc 주소값 출력
        SumAndMulti sumAndMulti = ( sumFunc12, a, b, c ) -> sumFunc12.apply( a, b ) * c;
        System.out.println( sumAndMulti.apply( sumFunc, 3, 5, 7 ) );  // 56 출력
    }

}
```

### 함수형 프로그래밍 조건

1. 순수함수 (pure Function)

```

순수 함수란 같은 입력에 대해 항상 같은 출력을 반환하는 함수를 말하며 thread-safe(멀티쓰레드에서 안전)하며 병렬처리 및 계산도 가능합니다.

- 동일한 입력에 대해 항상 같은 값을 반환
- 부작용(다른 요인에 따른 결과변경)이 없는 결과를 생성 -> 함수에서 인자를 변경하거나 프로그램의 상태를 변경하지 않음.

```

2. 고차함수 (High Order Function)

```

1급 함수의 서브셋으로 다음 조건을 만족하는 함수를 말합니다.

- 함수의 인자로 함수를 전달
- 함수의 리턴값으로 함수를 사용

```

3. 익명함수 (Anonymous Function)

```

이름이 없는 함수를 말하며 람다식으로 표현되는 함수 구현을 말합니다.

```

### <img src="https://img.icons8.com/doodle/48/null/blossom-powerpuff-girls.png"  width="25" height="25" style="padding: 0;margin-bottom:-5px;" /> java.util.function 패키지

| 종류   | 추상 메소드 특징                                     | 비고 | 추상 메소드   | 
|------|-----------------------------------------------|---|----------|
| Function | 인자 O, 리턴값 O, 주로 매개값을 연산하고 결과 리턴               | BiFunction | apply()  |
| Consumer | 인자 O, 리턴값 X                                   | BiConsumer | accept() | 
| Supplier | 인자 X, 리턴값 O                                   |  |          |
| Operator | 인자 O, 리턴값 O, 주로 매개값을 연산하고 결과 리턴               |  |          | 
| Predicate | 인자O, 리턴값 boolean, 매개값을 조사하고 true/false 리턴     | BiPredicate | test()   | 

</div>
</details>

## 2. 람다란 무엇인가요?

<details>
<summary>답변</summary>
<div markdown="1">

```

람다는 메서드로 전달할 수 있는 익명 함수를 단순화한 것 입니다. 람다 표현식에는 이름은 없지만
파라미터 리스트, 바디 반환 형식, 발생할 수 있는 예외리스트는 가질 수 있습니다.

```

</div>
</details>

<details>
<summary>꼬꼬무</summary>
<div markdown="1">

Q. 람다의 특징에는 무엇이 있을까요?

```

- 익명
보통의 메소드와 달리 이름이 없으므로 익명이라 표현합니다. 구현해야할 코드의 대한 걱정거리가 줄어급니다.

- 함수
람다는 메서드처럼 특정 클래스에 종속되지 않으므로 함수라고 부릅니다. 하지만 메서드처럼 파라미터 리스트, 바디,
반환 형식, 가능한 예외 리스트를 포함합니다.

- 전달
람다 표현식을 메서드 인수로 전달하거나 변수로 저장할 수 있습니다.


```

</div>
</details>


## 3. Stream이란 무엇인가요? 

<details>
<summary>답변</summary>
<div markdown="1">

```

스트림은 이터의 흐름으로 배열 또는 컬렉션 인스턴스에 함수를 조합하여 원하는 결과를 필터링하고 가공된 결과를 손쉽게 처리하는 것입니다.
스트림의 연산 구조는 생성,중간연산,최종연산의 형태로 메소드 체이닝을 이용한 구현방식을 사용합니다.

```

</div>
</details>

<details>
<summary>꼬꼬무</summary>
<div markdown="1">

Q. Stream vs Collection

```

Stream과 Collection의 차이는 2가지가 있습니다.
첫번째 계산시간에 차이가 있습니다.
Collection은 현재 자료구조가 포함하는 모든 값을 메모리에 저장하는 자료구조로 컬렉션의 모든 요소는 컬력션에 추가하기 전에 계산됩니다.
반면 Stream은 요청할 때만 요소를 계산하는 고정된 자료구조입니다. 
두번째로는 반복방법의 차이인데 Collection은 사용자가 직접 요소룰 반복하는 외부 반복을 사용하고,
Stream은 반복을 알아서 처리하고 결과 스트림 값을 어딘가에 저장해주는 내부 반복을 사용합니다.


```

</div>
</details>

## 추상클래스와 인터페이스 차이

<details>
<summary>꼬꼬무</summary>
<div markdown="1">

Q. Stream vs Collection

```

추상클래스는 추상 메소드가 하나 이상 포함되어 있고, 인터페이스는 모든 메소드가 추상메소드여야 합니다.
그래서 추상클래스는 구현해서 확장하는데 있고, 인터페이스는 모든 메소드를 구현함으로써 강제하기 위해 목적을 둡니다.


```

</div>
</details>
