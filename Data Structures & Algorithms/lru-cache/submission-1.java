class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

class LRUCache {

    HashMap<Integer, Node> cache = new HashMap<>();
    private int capacity;
    Node left;
    Node right;

    public LRUCache(int capacity) {
        this.capacity = capacity;

        // Left is LRU, right is MRU
        this.left = new Node(0,0);
        this.right = new Node(0,0);
        this.left.next = this.right;
        this.right.prev = this.left;
    }
    
    public int get(int key) {
        if (cache.containsKey(key)) {
            Node cur = cache.get(key);
            remove(cur);
            insert(cur);
            return cur.val;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) { // update val of key
            remove(cache.get(key));
        } else { // add key-val to cache
            Node node = new Node(key, value);
            cache.put(key, node);
            insert(node);
            if (cache.size() > capacity) {
                Node lru = this.left.next;
                remove(lru);
                cache.remove(lru.key);
            }
        }
    }

    private void insert(Node node) { // insert at the right
        Node prev = this.right.prev;
        prev.next = node;
        this.right.prev = node;
        node.next = this.right;
        node.prev = prev;
    }

    private void remove(Node node) { // remove any node
        Node prev = node.prev;
        Node nxt = node.next;
        prev.next = nxt;
        nxt.prev = prev;
    }
}
