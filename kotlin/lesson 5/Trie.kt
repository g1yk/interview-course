// https://leetcode.com/problems/implement-trie-prefix-tree/

class Trie() {
    private val root = TrieNode()

    fun insert(word: String) {
        var node = root;
        for (c in word) {
            val index = c - 'a'
            if (node[index] == null) {
                node[index] = TrieNode()
            }
            node = node[index]!!
        }
        node.isWord = true
    }

    fun search(word: String) = findNode(word)?.isWord ?: false

    fun startsWith(prefix: String) = findNode(prefix) != null
    
    private fun findNode(prefix: String): TrieNode? {
        var node = root;
        for (c in prefix) {
            val index = c - 'a'
            if (node[index] == null) return null
            node = node[index]!!
        }
        return node
    }

    private class TrieNode {
        val children = Array<TrieNode?>(26, { null }) // a to z
        var isWord = false

        operator fun get(index: Int) = children[index]
        operator fun set(index: Int, value: TrieNode) { children[index] = value }
    }
}
