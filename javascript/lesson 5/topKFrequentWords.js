// https://leetcode.com/problems/top-k-frequent-words/

function topKFrequent(words, k) {
    const freq = new Map();
    for (let word of words) {
        freq.set(word, (freq.get(word) || 0) + 1);
    }

    const minHeap = new MinHeap(k + 1);
    freq.forEach((freq, word) => {
        minHeap.add({ word, freq });
        if (minHeap.size() > k) {
            minHeap.poll();
        }
    });

    const result = new Array(minHeap.size());
    for (let i = result.length - 1; i >= 0; i--) {
        result[i] = minHeap.poll().word;
    }

    return result;
}

// Do not implement on interview
class MinHeap {
    constructor(capacity) {
        this.items = new Array(capacity + 1);
        this.count = 0;
    }

    size() {
        return this.count;
    }

    add(key) {
        this.count++;
        this.items[this.count] = key;
        this.swim(this.count);
    }

    poll() {
        const result = this.items[1];
        this.swap(1, this.count);
        this.count--;
        this.sink(1);
        return result;
    }

    swim(k) {
        while (k > 1 && this.greater(k >> 1, k)) {
            this.swap(k >> 1, k);
            k = k >> 1;
        }
    }

    sink(k) {
        while (2 * k <= this.count) {
            let j = 2 * k;
            if (j < this.count && this.greater(j, j + 1)) {
                j++;
            }
            if (!this.greater(k, j)) {
                break;
            }
            this.swap(k, j);
            k = j;
        }
    }

    swap(i, j) {
        [this.items[i], this.items[j]] = [this.items[j], this.items[i]];
    }

    greater(i, j) {
        const self = this.items[i];
        const other = this.items[j];
        return self.freq == other.freq ? self.word < other.word : self.freq > other.freq;
    }
}
