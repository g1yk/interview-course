public class Graph(capacity: Int) {
    val adj = Array<LinkedList<Int>>(capacity)  { LinkedList<Int>() }
 
    fun get(v: Int): List<Int> = adj[v]
    
    fun add(v: Int, w: Int) {
        adj[v].add(w)
        adj[w].add(v)
    }
    
    fun size() = adj.size
}