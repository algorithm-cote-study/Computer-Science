# Array & Linked List

## Q. Array는 어떤 자료구조 인가요?
<details>
<summary>[핵심 답변]</summary>
<div markdown="1">

    Array는 연관된 data를 <b>메모리상에 연속적이며 순차적</b>으로 <b>미리 할당된 크기</b>만큼 저장하는 자료구조 입니다.
</div>
</details>

<details>
<summary>[면접 🍯 TIP]</summary>
<div markdown="1">

> 💡 Array에 관한 질문을 할 때에는 매우 높은 확률로 Linked List에 대한 질문도 나오게 됩니다. 따라서 Array의 다양한 특징 중에서 Linked List와 비교가 되는 특성들을 위주로 대답을 하게 되면 편하게 풀어나갈 수 있습니다! 

    Array와 Linked List의 가장 큰 차이점은 메모리에 저장되는 방식과 이에 따른 operation의 연산 속도(time complexity) 입니다. 이를 유념해서 공부해 가시면 좋은 답변을 하실 수 있습니다.

## Array의 특징

- 고정된 저장 공간(fixed-size)
- 순차적인 데이터 저장(order)

    Array의 장점은 lookup과 append가 빠르다는 것입니다. 따라서 조회를 자주 해야되는 작업에서는 Array 자료구조를 많이 씁니다.

    Array의 단점은 fixed-size 특성상 선언시에 Array의 크기를 미리 정해야 된다는 것입니다. 이는 메모리 낭비나 추가적인 overhead가 발생할 수 있습니다.

## 시간복잡도
||Array|
|------|---|
|access|$O(1)$|
|append|$O(1)$|
|마지막 원소delete|$O(1)$|
|insertion|$O(n)$|
|deletion|$O(n)$|
|search|$O(n)$|

</div>
</details>

<details>
<summary>[꼬꼬무 문답]</summary>
<div markdown="1">
    <details>
        <summary>    
            Q) 미리 예상한 것보다 더 많은 수의 data를 저장하느라 Array의 size를 넘어서게 됐습니다. 이 때, 어떻게 해결할 수 있을까요?
        </summary>
<div markdown="1">
            <b>[핵심 답변]</b>

    기존의 size보다 더 큰 Array를 선언하여 데이터를 옮겨 할당합니다. 모든 데이터를 옮겼다면 기존 Array는 메모리에서 삭제하면 됩니다. 이런식으로 동적으로 배열의 크기를 조절하는 자료구조를 Dynamic array라고 합니다.

    또 다른 방법으로는, size를 예측하기 쉽지 않다면 Array대신 Linked list를 사용함으로써 데이터가 추가될 때마다 메모리공간을 할당받는 방식을 사용하면 됩니다.
</div>
</details>
        
</div>
</details>

--- 


## Q. Dynamic Array는 어떤 자료구조 인가요?
<details>
<summary>[핵심 답변]</summary>
<div markdown="1">
    
    Array의 경우 size가 고정되었기 때문에 선언시에 설정한 size보다 많은 갯수의 data가 추가되면 저장할 수 없습니다. 이에 반해 Dynamic Array는 저장공간이 가득 차게 되면 resize를 하여 유동적으로 size를 조절하여 데이터를 저장하는 자료구조 입니다.
</div>
</details>

<details>
<summary>[면접 🍯 TIP]</summary>
<div markdown="1">

> Array의 특징중에 fixed-size의 한계점을 보완하고자 고안된 자료구조인 Dynamic Array에 대해서 면접을 위해 깊게 공부하실 내용은 크게 두 가지 입니다. 
> 1. resize를 하는 방식 
> 2. 데이터 추가(append)할 때의 시간복잡도

    Dynamic Array는 size를 자동적으로 resizing을 하는 Array입니다. 기존에 고정된 size를 가진 Static Array의 한계점을 보안하고자 고안되었습니다. Dynamic Array는 data를 계속 추가하다가 기존에 할당된 memory를 초과하게 되면, size를 늘린 배열을 선언하고 그곳으로 모든 데이터를 옮김으로써 늘어난 크기의 size를 가진 배열이 됩니다. 이를 resize라고 합니다. 이로써 새로운 data를 저장할 수 있게 됩니다. 따라서 Dynamic Array는 size를 미리 고민할 필요가 없다는 장점이 있습니다.

    resizing 을 하는 방법은 여러 가지가 있는데, 대표적으로 기존 Array size의 2배 size를 할당하는 doubling이 있습니다.

