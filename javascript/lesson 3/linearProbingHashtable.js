// https://leetcode.com/problems/design-hashmap/

const INITIAL_CAPACITY = 4;

class LinearProbingHashTable {
    constructor(capacity = INITIAL_CAPACITY) {
        this.count = 0;
        this.capacity = capacity;
        this.keys = new Array(capacity);
        this.values = new Array(capacity);
    }

    put(key, value) {
        if (this.count >= this.capacity / 2) this._resize(2 * this.capacity);
        let i;
        for (i = this._hash(key); this.keys[i] != null; i = (i + 1) % this.capacity) {
            if (this.keys[i] === key) break;
        }
        this.keys[i] = key;
        this.values[i] = value;
        this.count++;
    }

    get(key) {
        for (let i = this._hash(key); this.keys[i] != null; i = (i + 1) % this.capacity) {
            if (this.keys[i] === key) return this.values[i];
        }
        return null;
    }

    remove(key) {
        for (var i = this._hash(key); this.keys[i] != null; i = (i + 1) % this.capacity) {
            if (this.keys[i] !== key) continue;
            this.keys[i] = null;
            this.values[i] = null;
            // rehash all keys in same cluster
            i = (i + 1) % this.capacity;
            while (this.keys[i] != null) 
            {
                const keyToRehash = this.keys[i], valToRehash = this.values[i];
                this.keys[i] = null;
                this.values[i] = null;
                this.count--;
                this.put(keyToRehash, valToRehash);
                i = (i + 1) % this.capacity;
            }                    
            this.count--;
            break;
        }
        if (this.count > 0 && this.count <= this.capaticy / 8) this._resize(this.capacity / 2);
    }

    _resize(size) {
        const temp = new LinearProbingHashTable(size);
        for (let i = 0; i < this.capacity; i++) 
        {
            if (this.keys[i] == null) continue;
            temp.put(this.keys[i], this.values[i]);
        }
        this.keys = temp.keys;
        this.values = temp.values;
        this.capacity = size;
    }

    _hash(key) {
        return key % this.capacity;
    }
}
