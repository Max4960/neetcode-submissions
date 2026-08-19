class Deque {
    private Node dummyHead;
    private Node dummyTail;

    public Deque() {
        this.dummyHead = new Node(-1);
        this.dummyTail = new Node(-1);

        this.dummyHead.right = this.dummyTail;
        this.dummyTail.left = this.dummyHead;
    }

    public boolean isEmpty() {
        return this.dummyHead.right == this.dummyTail;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        Node prevNode = this.dummyTail.left;

        prevNode.right = newNode;
        newNode.left = prevNode;
        newNode.right = this.dummyTail;
        this.dummyTail.left = newNode;
    }

    public void appendleft(int value) {
        Node newNode = new Node(value);
        Node prevNode = this.dummyHead.right;

        this.dummyHead.right = newNode;
        newNode.left = this.dummyHead;
        newNode.right = prevNode;
        prevNode.left = newNode;
    }

    public int pop() {
        if (this.isEmpty()) {
            return -1;
        }
        Node lastNode = this.dummyTail.left;
        int value = lastNode.value;
        Node prevNode = lastNode.left;
        prevNode.right = this.dummyTail;
        this.dummyTail.left = prevNode;

        return value;
    }

    public int popleft() {
        if (this.isEmpty()) {
            return -1;
        }
        Node target = this.dummyHead.right;
        int value = target.value;
        Node nextNode = target.right;
        nextNode.left = dummyHead;
        this.dummyHead.right = nextNode;

        return value;
    }
}

class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

}