## Doubling

    resize의 대표적인 방법으로는 Doubling이 있습니다. 데이터를 추가(append $O(1)$) 하다가 메모리를 초과하게 되면 기존 배열의size보다 두배 큰 배열을 선언하고 데이터를 일일이 옮기는(n개의 데이터를 일일이 옮겨야 하므로 $O(n)$ ) 방법입니다. 

## 분할상환 시간복잡도 Amortized time complexity

    Dynamic array에 데이터를 추가할 때마다 $O(1)$의 시간이 걸리게 됩니다. → 추가를 하다가 미리 선언된 size를 넘어서는 순간에 resize를 하게 됩니다. → 이 때는 일일이 데이터를 모두 옮겨야 되기 때문에 이 때만큼은$O(n)$의 시간이 걸리게 됩니다. 

    그렇다면 결과적으로 append의 시간복잡도는 $O(1)$일까요 아니면 $O(n)$일까요?

    append의 총 과정을 살펴보면 데이터를 마지막 인덱스에 추가하는($O(1)$)작업이 대다수이고, size를 넘어설 때는 size를 두 배 늘리고 데이터를 일일이 옮기는 과정 (resize $O(n)$)이 아주 가끔 발생합니다. 결론부터 말하자면 append의 전체적인 시간복잡도는 $O(1)$입니다. 좀 더 정확히 말하면 <b>amortized</b> $O(1)$이라고 부릅니다.

    쉽게 설명하자면 가끔 발생하는 O(n)의 resize하는 시간을, 자주 발생하는 O(1)의 작업들이 분담해서 나눠 가짐으로써 전체적으로 O(1)의 시간이 걸린다고 생각하시면 됩니다.
</div>
</details>

<details>
<summary>[꼬꼬무 문답]</summary>
<div markdown="1">
&nbsp;&nbsp; Q) Dynamic Array를 Linked list와 비교하여 장단점을 설명해 주세요.

<br/>
<b>[핵심 답변]</b>

    Linked List와 비교했을 때, Dynamic Array의 장점은

  - 데이터 접근과 할당이 $O(1)$로 굉장히 빠릅니다. 이는 index 접근하는 방법이 산술적인 연산 [배열 첫 data의 주소값] + [offset]으로 이루어져 있기 때문입니다. (randam access)
  - Dynamic Array의 맨 뒤에 데이터를 추가하거나 삭제하는 것이 상대적으로 빠릅니다.($O(1)$)

    Linked List와 비교했을 때, Dynamic Array의 단점은

  - Dynamic Array의 맨 끝이 아닌 곳에 data를 insert or remove할 때, 느린 편입니다($O(n)$).  느린 이유는 메모리상에서 연속적으로 데이터들이 저장되어 있기 때문에, 데이터를 추가 삭제할 때 뒤에 있는 data들을 모두 한칸씩 shift 해야되기 때문입니다.
  - resize를 해야할 때, 예상치 못하게 현저히 낮은 performance가 발생합니다.
  - resize에 시간이 많이 걸리므로 필요한 것 이상 memory공간을 할당받습니다. 따라서 사용하지 않고 있는 낭비되는 메모리공간이 발생합니다.
</div>
</details>

--- 
## Q. Array는 어떤 자료구조 인가요?

<details>
<summary>[핵심 답변]</summary>
<div markdown="1">

    Linked List는 Node라는 구조체로 이루어져 있는데, Node는 데이터 값과 다음 Node의 address를 저장합니다. Linked List는 물리적인 메모리상에서는 비연속적으로 저장이 되지만 Linked list를 구성하는 
    각각의 Node가 next Node의 address를 가리킴으로써 논리적인 연속성을 가진 자료구조입니다.

</div>
</details>

<details>
<summary>[면접 🍯 TIP]</summary>
<div markdown="1">

    Linked List는 Node라는 구조체로 이루어져 있는데, Node는 데이터 값과 다음 Node의 address를 저장합니다. Linked List는 물리적인 메모리상에서는 비연속적으로 저장이 되지만 Linked list를 구성하는 각각의 Node가 next Node의 address를 가리킴으로써 논리적인 연속성을 가진 자료구조입니다.

> 💡 Linked List는 tree, graph등 다른 자료구조를 구현할 때 자주 쓰이는 기본 자료구조 입니다. 면접에서 Linked list를 설명할 때에는 메모리상에서 불연속적으로 데이터가 저장되는 점과 Node의 next address를 통해 불연속적인 데이터를 연결하여 논리적 연속성을 보장한다는 점을 중심으로 설명하면 됩니다.
> 또한, 데이터가 추가 되는 시점에서 메모리를 할당하기 때문에 메모리를 좀 더 효율적으로 사용할 수 있다는 장점도 답변으로 구성하면 좋습니다.


