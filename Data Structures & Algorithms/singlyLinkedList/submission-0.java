class LinkedList {
    private ListNode head;
    private ListNode tail;

    public LinkedList() {
        this.head = new ListNode(-1);
        this.tail = this.head;
    }

    public int get(int index) {
        int i = 0;
        ListNode cur = head.next;
        while (cur != null) {
            if (i == index) {
                return cur.value;
            }
            i++;
            cur = cur.next;
        }
        return -1;
    }

    public void insertHead(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = head.next;
        head.next = newNode;
        if (newNode.next == null) {
            tail = newNode;
        }
    }

    public void insertTail(int val) {
        this.tail.next = new ListNode(val);
        this.tail = this.tail.next;
    }

    public boolean remove(int index) {
        int i = 0;
        ListNode cur = this.head;
        while (i < index && cur != null) {
            i++;
            cur = cur.next;
        }
        if (cur != null && cur.next != null) {
            if (cur.next == this.tail) {
                this.tail = cur;
            }
            cur.next = cur.next.next;
            return true;
        }
        return false;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> vals = new ArrayList<>();
        ListNode cur = this.head.next;
        while (cur != null) {
            vals.add(cur.value);
            cur = cur.next;
        }
        return vals;
    }
}

class ListNode {
    int value;
    ListNode next;

    public ListNode(int value, ListNode next) {
        this.value = value;
        this.next = next;
    }


    public ListNode(int value) {
        this(value, null);
    }
}
