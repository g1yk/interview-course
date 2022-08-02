class Graph {
    constructor(capacity) {
        this.adj = new Array(capacity);
        for (let i = 0; i < capacity; i++) {
            this.adj[i] = [];
        }
    }

    get(v) {
        return this.adj[v];
    }

    add(v, w) {
        this.adj[v].push(w);
        this.adj[w].push(v);
    }

    size() {
        return this.adj.length;
    }
}