### 논리적 연속성


    각 Node들은 next address정보를 가지고 있기 때문에 논리적으로 연속성을 유지하면서 연결되어 있습니다. Array의 경우 연속성을 유지하기 위해 물리적 메모리 상에서 순차적으로 저장하는 방법을 사용하였고, Linked list에는 메모리에서 연속성을 유지하지 않아도 되기 때문에 메모리 사용이 좀 더 자유로운 대신, Next address를 추가적으로 저장해야 하기 때문에 데이터 하나당 차지하는 메모리가 더 커지게 됩니다. 

(1) 그림에서 링크드리스트가 연속적으로 저장된것처럼 보이지만 실제 메모리상에서는 (2)와 같다

(1) 논리적 연속성

<img src="https://user-images.githubusercontent.com/32692807/231956326-c478a93b-c01c-4e0b-b1ca-f6c70585fd2f.jpeg" height="400" width="600">

(2) 물리적 불연속성

<img width="464" alt="스크린샷 2022-08-03 오후 4 46 09" src="https://user-images.githubusercontent.com/32692807/231959611-9a8ad5e4-4dc8-4f0a-bc06-df36e19518a5.png">

## 시간복잡도

    Array의 경우 중간에 데이터를 삽입/삭제하게 되면 해당 인덱스의 뒤에 있는 모든 원소들은 shift를 해야만 했습니다. 그러다 보니 $O(n)$의 시간복잡도를 갖게 되었습니다. 하지만 Linked list를 물리적으로 옮길 필요없이 next address가 가리키는 주소값만 변경하면 되기 때문에 $O(1)$의 시간복잡도로 삽입/삭제가 가능합니다.

||Linked list|
|------|---|
|access|$O(n)$|
|search|$O(n)$|
|insertion|$O(1)$|
|deletion|$O(1)$|

<img width="464" alt="스크린샷 2022-08-03 오후 4 46 09" src="https://user-images.githubusercontent.com/32692807/231966878-08fb1bde-48b7-4e7b-bd69-899207845cbd.jpeg">
<img width="464" alt="스크린샷 2022-08-03 오후 4 46 09" src="https://user-images.githubusercontent.com/32692807/231967005-dd12ff03-db62-4632-88a0-0f8616823ec8.jpeg">


</div>
</details>

--- 

## Q. ⭐ Array vs Linked list를 비교해서 설명해주세요

<details>
<summary>[핵심 답변]</summary>
<div markdown="1">
    
    Array는 메모리 상에서 연속적으로 데이터를 저장하는 자료구조 입니다. Linked List는 메모리상에서는 연속적이지 않지만, 각각의 원소가 다음 원소의 메모리 주소값을 저장해 놓음으로써 논리적 연속성을 유지합니다.

    그래서 각 operation의 시간복잡도가 다릅니다. 데이터 조회는 Array의 경우 $O(1)$, Linked list는 $O(n)$의 시간복잡도를 갖습니다. 삽입/삭제는 Array $O(n)$, Linked list $O(1)$의 시간복잡도를 갖습니다.

    따라서 얼마만큼의 데이터를 저장할지 미리 알고있고, 조회를 많이 한다면 Array를 사용하는 것이 좋습니다. 반면에 몇개의 데이터를 저장할 지 불확실하고 삽입 삭제가 잦다면 Linked list를 사용하는 것이 유리합니다.
</div>
</details>


<details>
<summary>[면접 🍯 TIP]</summary>
<div markdown="1">

> Array와 Linked List의 주된 차이점들은 메모리 구조에 기인합니다. Array는 메모리상에서 연속적으로 데이터를 저장하고, Linked List는 불연속적으로 저장합니다. 메모리 구조의 차이로 인해 operation구현방법이 다르고 시간복잡도도 다릅니다. 또한 메모리 활용도에서도 차이가 있습니다. 상황에 따라 메모리를 효율적으로 사용할 수 있는 자료구조가 달라집니다. 이를 유념해서 학습을 해봅시다!
    
    Array는 메모리 상에서 연속적으로 데이터를 저장하는 자료구조 입니다. Linked List는 메모리상에서는 연속적이지 않지만, 각각의 원소가 다음 원소의 메모리 주소값을 저장해 놓음으로써 논리적 연속성을 유지합니다.

    그래서 각 operation의 시간복잡도가 다릅니다. 데이터 조회는 Array의 경우 $O(1)$, Linked list는 $O(n)$의 시간복잡도를 갖습니다. 삽입/삭제는 Array $O(n)$, Linked list $O(1)$의 시간복잡도를 갖습니다.

    따라서 얼마만큼의 데이터를 저장할지 미리 알고있고, 조회를 많이 한다면 Array를 사용하는 것이 좋습니다. 반면에 몇개의 데이터를 저장할 지 불확실하고 삽입 삭제가 잦다면 Linked list를 사용하는 것이 유리합니다.

