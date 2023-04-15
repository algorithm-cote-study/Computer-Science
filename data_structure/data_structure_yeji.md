# Queue & Stack

### 1. Queue는 무슨 자료구조 인가요?

<details>
<summary>답변</summary>
<div markdown="1">

```
Queue는 선입선출(FIFO) 형태의 자료구조입니다. 삽입,삭제시 O(1)의 시간복잡도를 가집니다.
활용 예시는 Cache구현, 프로세스 관리, 너비우선탐색(BFS) 등이있습니다.
```
</div>
</details>


### 2. Stack은 무슨 자료구조 인가요?

<details>
<summary>답변</summary>
<div markdown="1">

```
Stack은 후입선출(LIFO) 형태의 자료구조입니다. 삽입,삭제시 O(1)의 시간복잡도를 가집니다.
활용 예시는 후위 표기법 연산, 괄호 유효성 검사, 웹 브라우저 방문기록(뒤로 가기), 깊이우선탐색(DFS) 등이 있습니다.
```

</div>
</details>

### 3. Stack두개를 이용해서 Queue를 구현해보세요.

<details>
<summary>답변</summary>
<div markdown="1">
example/data_structure/Queue.java
</div>
</details>


### 4. Queue두개를 이용해 Stack을 구현해보세요.

<details>
<summary>답변</summary>
<div markdown="1">
example/data_structure/Stack.java
</div>
</details>

### 5. Queue와 PriorityQueue를 비교하여 설명해주세요.

<details>
<summary>답변</summary>
<div markdown="1">

```
Queue는 시간 순서상 먼저 들어간 데이터가 먼저 나오는 선입선출형 자료구조입니다.
반면 PriorityQueue는 시간 순서에 상관없이 우선순위가 높은 데이터가 먼저 나오는 우선순위 자료구조입니다.
Queue의 삽입,삭제 시간복잡도는 O(1)이고, PriorityQueue는 삽입시 내부적으로 우선순위에 따라 정렬하므로 O(logN),
삭제시에도 삭제 후 우선순위 정렬을 하므로 O(logN)의 시간복잡도가 걸립니다.
```

</div>
</details>


# Hashtable & BST(Binary Search Tree)

### <img src="https://img.icons8.com/doodle/48/null/blossom-powerpuff-girls.png"  width="25" height="25" style="padding: 0;margin-bottom:-5px;" /> 1. Hashtable은 무슨 자료구조인가요?

<details>
<summary>답변</summary>
<div markdown="1">

```
hash table은 효율적인 탐색(빠른 탐색)을 위한 자료구조로써 key-value쌍의 데이터를 입력받습니다. 
hash function h에 key값을 입력으로 넣어 얻은 해시값 h(k)를 위치로 지정하여 key- value 데이터 쌍을 저장합니다. 
저장, 삭제, 검색의 시간복잡도는 모두 O(1)입니다. 
```

</div>
</details>

<details>
<summary>꼬꼬무</summary>
<div markdown="1">

Q. <img src="https://img.icons8.com/doodle/48/null/blossom-powerpuff-girls.png"  width="25" height="25" style="padding: 0;margin-bottom:-5px;" /> Hashtable 과 HashMap의 차이점은 뭔가요?

