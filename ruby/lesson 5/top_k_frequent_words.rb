# https://leetcode.com/problems/kth-largest-element-in-an-array

Node = Struct.new(:word, :freq)

def top_k_frequent(words, k)
    freq = {}
    words.each { |word| freq[word] = (freq[word] || 0) + 1 }
    min_heap = MinHeap.new(k + 1)
    freq.each do |word, count|
        min_heap.add(Node.new(word, count))        
        min_heap.poll if min_heap.size > k
    end

    result = Array.new(min_heap.size)
    for i in (result.length - 1).downto(0)
        result[i] = min_heap.poll.word
    end

    result
end

# Do not implment on interview unless you have to
class MinHeap
    def initialize(capacity)
        @items = Array.new(capacity + 1)
        @count = 0
    end

    def size
        @count
    end

    def add(key)
        @count += 1
        @items[@count] = key
        swim(@count)
    end

    def poll
        result = @items[1]
        swap(1, @count)
        @count -= 1
        sink(1)
        result
    end

    def swim(k)
        while k > 1 and self.greater(k / 2, k)
            swap(k / 2, k)
            k = k / 2
        end
    end

    def sink(k)
        while 2 * k <= @count
            j = 2 * k
            j += 1 if j < @count && greater(j, j + 1)
            break if not greater(k, j)
                
            swap(k, j)
            k = j
        end
    end

    def swap(i, j)
        @items[i], @items[j] = @items[j], @items[i]
    end

    def greater(i, j)
        that = @items[i]
        other = @items[j]
        that.freq == other.freq ? that.word < other.word : that.freq > other.freq
    end
end
