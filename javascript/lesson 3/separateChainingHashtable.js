const INITIAL_CAPACITY = 4;

class Node {
    constructor(key, value, next = null) {
        this.key = key;
        this.value = value;
        this.next = next;
    }
}

class SeparateChainingHashTable {
    constructor(capacity = INITIAL_CAPACITY) {
        this.count = 0;
        this.capacity = capacity;
        this.buckets = new Array(capacity);
    }

    put(key, value) {
        if (this.count >= 10 * this.capacity) this._resize(2 * this.capacity);

        const i = this._hash(key);
        for (let node = this.buckets[i]; node != null; node = node.next) {
            if (key === node.key) {
                node.value = value;
                return;
            }
        }
        this.buckets[i] = new Node(key, value, this.buckets[i]);
        this.count++;
    }

    get(key) {
        const i = this._hash(key);
        for (let node = this.buckets[i]; node != null; node = node.next) {
            if (key === node.key) return node.value;
        }
        return null;
    }

    remove(key) {
        var i = this._hash(key);
        for (let prev = null, node = this.buckets[i]; node != null; prev = node, node = node.next) {
            if (key === node.key) {
                if (!prev) {
                    this.buckets[i] = node.next;
                } else {
                    prev.next = node.next;
                }
                this.count--;
                break;
            }
        }
        if (this.capacity > INITIAL_CAPACITY && this.count <= 2 * this.capacity) this._resize(this.capacity / 2);
    }

    _resize(size) {
        const temp = new SeparateChainingHashTable(size);
        for (let i = 0; i < this.capacity; i++) {
            for (let node = this.buckets[i]; node != null; node = node.next) {
                temp.put(node.key, node.value);
            }
        }
        this.buckets = temp.buckets;
        this.capacity = size;
    }

    _hash(key) {
        return key % this.capacity;
    }
}
