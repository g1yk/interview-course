# https://leetcode.com/problems/design-hashmap/

class SeparateChainingHashTable 
    INITIAL_CAPACITY = 4

    attr_reader :buckets

    def initialize(capacity = INITIAL_CAPACITY)
        @count = 0
        @capacity = capacity
        @buckets = Array.new(capacity)
    end
    
    def put(key, value)
        resize(2 * @capacity) if @count >= 10 * @capacity

        i = get_hash(key)
        node = @buckets[i]
        until node.nil?
            if key == node.key
                node.value = value
                return
            end
            node = node.next
        end
        @buckets[i] = Node.new(key, value, @buckets[i])
        @count += 1
    end

    def get(key)
        node = @buckets[get_hash(key)]
        until node.nil?
            return node.value if key == node.key
            node = node.next
        end
        nil
    end

    def remove(key)
        i = get_hash(key)
        node = @buckets[i]
        prev = nil
        until node.nil?
            if key == node.key
                if prev.nil?
                    @buckets[i] = node.next
                else
                    prev.next = node.next
                end
                @count -= 1
                break
            end
            prev = node
            node = node.next
        end
        resize(this.capacity / 2) if @capacity > INITIAL_CAPACITY && @count <= 2 * @capacity
    end

    private

    def get_hash(key)
        key.hash % @capacity
    end

    def resize(size)
        temp = SeparateChainingHashTable.new(size)
        for i in 0..@capacity
            node = @buckets[i]
            until node.nil?
                temp.put(node.key, node.value)
                node = node.next
            end
        end
        @buckets = temp.buckets
        @capacity = size
    end

    class Node
        attr_accessor :key, :value, :next

        def initialize(key, value, next_node)
            @key = key
            @value = value
            @next = next_node
        end
    end
end