- [자바 HashMap은 어떻게 동작하는가?](https://d2.naver.com/helloworld/831311)

```

크게 4가지의 차이점이 있습니다.
첫번째로, Thread-safe의 여부입니다. Hashtable은 Thread-safe하고 HashMap은 Thread-safe하지 않습니다. 그렇기에
멀티스레드 환경이 아니라면 HashMap을 쓰는 것이 좋습니다.
두번째로, Null값의 허용 여부입니다. HashMap은 key에 null을 허용하지만 Hashtable은 key에 null을 허용하지 않습니다.
세번째로, Enumeration의 여부입니다. Hashtable은 not fail-fast Enumeration을 제공하지만, HashMap은 Enumeration을 제공하지 않습니다.
마지막으로 HashMap은 보조해시를 사용하기 때문에 보조 해시 함수를 사용하지 않는 Hashtable에 비하여 해시 충돌(hash collision)이 덜 발생할 수 있어 상대적으로 성능상 이점이 있습니다.

```

- not fail-fast Enumeration은 무엇인가?

```
java에서는 데이터를 하나씩 제공해주는  Iterator, Enumeration 인터페이스가 있습니다.
Iterator는 자바의 컬렉션 프레임워크에서 컬렉션에 저장되어 있는 요소들을 읽어오는 방법입니다.
Enumeration은 객체들의 집합에서 각각의 객체들을 한순간에 하나씩 처리할 수 있는 메소드를 제공하는 컬렉션 입니다.

이 둘의 가장 큰 차이점은 fail-fast 방식 개념입니다.
Iterator는 순차적 접근이 모두 끝나기 전에 컬렉션 객체에 변경이 일어날 경우 순차적 접근이 실패되면서 예외를 return하게 되는데 이를 fail-fast방식이라고 부릅니다.
반면 Enumeration은 순차적 접근 시 컬렉션 객체에 변경이 일어나도 이를 무시하고 끝까지 동작하기 때문에 not-fail-fast방식이라고 부릅니다.

** Iterator는 thread-safe하지 않음, Enumeration은 thread-safe 함 
```

</div>
</details>


### 2. BST(Binary Search Tree)는 무슨 자료구조인가요?

<details>
<summary>답변</summary>
<div markdown="1">

``` 
이진탐색트리는 정렬된 tree입니다.
어느 node를 선택하든 해당 node의 left subtree에는 그 node의 값보다 작은 값들을 지닌 node들로만 이루어져 있고, 
node의 right subtree에는 그 node의 값보다 큰 값들을 지닌 node들로만 이루어져 있는 binary tree입니다.
검색과 저장, 삭제의 시간복잡도는 모두 O(logN)이고, worst case는 한쪽으로 치우친 tree가 됐을 때 O(n)입니다.
```

</div>
</details>

<details>
<summary>꼬꼬무</summary>
<div markdown="1">

Q. 이진 트리는 어떤 자료구조인가요?

``` 
이진트리는 모든 node의 child node의 갯수가 2 이하인 트리를 이진트리 라고합니다.
```

Q. BST는 worst case 시간복잡도가 O(n)입니다. 어떨때 발생하나요?

```
균형이 많이 깨져서 한 쪽으로 치우친 BST의 경우에 worst case가 됩니다. 
이렇게 되면 Linked list와 다를게 없어집니다. 따라서 탐색시에 $O(logn)$이 아니라 $O(n)$이 됩니다.
```

Q. worst case O(n)의 해결방법에는 무엇이 있나요?

```
자가 균형 이진 탐색 트리(Self-Balancing BST)는 알고리즘으로 이진 트리의 균형이 잘 맞도록 유지하여 높이를 가능한 낮게 유지합니다. 
대표적으로 AVL트리와 Red-black tree가 있습니다. JAVA에서는 hashmap의 seperate chaning으로써 Linked list와 Red-black tree를 병행하여 저장합니다.
```

</div>
</details>

### 3. Hashtable에서 collision이 발생하면 어떻게 되나요?

<details>
<summary>답변</summary>
<div markdown="1">

```
collision이 발생할 경우 대표적인 2가지 해결방법이 있습니다.
첫번째로 open addressing 방식이 있습니다.  open addressing 방식은 collision이 발생하면 미리 정한 규칙에 따라 Hashtable의 비어있는 slot을 찾습니다.
빈 slot을 찾는 방법은 크게 linear Porbing, Quadratic Probing, Double Hasing으로 나뉩니다.
두번째로 seperate chaining 방식이 있습니다. 이 방식은 Linkedlist를 이용합니다. 만약에 collision이 발생하면 Linkedlist에 slot을 추가해 데이터를 저장합니다. 

```

</div>
</details>


<details>
<summary>부연설명</summary>
<div markdown="1">

### Open Addressing

```
open addressing 방식은 collision이 발생하면 미리 정한 규칙에 따라 hashtable의 비어있는 slot을 찾습니다. 추가적인 메모리를 사용하지 않으므로
linkedlist 또는 tree자료구조를 통해 추가로 메모리를 할당하는 seperate chaining방식에 비해 메모리를 적게 사용합니다.
openAddressing은 빈 slot을 찾는 방법에 따라 크게 Linear Probing, Quadratic Probing, Double Hashing으로 나뉩니다.
```

- Linear Probing(선형조사법) & Quadratic Probing(이차 조사법)

```
선형 조사법은 충돌이 발생한 해시값으로 부터 일정한 값만큼(+1, +2, +3, ...) 건너 뛰어, 비어 있는 slot에 데이터를 저장합니다. 
이차 조사법은 제곱수 (+1², +2², +3², ...)로 건너 뛰어, 비어 있는 slot을 찾습니다.

충돌이 여러번 발생하면 여러번 건너 뛰어 빈 slot을 찾습니다. 선형조사법과 이차조사법의 경우 충돌 횟수가 많아지면 특정 영역에 데이터가
집중적으로 몰리는 클러스터링(clustering)현상이 발생하는 단점이 있습니다. 클러스터링 현상이 발생하면, 평균 탐색 시간이 증가하게 됩니다.
```

- Double Hashing (이중해시, 중복해시)

```
이중 해싱은 open addressing 방식을 통해 충돌(collision)을 해결할 때, 조사(Probing)하는 방식중에 하나입니다. linear probing이나 quadratic probing을 통해
탐사할 때는 탐사이동폭이 같기 때문에 클러스터링 문제가 발생할 수 있습니다. 클러스터링 문제가 발생하지 않도록 2개의 해시함수를 사용하는 방식을 이중해싱이라고 합니다.
하나는 최초의 해시값을 얻을 때 사용하고 또 다른 하나는 해시 충돌이 발생할 때 탐사 이동폭을 얻기 위해 사용합니다.
```

- 해싱

```
key와 인덱스를 매핑하는 방법
```

### Seperate Chaining

```
Seperate Chaining방식은 LinkedList(또는 Tree)를 이용하여 충돌(collision)을 해결합니다. 충돌이 발생하면 LinkedList에 노드(slot)을 추가하여 데이터에 저장합니다.

삽입 : 서로 다른 두 key가 같은 해시 값을 갖게 되면 LinkedList에 두 node를 추가하여 (key,value) 데이터 쌍을 저장합니다. 삽입의 시간복잡도는 O(1)입니다.
검색 : 기본적으로 O(1)의 시간복잡도 이지만 최악의 경우 O(n)의 시간복잡도를 갖습니다.
삭제 : 삭제를 하기 위해선 검색을 먼저 해야하므로 검색의 시간복잡도와 동일합니다. 기본적으로 O(1)이지만 최악의 경우 O(n)의 시간복잡도를 갖습니다.

worst case의 경우 n개의 모든 key가 동일한 해시값을 갖게되면 길이 n의 LinkedList가 생성되게 됩니다. 이때, 시간복잡도가 O(n)이 됩니다.
```

</div>
</details>


<details>
<summary>꼬꼬무</summary>
<div markdown="1">

Q. worst case의 시간복잡도는 O(n)인데 어떤 상황에 발생하나요?

```
n개의 모든 key가 동일한 해시값을 갖게 되면 길이 n의 Linkedlist가 생성되게 됩니다.
이 때, 특정 key를 찾기 위해서는 길이 n의 Linkedlist를 검색하는 O(n)의 시간복잡도와 동일하게 됩니다.
```

Q. 이중해싱(Double Hashing)이 무엇인지 설명해주세요.

```
이중해싱은 open addressing 방식을 통해 충돌(collision)을 해결할 때, 조사(porbing)하는 방식 중에 하나입니다.
linear probing이나 quadratic probing을 통해 탐사할 때는 탐사이동폭이 같기 때문에 클러스터링 문제가 발생할 수 있습니다. 
클러스터링 문제가 발생하지 않도록 2개의 해시함수를 사용하는 방식을 이중 해싱이라고 합니다. 하나는 최초의 해시값을 얻을 때 사용하고 또 다른 하나는 해시 충돌이 발생할 때 탐사 이동폭을 얻기 위해 사용합니다.
```

</div>
</details>