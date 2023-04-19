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

## 4. 추상클래스와 인터페이스 차이

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


## 5. Generic이란 무엇인가요?

```

제네릭은 다양한 타입의 객체들이 이용하는 메소드나 컬렉션 클래스을 컴파일 단계에서
타입 체크를 해주는 기능 입니다.

```

<details>
<summary>내용정리</summary>
<div markdown="1">

- 제네릭 와일드카드

```

제네릭타입<?> : 타입파라미터 대치 모든 클래스, 인터페이스 타입
제네릭타입<? extends 상위타입> : 와일드카드 범위 특정 객체의 하위 클래스
제네릭타입<? super 하위타입> : 와일드카드 범위 특정 객체의 상위 클래스

```

- 자주 사용하는 타입인자

| 타입 파라미터 | 용도      | 타입 파라미터 용도 | 용도     |
|---------|---------|------------|--------|
| `<T>`   | Type    | `<N>`      | Number |
| `<E>`   | Element | `<V>`      | Value  |
| `<K>`   | Key     | `<R>`      | Result |

- Collection의 자료구조 별 시간 복잡도

```
- ArrayList
add             : O(1)
remove          : O(n)
get             : O(1)
Contains        : O(n)
iterator.remove : O(n)
java 1.2에 추가, thread-safe 보장 안함
 특징 :  데이터 추가,삭제를 위해 임시 배열을 생성해 데이터를 복사
   - 대량의 자료를 추가/삭제시 복사가 일어 나게 되어 성능 저하를 일이킴
   - 데이터의 인덱스를 가지고 있어 데이터 검색시 빠름

- LinkedList
add             : O(1)
remove          : O(1)
get             : O(n)
Contains        : O(n)
iterator.remove : O(1)
java 1.2에 추가, thread-safe 보장 안함
특징 : 데이터를 저장하는 각 노드가 이전 노드와 다음 노드의 상태만 알고 있다.
   - 데이터 추가/삭제시 빠름
   - 데이터 검색시 처음부터 노드를 순화해야 되기 때문에 느림


- HashSet
add         :   O(1)
contains    :   O(1)
next        :   o(h/n) h는 테이블 용량
java 1.2 thread-safe 보장 안함
특징 : 객체들을 순서없이 저장하고 동일한 객체를 중복 저장하지 않는다.
    - 중복되지 않는 값을 등록할때 용의
    - 순서없이 저장되는것 주위
    - null을 허용한다.
    
- LinkedHashSet
add       : O(1)
contains  : O(1)
next      : O(1)
java 1.4 thread-safe 보장 안함
특징 : 속도는 hashSet에 비해 느리지만 좋은 성능을 보장한다.
    - 등록한 순으로 정렬을 한다.
    - null을 허용한다.
   
- TreeSet
시간복잡도
add       : O(log n)
contains  : O(log n)
next      : O(long n)
java 1.2 에서 나옴 thread-safe 보장 안함
특징 : 객체기준으로 정렬을 한다. 느리다.
    - null을 허용하지 않는다.
    -  Red-Black-Tree 구조
    
- HashMap
시간복잡도
get           : O(1)
containsKey   : O(1)
next          : O(h/n) h는 테이블 용량
java 1.2 에서 나옴
특징 : 순서에 상관없이 저장됨, Null을 허용한다. thread-safe 보장하지 않는다.

- LinkedHashMap
시간복잡도
get           : O(1)
containsKey   : O(1)
next          : O(1)
java 1.4 에서 나옴
특징 : 순서대로 등록한다. Null을 허용한다. thread-safe 보장하지 않는다.

- TreeMap
시간복잡도
get           : O(log n)
containsKey   : O(log n)
next          : O(log n)
java 1.2 에서 나옴
특징 : 정렬이 되면서 추가가 됨
     -  null은 허용하지 않음
     -  thread-safe 보장하지 않는다.
     -  Red-Black-Tree 구조

- ConcurrentHashMap
시간복잡도
get           : O(1)
containsKey   : O(1)
next          : O(h/n) h는 테이블
java 1.5 에서 나옴
특징 :  thread-safe 보장하면서 SynchronizedMap 보다 속도가 빠르다
      - null을 허용하지 않음

```