### 조회 (lookup)

    Array는 메모리상에서 연속적으로 데이터를 저장하였기 때문에 저장된 데이터에 즉시 접근(random access $O(1)$)할 수 있습니다. 이와 반면 Linked List는 메모리 상에서 불연속적으로 데이터를 저장하기 때문에 순차 접근(Sequential Access)만 가능합니다. 즉, 특정 index의 데이터를 조회하기 위해 $O(n)$의 시간이 걸리게 됩니다.

### 삽입/삭제 (insert/delete)

    Array의 경우 맨 마지막 원소를 추가/삭제하면 시간복잡도가 $O(1)$입니다. 하지만 맨 마지막 원소가 아닌 중간에 있는 원소를 삽입/삭제하면 해당 원소보다 큰 인덱스의 원소들을 한 칸씩 shift 해줘야 하는 비용(cost)이 발생합니다. 따라서 이 경우에는 시간복잡도가 $O(n)$이 됩니다.

    Linked List는 어느 원소를 추가/삭제 하더라도 node에서 다음주소를 가르키는 부분만 다른 주소 값으로 변경하면 되기 때문에 shift할 필요 없어 시간복잡도가 $O(1)$입니다. 

    하지만 Linked list의 경우 추가/삭제를 하려는 index까지 도달하는데 $O(n)$의 시간이 걸리기 때문에, 실질적으로 Linked List도 추가/삭제 시에 $O(n)$의 시간이 걸린다고 볼 수 있습니다.

### memory

    Array의 주된 장점은 데이터 접근과 append가  빠르다는 것입니다. 하지만 메모리 낭비라는 단점이 있습니다. 배열은 선언시에 fixed size를 설정하여 메모리 할당을 합니다. 즉, 데이터가 저장되어 있지 않더라도 메모리를 차지하고 있기 때문에 메모리 낭비가 발생합니다. 

    이와 반면 Linked List는 runtime중에서도 size를 늘리고 줄일 수 있습니다. 그래서 initial size를 고민할 필요 없고, 필요한 만큼 memorry allocation을 하여 메모리 낭비가 없습니다.
</div>
</details>
<details>
<summary>[꼬꼬무 문답]</summary>
<div markdown="1">
&nbsp;&nbsp;
<details>
    <summary> Q. 어느 상황에 Linked list를 쓰는게 Array보다 더 나을까요?</summary>
    <div markdown="1">
        <b>[핵심 답변]</b>

  - $O(1)$으로 삽입/삭제를 자주 해야 될 때
  - 얼마만큼의 데이터가 들어올지 예측을 할 수 없을 때
  - 조회 작업을 별로 하지 않을 때
    </div>
</details>
<details>
    <summary>Q. 어느 상황에 Array를 쓰는게 Linked list보다 더 나을까요?</summary>
    <div markdown="1">
    <b>[핵심 답변]</b>

  - 조회 작업을 자주 해야될 때
  - Array를 선언할 당시에 데이터의 갯수를 미리 알고 있을때
  - 데이터를 반복문을 통해서 빠르게 순회할 때.
  - 메모리를 적게 쓰는게 중요한 상황일 때. Linked list보단 Array가 메모리를 적게 차지 하기 때문에 미리 들어올 데이터의 양을 알고만 있다면 Array가 메모리를 더 효율적으로 사용합니다.
    </div>
</details>
<details>

<summary>Q. Array와 Linked List의 memory allocation은 언제 일어나며, 메모리의 어느 영역을 할당 받나요?</summary>

<div markdown="1">
    <b>[핵심 답변]</b>

    Array는 compile 단계에서 memory allocation이 일어납니다. 이를 Static Memory Allocation이라고 합니다. 이 경우 Stack memory영역에 할당됩니다.

    Linked List의 경우 runtime 단계에서 새로운 node가 추가될 때마다 memory allocation이 일어납니다. 이를 Dynamic Memory Allocation이라고 부릅니다. Heap메모리 영역에 할당됩니다.
 <img src="https://user-images.githubusercontent.com/32692807/231968193-8892e9c4-6958-4165-92e7-fac02bcb9736.jpeg">
</div>
</details>
</div>
</details>