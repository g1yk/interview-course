# https://leetcode.com/problems/implement-trie-prefix-tree/

class TrieNode:
    def __init__(self):
        self.children = [None] * 26
        self.isWord = False

    def set(self, char, node):
        self.children[ord(char) - ord('a')] = node

    def get(self, char):
        return self.children[ord(char) - ord('a')]

class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        node  = self.root
        for c in word:
            if not node.get(c):
                node.set(c, TrieNode())
            node = node.get(c)
        node.isWord = True
        
    def search(self, word: str) -> bool:
        node = self.findNode(word)
        return node is not None and node.isWord

    def startsWith(self, prefix: str) -> bool:
        node = self.findNode(prefix)
        return node is not None
    
    def findNode(self, prefix: str) -> TrieNode:
        node  = self.root
        for c in prefix:
            node = node.get(c)
            if not node: return None
        return node        
