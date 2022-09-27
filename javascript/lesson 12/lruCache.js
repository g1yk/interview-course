// https://leetcode.com/problems/lru-cache/

class LRUCache {
    constructor(capacity) {
        this.capacity = capacity;
        this.map = new Map();
        this.list = new DoubleLinkedList();
    }
    
    get(key) {
        if (this.map.has(key)) {
            const node = this.map.get(key);
            this.list.moveToHead(node);
            return node.val;        
        }
        return -1;        
    }
    
    put(key, value) {
        if (this.map.has(key)) {
            const node = this.map.get(key);
            node.val = value;
            this.list.moveToHead(node);
        } else {
            const node = new Node(key, value);
            this.map.set(key, node);
            this.list.addToHead(node);
            if (this.map.size > this.capacity) {
                const r = this.list.removeFromTail();
                this.map.delete(r.key);
            }
        }
    }
    
}

class Node {
    constructor(key, value) {
        this.key = key;
        this.val = value;
        this.prev = null;
        this.next = null;
    }
    
}

class DoubleLinkedList {
    constructor() {
        this.head = new Node();
        this.tail = new Node();
        this.head.prev = this.tail;
        this.tail.next = this.head;
    }
    
    addToHead(node) {
        const prev = this.head.prev;            
        prev.next = node;
        node.prev = prev;
        node.next = this.head;
        this.head.prev = node;
        return node;
    }

    moveToHead(node) {
        const prev = node.prev;
        const next = node.next;            
        prev.next = next;
        next.prev = prev;
        this.addToHead(node);
    }

    removeFromTail() {
        const result = this.tail.next;            
        this.tail.next = result.next;
        result.next.prev = this.tail;
        result.prev = null;
        result.next = null;
        return result;
    }
}