</div>
</details>

<details>
<summary>꼬꼬무</summary>
<div markdown="1">

Q. 제네릭을 사용해야되는 이유?

```

제네릭 타입을 사용함으로써 잘못된 타입이 사용될 수 있는 문제를 컴파일 과정에서 제거할 수 있다.
실행 시 타입 에러가 나는것보다는 컴파일 시에 에러를 사전에 방지하는 것이 좋다. 
또 제네릭 코드를 사용하면 타입을 국한하기 때문에 요소를 찾아올 때 타입변환을 할 필요가 없어 프로그램 성능이 향상된다.

```

Q. 제네릭의 장,단점

```

우선 가장큰 장점으로는 타입체크 입니다.
컴파일 타임에 타입 체크를 하기 때문에 런타임에서 ClassCastException과 같은 UncheckedException을 보장받습니다
또한 타입체크와 형변환 생략이 가능하므로 코드가 간결해집니다. 
단점으로는 제네릭은 인스턴스 변수로 간주되기 때문에 static 멤버는 타입변수 제네릭을 사용하지 못합니다.
또한 new, instanceof 연산자의 경우 컴파일 시점에 타입을 명확하게 알아야되기 때문에 제네릭을 피연산자로 사용할 수 없습니다.

```


</div>
</details>

## 6. Collection framework란 무엇인가요?

```

자바에서 데이터를 저장하는 클래스들을 표준화한 설계구조입니다.
Collection은 크게 List, Set, Map 으로 나뉠 수 있습니다.
 List와 Set 인터페이스는 모두 Collection 인터페이스를 상속받지만, 구조상의 차이로 인해 Map 인터페이스는 별도로 정의됩니다.

```

<details>
<summary>꼬꼬무</summary>
<div markdown="1">

Q. List, Set, Map을 각각 비교하여 설명해주세요.

```

List는 순서가 있는 데이터 집합으로 중복이 허용됩니다. 반면 Set은 순서를 유지하지 않을 뿐만 아니라 데이터의 중복도 허용되지 않습니다.
Map은 List,Set과 다르게 key,value 쌍으로 주어진 데이터 집합으로 순서가 유지되며, 키 중복은 안되지만 값 중복은 가능합니다. 

```

Q. Collection framework에서 가장 빠른 자료구조는 무엇인가요?

```

Collection framework에서 가장 빠른 자료구조는 Map입니다.
HashMap은 데이터 삽입,삭제,검색 시 O(1)의 시간 복잡도를 가지고 있습니다.

```
 
</div>
</details>


### <img src="https://img.icons8.com/doodle/48/null/blossom-powerpuff-girls.png"  width="25" height="25" style="padding: 0;margin-bottom:-5px;" /> 6-1. HashMap 과 Hashtable의 차이

```

크게 4가지의 차이점이 있습니다.
첫번째로, Thread-safe의 여부입니다. Hashtable은 Thread-safe하고 HashMap은 Thread-safe하지 않습니다. 그렇기에
멀티스레드 환경이 아니라면 HashMap을 쓰는 것이 좋습니다.
두번째로, Null값의 허용 여부입니다. HashMap은 key에 null을 허용하지만 Hashtable은 key에 null을 허용하지 않습니다.
세번째로, Enumeration의 여부입니다. Hashtable은 not fail-fast Enumeration을 제공하지만, HashMap은 Enumeration을 제공하지 않습니다.
마지막으로 HashMap은 보조해시를 사용하기 때문에 보조 해시 함수를 사용하지 않는 Hashtable에 비하여 해시 충돌(hash collision)이 덜 발생할 수 있어 상대적으로 성능상 이점이 있습니다.

```

