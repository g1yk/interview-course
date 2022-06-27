// https://leetcode.com/problems/implement-trie-prefix-tree/

class Trie {
    constructor() {
        this._root = new TrieNode();
    }

    insert(word) {
        let node = this._root;
        for (let c of word) {
            if (!node.get(c)) {
                node.set(c, new TrieNode());
            }
            node = node.get(c);
        }
        node.isWord = true;
    }

    search(word) {
        const node = this._findNode(word);
        return !!node && node.isWord;
    }

    startsWith(prefix) {
        const node = this._findNode(prefix);
        return !!node;
    }

    _findNode(prefix) {
        let node = this._root;
        for (let c of prefix) {
            node = node.get(c);
            if (!node) return null;
        }
        return node;
    }
}

class TrieNode {
    constructor() {
        this.children = new Array(26); // a to z
        this.isWord = false;
    }

    get(c) {
        return this.children[c.charCodeAt(0) - 'a'.charCodeAt(0)];
    }

    set(c, value) {
        this.children[c.charCodeAt(0) - 'a'.charCodeAt(0)] = value;
    }
}
