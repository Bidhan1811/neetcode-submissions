class LRUCache {
    class Node {
        int key;
        int value;
        Node next;
        Node prev;
        Node (int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    Node head;
    Node tail;
    int capacity;
    HashMap<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            insertAtEnd(node, tail);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            remove(node);
            insertAtEnd(node, tail);
            map.remove(key);
            map.put(key, node);
        }
        else {
            Node newNode = new Node(key, value);
            if(map.size() == capacity) {
                map.remove(head.next.key);
                remove(head.next);
                insertAtEnd(newNode, tail);
                map.put(key, newNode);
            }
            else {
                insertAtEnd(newNode, tail);
                map.put(key, newNode);
            }
        }
        
    }

    public void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        node.prev = null;
        node.next = null;
        next.prev = prev;
    }
    public void insertAtEnd(Node node, Node tail) {
        Node last = tail.prev;
        last.next = node;
        node.prev = last;
        node.next = tail;
        tail.prev = node;
    }
}
