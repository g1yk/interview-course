// https://leetcode.com/problems/lru-cache/

class LRUCache {
    Map<Integer, Node> map = new HashMap<>();
    DoubleLinkedList list = new DoubleLinkedList();
    int capacity = 0;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);        
            list.moveToHead(node);
            return node.val;        
        }
        return -1;        
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            list.moveToHead(node);                        
        } else {
            Node node = new Node(key, value);
            map.put(key, node);
            list.addToHead(node);
            if (map.size() > this.capacity) {
                Node r = list.removeFromTail();
                map.remove(r.key);
            }
        }
    }
    
    class DoubleLinkedList {
        Node head;
        Node tail;
        
        public DoubleLinkedList() {
            head = new Node();
            tail = new Node();
            head.prev = tail;
            tail.next = head;
        }
        
        public Node addToHead(Node node) {
            Node prev = head.prev;            
            prev.next = node;
            node.prev = prev;
            node.next = head;
            head.prev = node;
            return node;
        }
        
        public void moveToHead(Node node) {
            Node prev = node.prev;
            Node next = node.next;            
            prev.next = next;
            next.prev = prev;
            addToHead(node);
        }
        
        private Node removeFromTail() {
            Node result = tail.next;            
            tail.next = result.next;
            result.next.prev = tail;
            result.prev = null;
            result.next = null;
            return result;
        }
    }
    
    class Node {
        public int key;
        public int val;
        public Node prev;
        public Node next;
        public Node() {}
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
