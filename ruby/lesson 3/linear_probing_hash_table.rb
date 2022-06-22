class LinearProbingHashTable 
    INITIAL_CAPACITY = 4

    attr_reader :keys, :values

    def initialize(capacity = INITIAL_CAPACITY)
        @count = 0
        @capacity = capacity
        @keys = Array.new(capacity)
        @values = Array.new(capacity)
    end

    def put(key, value)
        resize(2 * @capacity) if @count >= @capacity / 2

        i = get_hash(key)
        until @keys[i].nil?
            break if key == @keys[i]
            i = (i + 1) % @capacity
        end

        @keys[i] = key
        @values[i] = value
        @count += 1
    end

    def get(key)
        i = get_hash(key)
        until @keys[i].nil?
            return @values[i] if key == @keys[i]
            i = (i + 1) % @capacity
        end
        nil
    end

    def remove(key)
        i = get_hash(key)
        until @keys[i].nil?
            if key != @keys[i]
                i = (i + 1) % @capacity
                next
            end
            @keys[i] = nil
            @values[i] = nil
            # rehash all keys in same cluster
            i = (i + 1) % @capacity
            until @keys[i].nil?
                key_to_rehash = @keys[i]
                val_to_rehash = @values[i]
                @keys[i] = nil
                @values[i] = nil
                @count -= 1
                put(key_to_rehash, val_to_rehash)
                i = (i + 1) % @capacity
            end
            @count -= 1
            break
        end
        resize(@capacity / 2) if @count.positive? && @count < @capacity / 8
    end

    private

    def get_hash(key)
        key.hash % @capacity
    end

    def resize(size)
        temp = LinearProbingHashTable.new(size)
        for i in 0..@capacity
            next if @keys[i].nil?
            temp.put(@keys[i], @values[i])
        end
        @keys = temp.keys
        @values = temp.values
        @capacity = size
    end
end
