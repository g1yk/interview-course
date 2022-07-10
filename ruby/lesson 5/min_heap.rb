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
        @items[i] > @items[j]
    end
end
