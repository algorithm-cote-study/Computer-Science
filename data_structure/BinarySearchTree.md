# 이진탐색트리 (Binary Search Tree)

## 정의

```

이진탐색트리는 이진탐색(binary search)과 연결리스트(linked list)를 결합한 자료구조로 모든 노드의 왼쪽 서브트리는
해당 노드의 값보다 작은 값들만 가지고 모든 노드의 오른쪽 서브 트리는 해당 노드의 값보다 큰 값들만 가집니다.
 
이진탐색의 효율적인 탐색 능력을 유지하면서도, 빈번한 자료 입력과 삭제를 가능하게끔 고안됐습니다.
이진탐색(binary search)
배열의 중간에 있는 임의의 값을 선택하여 찾고자 하는 값 X와 비교한다. 
X가 중간 값보다 작으면 중간 값을 기준으로 좌측의 데이터들을 대상으로, X가 중간값보다 크면 배열의 우측을 대상으로 다시 탐색한다.
이러한 과정으로 값을 찾을 때 까지 계속 반복한다.

연결리스트(linked list)
각 노드가 데이터와 포인터를 가지고 한 줄로 연결되어 있는 방식으로 데이터를 저장하는 자료 구조이다.

예컨대 이진탐색의 경우 탐색에 소요되는 시간복잡도는 𝑂(logN )
으로 빠르지만 자료 입력, 삭제가 불가능합니다. 연결리스트의 경우 자료 입력, 삭제에 필요한 시간복잡도는 𝑂(1)로 효율적이지만 최악의 경우 탐색하는 데에는 𝑂(N)
의 시간복잡도가 발생합니다. 

```

## 최악의 경우 (worst case)

```

이진 탐색 트리는 들어오는 순서대로 노드의 큰, 값 작은 값을 찾아 넣게 됩니다. 이런 경우에는 균형이 맞지 않는데,
 예를 들면 n개의 노드가 크기 순으로 일렬로 늘어져 있는 경우 높이 또한 n이 되는 경우에는 시간복잡도가 O(n)입니다.
이렇게 들어가는 값에 의한 정렬을 보안하기 위해 자가 이진트리인 AVL Tree, Red-Black Tree를 사용합니다.

```


## 구현

```java

public class BinarySearchTree {
    Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(int value) {
        this.root = insertHelper(this.root, value);
    }

    private Node insertHelper(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }

        if (value < root.value) {
            root.leftChild = insertHelper(root.leftChild, value);
        } else if (value > root.value) {
            root.rightChild = insertHelper(root.rightChild, value);
        }

        return root;
    }

    public boolean search(int value) {
        return searchHelper(this.root, value);
    }

    private boolean searchHelper(Node root, int value) {
        if (root == null) {
            return false;
        }

        if (root.value == value) {
            return true;
        } else if (value < root.value) {
            return searchHelper(root.leftChild, value);
        } else {
            return searchHelper(root.rightChild, value);
        }
    }

    public void inorderTraversal() {
        inorderTraversalHelper(this.root);
    }

    private void inorderTraversalHelper(Node root) {
        if (root != null) {
            inorderTraversalHelper(root.leftChild);
            System.out.print(root.value + " ");
            inorderTraversalHelper(root.rightChild);
        }
    }
}

class Node {
    int value;
    Node leftChild;
    Node rightChild;

    public Node(int value) {
        this.value = value;
        this.leftChild = null;
        this.rightChild = null;
    }
}

```


