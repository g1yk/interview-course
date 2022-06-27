# https://leetcode.com/problems/implement-trie-prefix-tree/

class Trie
    def initialize
        @root = TrieNode.new
    end

    def insert(word)
        node = @root
        word.each_char do |c|
            node[c] ||= TrieNode.new
            node = node[c]
        end
        node.is_word = true
    end

    def search(word)
        node = find_node(word)
        !node.nil? && node.is_word
    end

    def starts_with(prefix)
        node = find_node(prefix)
        !node.nil?
    end

    private

    def find_node(prefix)
        node = @root
        prefix.each_char do |c|
            return nil if node[c].nil?
            node = node[c]
        end
        node
    end

    class TrieNode
        attr_accessor :is_word

        def initialize()
            @children = Array.new(26) # a to z
            @is_word = false
        end

        def [](c)
            @children[c.ord - 'a'.ord]
        end

        def []=(c, value)
            @children[c.ord - 'a'.ord] = value
        end
    end
end
